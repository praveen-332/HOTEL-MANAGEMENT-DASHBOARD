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

import com.telusko.model.Htax;



@Repository
public class HtaxDaoImpl implements HtaxDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllHtaxs() {
			  String sql = "SELECT * from htax";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new HtaxMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Htax Htax)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Htax!= null)
		   {
			   paramSource.addValue("returnid", Htax.getReturnid());
			   paramSource.addValue("hid", Htax.getHid());
			   paramSource.addValue("returnamount", Htax.getReturnamount());
			   paramSource.addValue("returntype",Htax.getReturntype());
			   paramSource.addValue("returndate", Htax.getReturndate());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class HtaxMapper implements RowMapper<Htax>
	   {
		   public Htax mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Htax Htax=new Htax();
			   Htax.setReturnid(rs.getInt("returnid"));
			   Htax.setHid(rs.getInt("hid"));
			   Htax.setReturntype(rs.getString("returntype"));
			   Htax.setReturnamount(rs.getInt("returnamount"));
			   Htax.setReturndate(rs.getString("returndate"));
			   return Htax;
			   
		   }
	   }
		@Override
		public void addHtax(Htax Htax) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO htax(hid,returnamount,returntype,returndate) "
					+ "values (:hid,:returnamount,:returntype,curdate())";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Htax));
		}

		@Override
		public void updateHtax(Htax Htax) {
			// TODO Auto-generated method stub
			String sql="UPDATE htax set hid= :hid,returnamount=:returnamount,"
					+ "returntype=:returntype"
					+ " where returnid=:returnid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Htax));
			 
		}

		@Override
		public void deleteHtax(int returnid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM htax WHERE returnid=:returnid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Htax(returnid)));
			
		}

		@Override
		public Htax findHtaxById(int returnid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM htax WHERE returnid=:returnid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Htax(returnid)),new HtaxMapper() );
			
		}
		
		
}