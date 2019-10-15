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

import com.telusko.model.Expences;



@Repository
public class ExpencesDaoImpl implements ExpencesDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllExpencess() {
			  String sql = "SELECT * from expences";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new ExpencesMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Expences Expences)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Expences!= null)
		   {
			   paramSource.addValue("expid", Expences.getExpid());
			   paramSource.addValue("hid", Expences.getHid());
			   paramSource.addValue("expamount", Expences.getExpamount());
			   paramSource.addValue("expdate", Expences.getExpdate());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class ExpencesMapper implements RowMapper<Expences>
	   {
		   public Expences mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Expences Expences=new Expences();
			   Expences.setExpid(rs.getInt("expid"));
			   Expences.setHid(rs.getInt("hid"));
			   Expences.setExpamount(rs.getString("expamount"));
			   Expences.setExpdate(rs.getString("expdate"));
			   return Expences;
			   
		   }
	   }
		@Override
		public void addExpences(Expences Expences) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO expences(hid,expamount,expdate) values (:hid,:expamount,curdate())";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Expences));
		}

		@Override
		public void updateExpences(Expences Expences) {
			// TODO Auto-generated method stub
			String sql="UPDATE expences set hid= :hid,expamount=:expamount"
					+ " where expid=:expid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Expences));
			 
		}

		@Override
		public void deleteExpences(int expid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM expences WHERE expid=:expid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Expences(expid)));
			
		}

		@Override
		public Expences findExpencesById(int expid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM expences WHERE expid=:expid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Expences(expid)),new ExpencesMapper() );
			
		}
		
		
}