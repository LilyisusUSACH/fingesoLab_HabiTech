package com.IndustrialesComunes.HabiTech.Controllers;


import com.IndustrialesComunes.HabiTech.Controllers.request.CreateBuildingDTO;
import com.IndustrialesComunes.HabiTech.Controllers.request.CreateCommunityDTO;
import com.IndustrialesComunes.HabiTech.Controllers.request.CreateUnidadDTO;
import com.IndustrialesComunes.HabiTech.Controllers.request.CreateUserDTO;
import com.IndustrialesComunes.HabiTech.Models.BuildingEntity;
import com.IndustrialesComunes.HabiTech.Models.CommunityEntity;
import com.IndustrialesComunes.HabiTech.Models.UnidadEntity;
import com.IndustrialesComunes.HabiTech.repositories.BuildingRepository;
import com.IndustrialesComunes.HabiTech.repositories.CommunityRepository;
import com.IndustrialesComunes.HabiTech.repositories.UnidadRepository;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gadmin")
@PreAuthorize("hasRole('GADMIN')")
public class gadminController {

    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    UnidadRepository unidadRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/community")
    public ResponseEntity<?> getCommunities(){
        return ResponseEntity.ok(communityRepository.findAll());
    }

    @GetMapping("/buildings")
    public ResponseEntity<?> getBuildings(){
        return ResponseEntity.ok(buildingRepository.findAll());
    }

    @PostMapping("/createComunnity")
    public ResponseEntity<?> createCommunity(@Valid @RequestBody CreateCommunityDTO createCommunityDTO){
        CommunityEntity communityEntity = CommunityEntity.builder()
                .ubication(createCommunityDTO.getUbication())
                .build();
        communityRepository.save(communityEntity);
        return ResponseEntity.ok(communityEntity);
    }

    @PostMapping("/createBuilding")
    public ResponseEntity<?> createBuilding(@Valid @RequestBody CreateBuildingDTO createBuildingDTO){
        BuildingEntity buildingEntity = BuildingEntity.builder()
                .ubication(createBuildingDTO.getUbication())
                .community(communityRepository.findById(createBuildingDTO.getId_com()).orElseThrow())
                .build();
        buildingEntity.getCommunity().setNOfBuilds(buildingEntity.getCommunity().getNOfBuilds() + 1);
        buildingRepository.save(buildingEntity);
        return ResponseEntity.ok(buildingEntity);
    }

    @PostMapping("/createUnidad")
    public ResponseEntity<?> createUnidad(@Valid @RequestBody CreateUnidadDTO createUnidadDTO){
        UnidadEntity unidadEntity = UnidadEntity.builder()
                .ubication(createUnidadDTO.getUbication())
                .residente( userRepository.findById(createUnidadDTO.getResidenteID()).orElseThrow() )
                .edificio( buildingRepository.findById(createUnidadDTO.getResidenteID()).orElseThrow() )
                .m2( createUnidadDTO.getM2soloUnidad() )
                .build();
        unidadRepository.save(unidadEntity);
        return ResponseEntity.ok(unidadEntity);
    }

}