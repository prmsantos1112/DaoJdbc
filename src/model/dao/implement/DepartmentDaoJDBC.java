package model.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Statement;

import dbase.DBASE;
import dbase.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection connection;

	public DepartmentDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void insert(Department objectiv) {

		PreparedStatement prepraredStat = null;

		try {
			prepraredStat = connection.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?)",
					Statement.RETURN_GENERATED_KEYS);

			prepraredStat.setString(1, objectiv.getName());

			int rowsAffected = prepraredStat.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet resultSet = prepraredStat.getGeneratedKeys();
				if (resultSet.next()) {
					int id = resultSet.getInt(1);
					objectiv.setId(id);
				}
			} else {
				throw new DbException("Unexpected Error !! No rows Affected !!");

			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DBASE.closeStatement(prepraredStat);
		}
	}

	@Override
	public void update(Department objectiv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
