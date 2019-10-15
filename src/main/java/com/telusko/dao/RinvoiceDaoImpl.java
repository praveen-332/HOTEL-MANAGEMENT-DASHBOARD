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

import com.telusko.model.Rinvoice;



@Repository
public class RinvoiceDaoImpl implements RinvoiceDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllRinvoices() {
			  String sql = "SELECT * from raw_item_invoice";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new RinvoiceMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Rinvoice Rinvoice)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Rinvoice!= null)
		   {
			   paramSource.addValue("rrid", Rinvoice.getRrid());
			   paramSource.addValue("rid", Rinvoice.getRid());
			   paramSource.addValue("riprice", Rinvoice.getRiprice());
			   paramSource.addValue("rindate", Rinvoice.getRindate());
			   paramSource.addValue("riquantity", Rinvoice.getRiquantity());
			   paramSource.addValue("tax_gst", Rinvoice.getTax_gst());
			   paramSource.addValue("total_price",Rinvoice.getTotal_price());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class RinvoiceMapper implements RowMapper<Rinvoice>
	   {
		   public Rinvoice mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Rinvoice Rinvoice=new Rinvoice();
			   Rinvoice.setRrid(rs.getInt("rrid"));
			   Rinvoice.setRid(rs.getInt("rid"));
			  
			   Rinvoice.setRiprice(rs.getInt("riprice"));
			   Rinvoice.setRindate(rs.getString("rindate"));
			   Rinvoice.setRiquantity(rs.getInt("riquantity"));
			   Rinvoice.setTax_gst(rs.getInt("tax_gst"));
			   Rinvoice.setTotal_price(rs.getInt("total_price"));

			   return Rinvoice;
			   
		   }
	   }
		@Override
		public void addRinvoice(Rinvoice Rinvoice) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO raw_item_invoice(rid,riquantity,rindate)"
					+ " values (:rid,:riquantity,curdate())";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Rinvoice));
		}

		@Override
		public void updateRinvoice(Rinvoice Rinvoice) {
			// TODO Auto-generated method stub
			String sql="UPDATE Rinvoice "
					+ "set rid= :rid,riquantity=:riquantity"
					+ " where rrid=:rrid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Rinvoice));
			 
		}

		@Override
		public void deleteRinvoice(int rrid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM raw_item_invoice WHERE rrid=:rrid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Rinvoice(rrid)));
			
		}

		@Override
		public Rinvoice findRinvoiceById(int rrid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM raw_item_invoice WHERE rrid=:rrid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Rinvoice(rrid)),new RinvoiceMapper() );
			
		}
		
		

}
