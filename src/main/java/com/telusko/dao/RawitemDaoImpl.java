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

import com.telusko.model.Rawitem;



@Repository
public class RawitemDaoImpl implements RawitemDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllRawitems() {
			  String sql = "SELECT * from rawitem";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new RawitemMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Rawitem Rawitem)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Rawitem!= null)
		   {
			   paramSource.addValue("rid", Rawitem.getRid());
			   paramSource.addValue("suppliedby", Rawitem.getSuppliedby());
			   paramSource.addValue("rquantity", Rawitem.getRquantity());
			   paramSource.addValue("riprice", Rawitem.getRiprice());
			   paramSource.addValue("rstock", Rawitem.isRstock());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class RawitemMapper implements RowMapper<Rawitem>
	   {
		   public Rawitem mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Rawitem Rawitem=new Rawitem();
			   Rawitem.setRid(rs.getInt("rid"));
			   Rawitem.setSuppliedby(rs.getInt("suppliedby"));
			   Rawitem.setRquantity(rs.getString("rquantity"));
			   Rawitem.setRiprice(rs.getInt("riprice"));
			   Rawitem.setRstock(rs.getBoolean("rstock"));
			   return Rawitem;
			   
		   }
	   }
		@Override
		public void addRawitem(Rawitem Rawitem) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO rawitem(suppliedby,rquantity,riprice,rstock)"
					+ " values (:suppliedby,:rquantity,:riprice,:rstock)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Rawitem));
		}

		@Override
		public void updateRawitem(Rawitem Rawitem) {
			// TODO Auto-generated method stub
			String sql="UPDATE Rawitem "
					+ "set suppliedby= :suppliedby,rquantity=:rquantity,riprice=:riprice,rstock=:rstock"
					+ " where rid=:rid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Rawitem));
			 
		}

		@Override
		public void deleteRawitem(int rid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM rawitem WHERE rid=:rid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Rawitem(rid)));
			
		}

		@Override
		public Rawitem findRawitemById(int rid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM rawitem WHERE rid=:rid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Rawitem(rid)),new RawitemMapper() );
			
		}
		
		

}
