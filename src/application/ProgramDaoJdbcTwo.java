package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDaoJdbcTwo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println();
		System.out.println("===== Test 1: Department Insert =====");		
		Department newDepartment = new Department(null, "xxxxxxx");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted ! New Id: " + newDepartment.getId());
		
		System.out.println();
		System.out.println("===== Test 2: Department Update =====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update Completed");		
		
		System.out.println("=== TEST 3: Department findById =======");
		Department depto = departmentDao.findById(1);
		System.out.println(depto);
		
		
		System.out.println();
		System.out.println("===== Test 4: Department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department depatment : list) {
			System.out.println(depatment);

		}
		
		System.out.println();
		System.out.println("===== Test 5: Department Delete =====");
		System.out.print("Enter id for Delete Test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed !!");

		sc.close();

	}	

}
