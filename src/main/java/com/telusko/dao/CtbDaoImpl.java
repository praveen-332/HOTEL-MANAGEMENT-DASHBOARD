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

import com.telusko.model.Ctb;



@Repository
public class CtbDaoImpl implements CtbDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllCtbs() {
			  String sql = "SELECT * from ctbooking";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new CtbMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Ctb Ctb)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Ctb!= null)
		   {
			   paramSource.addValue("tbid", Ctb.getTbid());
			   paramSource.addValue("hid", Ctb.getHid());
			   paramSource.addValue("cid", Ctb.getCid());

			   paramSource.addValue("tnum", Ctb.getTnum());
			   
			  
			   paramSource.addValue("tbdate", Ctb.getTbdate());
			   paramSource.addValue("time", Ctb.getTime());
			   paramSource.addValue("datealloted", Ctb.getDatealloted());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class CtbMapper implements RowMapper<Ctb>
	   {
		   public Ctb mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Ctb Ctb=new Ctb();
			   Ctb.setTbid(rs.getInt("tbid"));
			   Ctb.setHid(rs.getInt("hid"));
			   Ctb.setCid(rs.getInt("cid"));

			   Ctb.setTnum(rs.getInt("tnum"));
			 
			   Ctb.setTbdate(rs.getString("tbdate"));
			   Ctb.setTime(rs.getString("time"));
			   Ctb.setDatealloted(rs.getString("datealloted"));
			   return Ctb;
			   
		   }
	   }
		@Override
		public void addCtb(Ctb Ctb) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO ctbooking(hid,cid,tnum,tbdate,datealloted,time)"
					+ " values (:hid,:cid,:tnum,curdate(),:datealloted,:time)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Ctb));
		}

		@Override
		public void updateCtb(Ctb Ctb) {
			// TODO Auto-generated method stub
			String sql="UPDATE ctbooking "
					+ "set hid=:hid,cid=:cid,tnum=:tnum,"
					+ "datealloted=:datealloted,time=:time"
					+ " where tbid=:tbid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Ctb));
			 
		}

		@Override
		public void deleteCtb(int Ctbid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM ctbooking WHERE tbid=:tbid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Ctb(Ctbid)));
			
		}

		@Override
		public Ctb findCtbById(int Ctbid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM ctbooking WHERE tbid=:tbid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Ctb(Ctbid)),new CtbMapper() );
			
		}
		
		

}
