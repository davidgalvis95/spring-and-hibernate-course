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
			
			//The following line just maps to the lite JSON file which does not have nested ojject neither arrays
			//Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			//Onthe other hand this line reads from the complex JSON object which uses an address object and an array of languages
			//This is why that we have implemented the Address POJO and the languages array in the student class
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);


						
			
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println("City = " + theStudent.getAddress().getCity());

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




