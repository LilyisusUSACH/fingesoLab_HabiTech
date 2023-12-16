package com.IndustrialesComunes.HabiTech.repositories;

import com.IndustrialesComunes.HabiTech.Models.MessageEntity;
import com.IndustrialesComunes.HabiTech.Models.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByReceiver_Username(String username);

}
