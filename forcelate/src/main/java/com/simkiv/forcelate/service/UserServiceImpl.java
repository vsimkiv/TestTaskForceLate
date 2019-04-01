package com.simkiv.forcelate.service;

import com.simkiv.forcelate.dto.UserDto;
import com.simkiv.forcelate.entity.User;
import com.simkiv.forcelate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDto save(UserDto userDto) {
        userRepo.save(toEntity(userDto));
        return userDto;
    }

    @Override
    public UserDto getOne(long id) {
        return toDto(userRepo.getOne(id));
    }


    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .build();
    }

    private User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .age(userDto.getAge())
                .build();
    }
}
