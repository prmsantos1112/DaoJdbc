package application;



import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class ProgramDaoJdbc {

	public static void main(String[] args) {
		
		Department objectiv = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Richard Geere", "richardgeere@gmail.com", new Date(), 2880.0, objectiv);
		
		System.out.println("Impressão: " + seller);

	}
}
