package com.nash.bookworm.services;

import com.nash.bookworm.dto.UserDto;
import com.nash.bookworm.entities.Userr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Userr saveUser(UserDto userr);
    Userr getUserByEmail(String email);
}
