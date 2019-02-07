package application;



import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class ProgramDaoJdbc {

	public static void main(String[] args) {
		
		// Department objectiv = new Department(1, "Books");		
		// Seller seller = new Seller(21, "Richard Geere", "richardgeere@gmail.com", new Date(), 2880.0, objectiv);
		
		// Programa não conhece a Implementação; Somente a Interface; Injeção de Dependência;
		
		System.out.println("===== Test 1: Seller findById =====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);		
		
		System.out.println("Impressão: " + seller);

	}
}
