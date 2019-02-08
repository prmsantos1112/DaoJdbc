package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;



public class ProgramDaoJdbcTwo {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println();
		System.out.println("===== Test 1: Seller Insert =====");
		
		Department newDepartment = new Department(null, "Clothing");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted ! New Id: " + newDepartment.getId());

	}

}
