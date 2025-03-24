package com.learn.Ecommerce;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.learn.Ecommerce.entity.User;
import com.learn.Ecommerce.repository.UserRepository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
public class UserTest {
	
	@MockBean
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void setUp()
	{
		
		user=new User();
		user.setId("U1234");
        user.setFirstName("Nisha");
        user.setLastName("Sharma");
        user.setPassword("User@12345");
        user.setEmailId("nisha@itvedant.com");
        user.setAge(25);
        
        Optional<User> optionalUser = Optional.of(user);
       
        Mockito.when(userRepository.findById("U1234")).thenReturn(optionalUser);
        	
	}
	
	
	
	@Test
    public void testCreateUser()
    {
        User newUser = new User();
        newUser.setId("U1234");
        newUser.setFirstName("Nisha");
        newUser.setLastName("Sharma");
        newUser.setPassword("User@12345");
        newUser.setEmailId("nisha@itvedant.com");
        newUser.setAge(25);
        
        Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
        
        User savedUser = userRepository.save(newUser);
        assertNotNull(savedUser);
        assertEquals("Nisha", savedUser.getFirstName());
        
        
        
    }
	
	@Test
	public void testGetUserById()
	{
		User fetchedUser = userRepository.findById("U1234").get();
		String email="nisha@itvedant.com";
		assertEquals(email, fetchedUser.getEmailId());
		
	}
	
	@Test
	public void testUpdateUser()
	{
		user.setLastName("Gupta");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		User updatedUser = userRepository.save(user);
		
		assertEquals("Gupta", updatedUser.getLastName());
		
	}
	
	@Test
	public void testDeleteUser() {
		
		userRepository.deleteById("U1234");
		
		Mockito.verify(userRepository).deleteById("U1234");
		
		Mockito.when(userRepository.existsById("U1234")).thenReturn(false);
		assertFalse(userRepository.existsById("U1234"));
		
	}
	
	

}
