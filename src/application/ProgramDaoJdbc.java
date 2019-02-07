package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramDaoJdbc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// Department objectiv = new Department(1, "Books");
		// Seller seller = new Seller(21, "Richard Geere", "richardgeere@gmail.com", new
		// Date(), 2880.0, objectiv);

		// Programa não conhece a Implementação; Somente a Interface; Injeção de
		// Dependência;

		System.out.println("===== Test 1: Seller findById =====");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);

		System.out.println("Impressão: " + seller);

		System.out.println();
		System.out.println("===== Test 2: Seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller objectiv : list) {
			System.out.println(objectiv);
		}

		System.out.println();
		System.out.println("===== Test 3: Seller findAll =====");
		list = sellerDao.findAll();

		for (Seller objectiv : list) {
			System.out.println(objectiv);
		}

		System.out.println();
		System.out.println("===== Test 4: Seller Insert =====");
		Seller newSeller = new Seller(null, "Jack Nickolson", "jacknic@gmail.com", new Date(), 3660.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted ! New Id = " + newSeller.getId());

		System.out.println();
		System.out.println("===== Test 5: Seller Update =====");
		seller = sellerDao.findById(1);
		seller.setName("Catharine Zetta");
		sellerDao.update(seller);
		System.out.println("Update Completed !!");
		
		System.out.println();
		System.out.println("===== Test 6: Seller Delete =====");
		System.out.print("Enter id for Delete Test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed !!");
		
		sc.close();

	}
}
