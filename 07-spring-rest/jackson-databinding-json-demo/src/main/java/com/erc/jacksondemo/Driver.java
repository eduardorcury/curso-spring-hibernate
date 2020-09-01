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
					mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			// printando objeto
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
