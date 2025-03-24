package com.learn.Ecommerce;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.controller.UserController;
import com.learn.Ecommerce.entity.User;
import com.learn.Ecommerce.service.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void testGetUserById() throws Exception
	{
		 UserDto user = new UserDto();
		 user.setId("U123");
		 user.setFirstName("Neha");
		 user.setLastName("Sharma");
		 user.setAge(23);
		 user.setEmailId("neha@itvedant.com");
		 
		 Mockito.when(userService.getUserById("U123")).thenReturn(user);
		 
		 mockMvc.perform(get("/users/U123"))
		 .andExpect(status().isFound())
		 .andExpect(jsonPath("$.firstName").value("Neha"))
		 .andExpect(jsonPath("$.lastName").value("Sharma"));
	 
		 
	}
	
	@Test
	public void testAddUser() throws Exception
	{
		 UserDto user = new UserDto();
		 user.setId("U123");
		 user.setFirstName("Nitya");
		 user.setLastName("Sharma");
		 user.setAge(23);
		 user.setEmailId("nitya@itvedant.com");
		 user.setConfirmPassword("User@12345");
		 user.setPassword("User@12345");
		 
		 Mockito.when(userService.addUser(user)).thenReturn(user);
		 
		 ObjectMapper objectMapper = new ObjectMapper();
	
		
		 mockMvc.perform(post("/users")
				 .contentType("application/json")
				 .content("{\"id\":\"U123\",\"firstName\":\"Nitya\",\"lastName\":\"Sharma\",\"password\":\"User@12345\",\"confirmPassword\":\"User@12345\",\"age\":23,\"emailId\":\"nitya@itvedant.com\"}"))
		 .andExpect(status().isCreated())
		 .andExpect(jsonPath("$.firstName").value("Nitya"))
		 .andExpect(jsonPath("$.lastName").value("Sharma"));
		
		
	}
	
	
	
	
	
	
	

}
