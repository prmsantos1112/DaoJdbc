package application;



import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramDaoJdbc {

	public static void main(String[] args) {
		
		Department objectiv = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Richard Geere", "richardgeere@gmail.com", new Date(), 2880.0, objectiv);
		
		// Programa n�o conhece a Implementa��o; Somente a Interface;
		// Inje��o de Depend�ncia;
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("Impress�o: " + seller);

	}
}
