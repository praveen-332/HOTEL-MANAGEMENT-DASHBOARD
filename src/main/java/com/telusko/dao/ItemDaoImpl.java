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

import com.telusko.model.Item;



@Repository
public class ItemDaoImpl implements ItemDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllItems() {
			  String sql = "SELECT * from item";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new ItemMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Item Item)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Item!= null)
		   {
			   paramSource.addValue("iid", Item.getIid());
			   paramSource.addValue("iname", Item.getIname());
			   paramSource.addValue("itype", Item.getItype());
			   paramSource.addValue("iprice", Item.getIprice());
			   paramSource.addValue("istock", Item.isIstock());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class ItemMapper implements RowMapper<Item>
	   {
		   public Item mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Item Item=new Item();
			   Item.setIid(rs.getInt("iid"));
			   Item.setIname(rs.getString("iname"));
			   Item.setItype(rs.getString("itype"));
			   Item.setIprice(rs.getInt("iprice"));
			   Item.setIstock(rs.getBoolean("istock"));
			   return Item;
			   
		   }
	   }
		@Override
		public void addItem(Item Item) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO item(iname,itype,iprice,istock)"
					+ " values (:iname,:itype,:iprice,:istock)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Item));
		}

		@Override
		public void updateItem(Item Item) {
			// TODO Auto-generated method stub
			String sql="UPDATE item "
					+ "set iname= :iname,itype=:itype,iprice=:iprice,istock=:istock"
					+ " where iid=:iid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Item));
			 
		}

		@Override
		public void deleteItem(int iid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM item WHERE iid=:iid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Item(iid)));
			
		}

		@Override
		public Item findItemById(int iid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM item WHERE iid=:iid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Item(iid)),new ItemMapper() );
			
		}
		
		

}
