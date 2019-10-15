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

import com.telusko.model.Supplier;



@Repository
public class SupplierDaoImpl implements SupplierDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllSuppliers() {
			  String sql = "SELECT * from supplier";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new SupplierMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Supplier Supplier)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Supplier!= null)
		   {
			   paramSource.addValue("sid", Supplier.getSid());
			   paramSource.addValue("sname", Supplier.getSname());
			   paramSource.addValue("ssex", Supplier.getSsex());
			   paramSource.addValue("sdob", Supplier.getSdob());
			   paramSource.addValue("sphone", Supplier.getSphone());
			  // paramSource.addValue("sGSTIN", Supplier.getsGSTIN());
			 //  paramSource.addValue("sGSTIN", Supplier.getSGSTIN());
			   paramSource.addValue("location", Supplier.getLocation());

			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   /*public static final class SupplierMapper implements RowMapper<Supplier>
	   {
		   public Supplier mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Supplier Supplier=new Supplier();
			   Supplier.setSid(rs.getInt("sid"));
			   Supplier.setSname(rs.getString("sname"));
			   Supplier.setSsex(rs.getString("ssex"));
			   Supplier.setSdob(rs.getString("sdob"));
			  // Supplier.setsGSTIN(rs.getString("sGSTIN"));
			  // Supplier.setSGSTIN(rs.getString("sGSTIN"));
			   Supplier.setLocation(rs.getString("location"));
			   
			   return Supplier;
			   
		   }
	   }*/
	   
	   
	   private static final class SupplierMapper implements RowMapper<Supplier>
	   {
		   public Supplier mapRow(ResultSet rs,int rowNum) throws SQLException
		   {Supplier Supplier=new Supplier();
		   Supplier.setSid(rs.getInt("sid"));
		   Supplier.setSname(rs.getString("sname"));
		   Supplier.setSsex(rs.getString("ssex"));
		   Supplier.setSdob(rs.getString("sdob"));
		   Supplier.setSphone(rs.getLong("sphone"));
		   Supplier.setLocation(rs.getString("location"));
			   return Supplier;
			   
		   }
	   }
		@Override
		public void addSupplier(Supplier Supplier) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO "
					+ "supplier(sname,ssex,sdob,sphone,location) "
					+ "values (:sname,:ssex,:sdob,:sphone,:location)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Supplier));
		}

		@Override
		public void updateSupplier(Supplier Supplier) {
			// TODO Auto-generated method stub
			String sql="UPDATE supplier"
					+ " set sname= :sname,ssex=:ssex,sdob=:sdob,sphone=:sphone,location=:location"
					+ " where sid=:sid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Supplier));
			 
		}

		@Override
		public void deleteSupplier(int sid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM supplier WHERE sid=:sid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Supplier(sid)));
			
		}

		@Override
		public Supplier findSupplierById(int sid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM supplier WHERE sid=:sid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Supplier(sid)),new SupplierMapper() );
			
		}
		
		
}


