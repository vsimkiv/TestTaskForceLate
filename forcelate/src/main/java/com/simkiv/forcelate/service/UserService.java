package com.simkiv.forcelate.service;

import com.simkiv.forcelate.dto.UserDto;

public interface UserService {
    UserDto save(UserDto userDto);

    UserDto getOne(long id);
}
