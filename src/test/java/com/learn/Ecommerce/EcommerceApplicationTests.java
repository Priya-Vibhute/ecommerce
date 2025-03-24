package com.learn.Ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EcommerceApplicationTests {
	
	@Autowired
	CustomerService customerService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAdd()
	{
		Calculator calculator = new Calculator();
		int actualResult = calculator.add(10, 2);
		int expectedResult=12;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testIsEven()
	{
		Calculator calculator = new Calculator();
		int n=7013;
		assertEquals(false, calculator.isEven(n));
	}
	
	@Test
	public void testGetCustomer()
	{
		assertNotNull(customerService.getCustomer(0, "Gurjeet"));
	}
	
	
	

}
