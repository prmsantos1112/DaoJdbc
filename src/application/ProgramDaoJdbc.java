package application;

import model.entities.Department;

public class ProgramDaoJdbc {

	public static void main(String[] args) {
		
		Department objectiv = new Department(1, "Books");
		System.out.println("Impressão: " + objectiv);

	}

}
