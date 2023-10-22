package com.swadharma.bnsp.service;

import com.swadharma.bnsp.entity.User;
import com.swadharma.bnsp.payload.UserDto;
import com.swadharma.bnsp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto createNewUser(UserDto userDto){
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);
        UserDto res = mapToDto(newUser);
        return res;
    }

    public List<UserDto> getAllUser(){
        List<User> user = userRepository.findAll();
        return user.stream().map(user1 -> mapToDto(user1)).collect(Collectors.toList());
    }

    public UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNama(user.getNama());
        userDto.setEmail(user.getEmail());
        userDto.setTelepon(user.getTelepon());

        return userDto;
    }

    public User mapToEntity(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setNama(userDto.getNama());
        user.setEmail(userDto.getEmail());
        user.setTelepon(userDto.getTelepon());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
