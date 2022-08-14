package com.nash.bookworm.converter;

import com.nash.bookworm.dto.UserDto;
import com.nash.bookworm.entities.Userr;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public Userr toUser(UserDto dto){
        Userr userr = new Userr();
        userr.setFirstName(dto.getFirstName());
        userr.setLastName(dto.getLastName());
        userr.setEmail(dto.getEmail());
        userr.setPassword(dto.getPassword());
        return userr;
    }

    public UserDto toDto(Userr userr){
        UserDto dto = new UserDto();
        dto.setId(userr.getId());
        dto.setFirstName(userr.getFirstName());
        dto.setLastName(userr.getLastName());
        dto.setEmail(userr.getEmail());
        return dto;
    }
}
