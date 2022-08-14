package com.nash.bookworm.services.impl;

import com.nash.bookworm.converter.UserConverter;
import com.nash.bookworm.dto.UserDto;
import com.nash.bookworm.entities.Userr;
import com.nash.bookworm.repo.UserRepo;
import com.nash.bookworm.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserConverter userConverter;

    @Override
    public Userr saveUser(UserDto dto) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dto.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
        return userRepo.save(userConverter.toUser(dto));
    }

    @Override
    public Userr getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userr userr = userRepo.findByEmail(username);
        if (userr == null) {
            System.out.println("no user found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println(userr.toString());
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(userr.isAdmin()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        };
        return new org.springframework.security.core.userdetails.User(userr.getEmail(), userr.getPassword(), authorities);
    }

}
