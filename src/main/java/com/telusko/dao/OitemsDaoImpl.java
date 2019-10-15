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

import com.telusko.model.Oitems;



@Repository
public class OitemsDaoImpl implements OitemsDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllOitemss() {
			  String sql = "SELECT * from oitems";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new OitemsMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Oitems Oitems)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Oitems!= null)
		   {
			   paramSource.addValue("oid", Oitems.getOid());
			   paramSource.addValue("billid", Oitems.getBillid());
			   paramSource.addValue("iid", Oitems.getIid());
			   paramSource.addValue("quantity", Oitems.getQuantity());
			   paramSource.addValue("iprice", Oitems.getIprice());
			  
			   paramSource.addValue("igross", Oitems.getIgross());
			 
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class OitemsMapper implements RowMapper<Oitems>
	   {
		   public Oitems mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Oitems Oitems=new Oitems();
			   Oitems.setOid(rs.getInt("oid"));
			   Oitems.setBillid(rs.getInt("billid"));
			   
			   Oitems.setIid(rs.getInt("iid"));
			 
			  
			   Oitems.setQuantity(rs.getInt("quantity"));
			   Oitems.setIprice(rs.getInt("iprice"));
			   Oitems.setIgross(rs.getInt("igross"));
			   return Oitems;
			   
		   }
	   }
		@Override
		public void addOitems(Oitems Oitems) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO oitems(billid,iid,quantity)"
					+ " values (:billid,:iid,:quantity)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Oitems));
		}

		@Override
		public void updateOitems(Oitems Oitems) {
			// TODO Auto-generated method stub
			String sql="UPDATE Oitems "
					+ "set billid=:billid,iid=:iid,:quantity"
					+ " where oid=:oid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Oitems));
			 
		}

		@Override
		public void deleteOitems(int oid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM oitems WHERE oid=:oid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Oitems(oid)));
			
		}

		@Override
		public Oitems findOitemsById(int oid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM oitems WHERE oid=:oid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Oitems(oid)),new OitemsMapper() );
			
		}
		
		

}
