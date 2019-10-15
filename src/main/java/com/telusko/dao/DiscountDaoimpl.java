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

import com.telusko.model.Discount;



@Repository
public class DiscountDaoimpl implements DiscountDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllDiscounts() {
			  String sql = "SELECT * from discount";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new DiscountMapper());
			  
			  return list;
			 }
	   private SqlParameterSource getSqlParameterByModel(Discount discount)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(discount!= null)
		   {
			   paramSource.addValue("did", discount.getDid());
			   paramSource.addValue("per", discount.getPer());
			   paramSource.addValue("validtill", discount.getValidtill());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class DiscountMapper implements RowMapper<Discount>
	   {
		   public Discount mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Discount discount=new Discount();
			   discount.setDid(rs.getInt("did"));
			   discount.setPer(rs.getInt("per"));
			   discount.setValidtill(rs.getString("validtill"));
			   return discount;
			   
		   }
	   }
		@Override
		public void addDiscount(Discount discount) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO discount (per,validtill) values (:per,:validtill)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(discount));
		}

		@Override
		public void updateDiscount(Discount discount) {
			// TODO Auto-generated method stub
			String sql="UPDATE discount set per= :per,validtill=:validtill where did=:did";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(discount));
			 
		}

		@Override
		public void deleteDiscount(int did) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM discount WHERE did=:did";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Discount(did)));
			
		}

		@Override
		public Discount findDiscountById(int did) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM discount WHERE did=:did";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Discount(did)),new DiscountMapper() );
			
		}
		
		
}

