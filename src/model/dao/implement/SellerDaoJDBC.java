package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbase.DBASE;
import dbase.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection connection;
	
	public SellerDaoJDBC(Connection connection ) {
		this.connection = connection;
	}

	@Override
	public void insert(Seller objectiv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller objectiv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement prepraredStat = null;
		ResultSet resultSet = null;
		
		try {
			prepraredStat = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName " 
					+ "FROM seller INNER JOIN department "  
					+ "ON seller.DepartmentId = department.Id "  
					+ "WHERE seller.Id = ?");
			
			prepraredStat.setInt(1, id);
			resultSet = prepraredStat.executeQuery();
			
			if (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DepartmentId"));
				department.setName(resultSet.getString("DepName"));
				
				Seller objectiv = new Seller();
				objectiv.setId(resultSet.getInt("Id"));
				objectiv.setName(resultSet.getString("Name"));
				objectiv.setEmail(resultSet.getString("Email"));
				objectiv.setBaseSalary(resultSet.getDouble("BaseSalary"));
				objectiv.setBirthDate(resultSet.getDate("BirthDate"));
				objectiv.setDepartment(department);
				return objectiv;
			}
			return null;
			
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}	
		finally {
			DBASE.closeStatement(prepraredStat);
			DBASE.closeResultSet(resultSet);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
