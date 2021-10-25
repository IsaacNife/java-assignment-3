package com.company.week5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);

		BufferedReader fileReader = null;
		String userInfo;
		 User[] users = new User[4];
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 4; i++) {
				userInfo = fileReader.readLine();
				users[i] = userService.createUser(userInfo.split(","));


			}
		} catch (FileNotFoundException e) {
			System.out.println("There was a File Not Found Exception");
			e.printStackTrace();
	@@ -30,6 +41,31 @@ public static void main(String[] args) {
				e.printStackTrace();
			}
		}

		String username;
		String password;
		int userAttempts = 0;
		boolean loggedIn = false;

		while(loggedIn != true) {
			System.out.println("Enter your username:");
			username = scanner.nextLine();
			System.out.println("Enter your password:");
			password = scanner.nextLine();
			User user = userService.getValidUser(username, password, users);
			if (user == null) {
				System.out.println("Invalid login, please try again");
				userAttempts++;

			} else if (user != null) {
				loggedIn = true;
			}
			if (userAttempts == 5) {
				System.out.println("Too many failed logon attempts, you are now locked out.");
				break;
			}
		}
		scanner.close();

	