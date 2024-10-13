package org.example.springdatahazelcast.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springdatahazelcast.dto.UserDto;
import org.example.springdatahazelcast.entity.User;
import org.example.springdatahazelcast.mapper.UserMapper;
import org.example.springdatahazelcast.repository.UserRepository;
import org.example.springdatahazelcast.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<?> create(UserDto.CreateUserDto dto) {
        User entity = this.userMapper.toEntity(dto);
        this.userRepository.save(entity);

        return ResponseEntity.ok(this.userMapper.toDto(entity));
    }

    @Override
    public ResponseEntity<?> get(Integer id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            return ResponseEntity.ok(this.userMapper.toDto(user));
        }
        return ResponseEntity.ok("User not found");
    }

    @Override
    public ResponseEntity<?> update(UserDto dto, Integer id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            this.userMapper.updateUser(dto, user);
            return ResponseEntity.ok(this.userMapper.toDto(user));
        }
        return ResponseEntity.ok("User not found");
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            this.userRepository.delete(user);
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.ok("User not found");
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<User> users = this.userRepository.findAll();
        if (!users.isEmpty()) {
            List<UserDto> dtoList = this.userMapper.dtoList(users);
            return ResponseEntity.ok(dtoList);
        }
        return ResponseEntity.ok("User list is empty");
    }
}
