package org.example.springdatahazelcast.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.springdatahazelcast.dto.UserDto;
import org.example.springdatahazelcast.service.UserService;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "USER CONTROLLER")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CacheConfig(cacheNames = "users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserDto.CreateUserDto dto) {
        return ResponseEntity.ok(userService.create(dto));
    }

    @GetMapping
    @Cacheable(key = "#id")
    public ResponseEntity<?> get(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.userService.get(id));
    }

    @PutMapping
    @CachePut(key = "#id")
    public ResponseEntity<?> update(@RequestParam("id") Integer id,
                                    @RequestBody UserDto dto) {
        return ResponseEntity.ok(this.userService.update(dto, id));
    }

    @DeleteMapping
    @CacheEvict(key = "#id")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }

    @GetMapping("/getAll")
    @Cacheable(key = "#root.method.name")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }
}
