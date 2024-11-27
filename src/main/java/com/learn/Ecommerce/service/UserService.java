package com.learn.Ecommerce.service;

import java.util.List;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;

public interface UserService {

// To add User
  UserDto addUser(UserDto userDto);
  
//To fetch all users
 List<UserDto> getAllUsers();
 
// To fetch user by Id
 UserDto getUserById(String id);
 
// update user by Id
 UserDto updateUser(String id,UserDto userDto);
 
// To delete user by Id
 String deleteUser(String id);
 
// Entity to DTO conversion
 UserDto entityToDto(User user);
 
// DTO to entity conversion
  User dtoToEntity(UserDto userDto);
  
  
  
 

}
