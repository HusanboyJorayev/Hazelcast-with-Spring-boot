package org.example.springdatahazelcast.mapper;

import lombok.RequiredArgsConstructor;
import org.example.springdatahazelcast.dto.UserDto;
import org.example.springdatahazelcast.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .build();
    }

    public User toEntity(UserDto.CreateUserDto user) {
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .age(user.getAge())
                .build();
    }

    public List<UserDto> dtoList(List<User> users) {
        if (!users.isEmpty()) {
            return users.stream().map(this::toDto).toList();
        }
        return new ArrayList<>();
    }

    public void updateUser(UserDto userDto, User user) {
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setAge(userDto.getAge());
    }
}
