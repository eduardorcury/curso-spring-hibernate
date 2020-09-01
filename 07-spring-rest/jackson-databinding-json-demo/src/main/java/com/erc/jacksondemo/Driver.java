package com.erc.jacksondemo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// criando Object Mapper do Jackson
			ObjectMapper mapper = new ObjectMapper();
			
			// lendo arquivo JSON e convertendo para POJO
			Student theStudent = 
					mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// printando objeto
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			
			Address tempAddress = theStudent.getAddress();
			
			System.out.println("Street: " + tempAddress.getStreet());
			System.out.println("City: " + tempAddress.getCity());
			
			for (String language : theStudent.getLanguages()) {
				System.out.println(language);
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
