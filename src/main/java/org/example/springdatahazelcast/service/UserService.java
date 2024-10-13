package org.example.springdatahazelcast.service;

import org.example.springdatahazelcast.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    ResponseEntity<?> create(UserDto.CreateUserDto dto);

    ResponseEntity<?> get(Integer id);

    ResponseEntity<?> update(UserDto dto, Integer id);

    ResponseEntity<?> delete(Integer id);

    ResponseEntity<?> getAll();
}
