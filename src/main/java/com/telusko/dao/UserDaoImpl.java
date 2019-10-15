package com.telusko.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.telusko.model.User;
@Repository
public class UserDaoImpl implements UserDao{
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllUsers() {
		  String sql = "SELECT id, firstname, lastname, address FROM users";
		  
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new UserMapper());
		  
		  return list;
		 }
   private SqlParameterSource getSqlParameterByModel(User user)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(user!= null)
	   {
		   paramSource.addValue("id", user.getId());
		   paramSource.addValue("firstname", user.getFirstname());
		   paramSource.addValue("lastname", user.getLastname());
		   paramSource.addValue("address", user.getAddress());
		   
	   }
	   
	   
	   return paramSource;
   }
   private static final class UserMapper implements RowMapper<User>
   {
	   public User mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   User user=new User();
		   user.setId(rs.getInt("id"));
		   user.setFirstname(rs.getString("firstname"));
		   user.setLastname(rs.getString("lastname"));
		   user.setAddress(rs.getString("address"));
		   return user;
		   
	   }
   }
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO users (firstname,lastname,address) values (:firstname,:lastname,:address)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(user));
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql="UPDATE users set firstname= :firstname,lastname=:lastname,address=:address where id=:id";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(user));
		 
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM users WHERE id=:id";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new User(id)));
		
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM users WHERE id=:id";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)),new UserMapper() );
		
	}
	

}
  