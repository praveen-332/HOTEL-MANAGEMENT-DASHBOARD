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

import com.telusko.model.Hotel;



@Repository
public class HotelDaoImpl implements HotelDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllHotels() {
			  String sql = "SELECT * from hotel";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new HotelMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Hotel hotel)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(hotel!= null)
		   {
			   paramSource.addValue("hid", hotel.getHid());
			   paramSource.addValue("hname", hotel.getHname());
			   paramSource.addValue("haddress", hotel.getHaddress());
			   paramSource.addValue("hGSITN", hotel.gethGSITN());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class HotelMapper implements RowMapper<Hotel>
	   {
		   public Hotel mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Hotel hotel=new Hotel();
			   hotel.setHid(rs.getInt("hid"));
			   hotel.setHname(rs.getString("hname"));
			   hotel.setHaddress(rs.getString("haddress"));
			   hotel.sethGSITN(rs.getString("hGSITN"));
			   return hotel;
			   
		   }
	   }
		@Override
		public void addHotel(Hotel Hotel) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO hotel(hname,haddress,hGSITN) values (:hname,:haddress,:hGSITN)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Hotel));
		}

		@Override
		public void updateHotel(Hotel hotel) {
			// TODO Auto-generated method stub
			String sql="UPDATE hotel set hname= :hname,haddress=:haddress,hGSITN=:hGSITN"
					+ " where hid=:hid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(hotel));
			 
		}

		@Override
		public void deleteHotel(int hid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM hotel WHERE hid=:hid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Hotel(hid)));
			
		}

		@Override
		public Hotel findHotelById(int hid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM hotel WHERE hid=:hid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Hotel(hid)),new HotelMapper() );
			
		}
		
		
}