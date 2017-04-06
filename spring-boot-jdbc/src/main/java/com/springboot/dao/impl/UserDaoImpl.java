package com.springboot.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.base.JDBCTemplate;
import com.springboot.dao.IUserDao;
import com.springboot.domain.Users;

@Repository(value="userDaoImpl")
public class UserDaoImpl extends JDBCTemplate implements IUserDao {
	//继承jdbc模板
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	/**
	 * 获取所有的用户
	 *
	 * @return List
	 */
	public List<Users> getAll() {
		String sql = "SELECT * FROM users";

		List<Users> users = jdbcTemplate.query(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet resultSet, int i) throws SQLException {
				Users user = new Users();

				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassowrd(resultSet.getString("password"));
				return user;
			}
		});

		return users;
	}

	@Override
	public Users getUser(String username, String password) {
		String sql = "select * from users where username= '"+username+"'";
		Users user = jdbcTemplate.query(sql, new ResultSetExtractor<Users>(){

			@Override
			public Users extractData(ResultSet resultSet) throws SQLException, DataAccessException {
				Users user = null;
				if(resultSet.next()){
					user = new Users();
					user.setId(resultSet.getInt("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassowrd(resultSet.getString("password"));
				}
				return user;
			}});
		return user;
	}

	@Override
	public Users findById(Integer id) {
		String sql = "select * from users where id = " + id ;
		Users user = jdbcTemplate.query(sql, new ResultSetExtractor<Users>(){

			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				Users user = null;
				if(rs.next()){
					user = new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassowrd(rs.getString("password"));
				}
				return user;
			}
			
		});
		return user;
	}

	@Override
	public int updateUsers(Users users) {
		String sql = "update users u set u.username = ? , u.password = ? where u.id = ?";
		int flag = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, users.getUsername());
				preparedStatement.setString(2, users.getPassowrd());
				preparedStatement.setInt(3, users.getId());
				return preparedStatement;
			}
		});
		return flag;
	}

	@Override
	public int insertUsers(Users users) {
		String sql = "insert into users(username,password) values(?,?)";
		int flag = jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, users.getUsername());
				preparedStatement.setString(2, users.getPassowrd());
				return preparedStatement;
			}
			
		});
		return flag;
	}
	
}
