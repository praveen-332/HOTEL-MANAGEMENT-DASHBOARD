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

import com.telusko.model.Fbill;



@Repository
public class FbillDaoImpl implements FbillDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllFbills() {
			  String sql = "SELECT * from fbill";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new FbillMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Fbill Fbill)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Fbill!= null)
		   {
			   paramSource.addValue("id", Fbill.getId());
			   paramSource.addValue("billid", Fbill.getBillid());
			   paramSource.addValue("fbilldate", Fbill.getFbilldate());
			   paramSource.addValue("totalgross", Fbill.getTotalgross());
			   paramSource.addValue("tax_gst", Fbill.getTax_gst());
			  
			   paramSource.addValue("totalamount", Fbill.getTotalamount());
			 
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class FbillMapper implements RowMapper<Fbill>
	   {
		   public Fbill mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Fbill Fbill=new Fbill();
			   Fbill.setBillid(rs.getInt("id"));
			   Fbill.setBillid(rs.getInt("billid"));
			   
			   Fbill.setFbilldate(rs.getString("fbilldate"));
			 
			  
			   Fbill.setTotalgross(rs.getInt("totalgross"));
			   Fbill.setTax_gst(rs.getInt("tax_gst"));
			   Fbill.setTotalamount(rs.getInt("totalamount"));
			   return Fbill;
			   
		   }
	   }
		@Override
		public void addFbill(Fbill Fbill) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO fbill(billid,fbilldate)"
					+ " values (:billid,curdate())";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Fbill));
		}

		@Override
		public void updateFbill(Fbill Fbill) {
			// TODO Auto-generated method stub
			String sql="UPDATE fbill "
					+ "set billid=:billid"
					+ " where id=:id";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Fbill));
			 
		}

		@Override
		public void deleteFbill(int id) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM fbill WHERE id=:id";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Fbill(id)));
			
		}

		@Override
		public Fbill findFbillById(int id) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM fbill WHERE id=:id";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Fbill(id)),new FbillMapper() );
			
		}
		
		

}
