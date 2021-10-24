package com.company.week5;

public class UserService {
	
	public static User createUser(String [] array) {
		User user = new User();
		user.setUsername(array[0]);
		user.setPassword(array[1]);
		user.setName(array[2]);
        return user;		
	}

}
