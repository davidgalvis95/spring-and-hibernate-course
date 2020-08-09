package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			//The following mapper code allow us to read code from the json file using the jackson dependency already set in the pom.xml
			
			Student theStudent = mapper.readValue(
						new File("data/sample-lite.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




