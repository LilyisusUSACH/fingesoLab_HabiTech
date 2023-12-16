package com.IndustrialesComunes.HabiTech;

import com.IndustrialesComunes.HabiTech.Models.ERole;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import com.IndustrialesComunes.HabiTech.Models.UserEntity;
import com.IndustrialesComunes.HabiTech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class HabiTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabiTechApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			UserEntity userEntity = UserEntity.builder()
					.email("alejesuscrts@gmail.com")
					.username("207220361")
					.rut(207220361)
					.password(passwordEncoder.encode("1234"))
					.roles(
							Set.of(
									RoleEntity.builder()
											.name(ERole.valueOf(ERole.SADMIN.name()))
											.build()
							)
					)
					.build();
			userRepository.save(userEntity);
		};
	}

}
