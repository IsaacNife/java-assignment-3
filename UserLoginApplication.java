package com.company.week5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("There was a File Not Found Exception");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("There was an I/O exception");
			e.printStackTrace();
			
		} finally {
			try {
				fileReader.close();
				
			} catch (IOException e) {
				System.out.println("There was a I/O exception");
				e.printStackTrace();
			}
		}
        
	}

}
