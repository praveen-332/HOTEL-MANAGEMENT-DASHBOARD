package com.telusko.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.telusko.model.Regis;

@Repository
public class RegisDaoImpl  implements RegisDao {
	

		 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
		{
			this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
		}
		
		public List listallregis() {
			String sql="SELECT username,email,password from regis";
			List list = namedParameterJdbcTemplate
					.query(sql,getsqlparameterbymodel(null),new RegisMapper());
			
			return list;
		}
		private SqlParameterSource getsqlparameterbymodel(Regis regis) {
			MapSqlParameterSource paramSource= new MapSqlParameterSource();
			if(regis!=null) {
				paramSource.addValue("username", regis.getUsername());
				paramSource.addValue("email", regis.getEmail());
				paramSource.addValue("password", regis.getPassword());
			}
			return paramSource;
		}
		private class RegisMapper implements RowMapper<Regis>{
			public Regis mapRow(ResultSet rs,int rowNum) throws SQLException
			   {
				Regis regis=new Regis();
				   regis.setUsername(rs.getString("username"));
				   regis.setEmail(rs.getString("email"));
				   regis.setPassword(rs.getString("password"));
				   return regis;
				   
			   }
		}
		@Override
		public void addregis(Regis regis) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO regis (username,email,password) values (:username,:email,:password)";
			namedParameterJdbcTemplate.update(sql,getsqlparameterbymodel(regis));
		}

		@Override
		public void updateregis(Regis regis) {
			// TODO Auto-generated method stub
			String sql="UPDATE regis set email=:email,password=:password where username= :username";
			namedParameterJdbcTemplate.update(sql,getsqlparameterbymodel(regis));
			 
		}

		@Override
		public void deleteregis(String username) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM regis WHERE username= :username";
			namedParameterJdbcTemplate.update(sql,getsqlparameterbymodel(new Regis(username)));
			
		}

		@Override
		public Regis findregisbyusername(String username) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM regis WHERE username= :username";
		return	namedParameterJdbcTemplate.queryForObject(sql, getsqlparameterbymodel(new Regis(username)),new RegisMapper() );
			
		}
		

}
