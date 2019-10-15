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

import com.telusko.model.Customer;



@Repository
public class CustomerDaoImpl implements CustomerDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllCustomers() {
			  String sql = "SELECT * from customers";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new CustomerMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Customer Customer)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Customer!= null)
		   {
			   paramSource.addValue("cid", Customer.getCid());
			   paramSource.addValue("cname", Customer.getCname());
			   paramSource.addValue("csex", Customer.getCsex());
			   paramSource.addValue("cdob", Customer.getCdob());
			   paramSource.addValue("cphone", Customer.getCphone());
			   paramSource.addValue("caddress", Customer.getCaddress());

			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class CustomerMapper implements RowMapper<Customer>
	   {
		   public Customer mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Customer Customer=new Customer();
			   Customer.setCid(rs.getInt("cid"));
			   Customer.setCname(rs.getString("cname"));
			   Customer.setCsex(rs.getString("csex"));
			   Customer.setCdob(rs.getString("cdob"));
			   Customer.setCphone(rs.getLong("cphone"));
			   Customer.setCaddress(rs.getString("caddress"));
			   
			   return Customer;
			   
		   }
	   }
		@Override
		public void addCustomer(Customer Customer) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO "
					+ "customers(cname,csex,cdob,cphone,caddress) "
					+ "values (:cname,:csex,:cdob,:cphone,:caddress)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Customer));
		}

		@Override
		public void updateCustomer(Customer Customer) {
			// TODO Auto-generated method stub
			String sql="UPDATE customers"
					+ " set cname= :cname,csex=:csex,cdob=:cdob,cphone=:cphone,caddress=:caddress"
					+ " where cid=:cid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Customer));
			 
		}

		@Override
		public void deleteCustomer(int cid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM customers WHERE cid=:cid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Customer(cid)));
			
		}

		@Override
		public Customer findCustomerById(int cid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM customers WHERE cid=:cid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Customer(cid)),new CustomerMapper() );
			
		}
		
		
}