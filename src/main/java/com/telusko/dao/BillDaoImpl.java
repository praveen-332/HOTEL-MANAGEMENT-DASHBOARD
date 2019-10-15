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

import com.telusko.model.Bill;



@Repository
public class BillDaoImpl implements BillDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllBills() {
			  String sql = "SELECT * from bill";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new BillMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Bill Bill)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Bill!= null)
		   {
			   paramSource.addValue("billid", Bill.getBillid());
			   paramSource.addValue("billdate", Bill.getBilldate());
			  /* paramSource.addValue("grossamount", Bill.getGrossamount());
			   paramSource.addValue("tax_gst", Bill.getTax_gst());
			  
			   paramSource.addValue("totalamount", Bill.getTotalamount());
			   paramSource.addValue("did", Bill.getDid());*/
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class BillMapper implements RowMapper<Bill>
	   {
		   public Bill mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Bill Bill=new Bill();
			   Bill.setBillid(rs.getInt("billid"));
			   Bill.setBilldate(rs.getString("billdate"));
			   /*
			   Bill.setGrossamount(rs.getInt("grossamount"));
			 
			   Bill.setTax_gst(rs.getInt("tax_gst"));
			   Bill.setTotalamount(rs.getInt("totalamount"));
               Bill.setDid(rs.getInt("did"));*/
			   return Bill;
			   
		   }
	   }
		@Override
		public void addBill(Bill Bill) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO bill(billdate)"
					+ " values (curdate())";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Bill));
		}

		@Override
		public void updateBill(Bill Bill) {
			// TODO Auto-generated method stub
			String sql="UPDATE Bill "
					+ "set billdate=:billdate"
					+ " where billid=:billid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Bill));
			 
		}

		@Override
		public void deleteBill(int billid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM bill WHERE billid=:billid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Bill(billid)));
			
		}

		@Override
		public Bill findBillById(int billid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM bill WHERE billid=:billid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Bill(billid)),new BillMapper() );
			
		}
		
		@Override
		public List lastBill() {
			String sql="Select * from bill order by billid desc limit 1";
			List list= namedParameterJdbcTemplate
					.query(sql,getSqlParameterByModel(null),new BillMapper());
			return list;
			
		}
		

}
