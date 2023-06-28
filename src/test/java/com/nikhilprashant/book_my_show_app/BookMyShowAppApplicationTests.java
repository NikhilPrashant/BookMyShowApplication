package com.nikhilprashant.book_my_show_app;

import com.nikhilprashant.book_my_show_app.Controller.UserController;
import com.nikhilprashant.book_my_show_app.Entities.UserEntity;
import com.nikhilprashant.book_my_show_app.EntryDTOs.UserEntryDto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookMyShowAppApplicationTests {

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetExpectedObject() {
		Response response = RestAssured.get("localhost:8080/users/add");
		String expected = "User added successfully";
		assertEquals(expected, response.getBody().toString(), "Unexpected status code");
	}

}
