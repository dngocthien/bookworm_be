package com.nash.bookworm.services;

import com.nash.bookworm.entities.Userr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Userr saveUser(Userr userr);
    Userr getUserById(Long id);
    Userr getUserByEmail(String email);
    List<Userr> getAllUsers();
}
