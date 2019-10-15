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

import com.telusko.model.Feedback;



@Repository
public class FeedbackDaoImpl implements FeedbackDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		@Autowired
		public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
	{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
	}
		public List listAllFeedbacks() {
			  String sql = "SELECT * from feedback";
			  
			  List list = namedParameterJdbcTemplate
			.query(sql, getSqlParameterByModel(null), new FeedbackMapper());
			  
			  return list;
			 }
		
	   private SqlParameterSource getSqlParameterByModel(Feedback Feedback)
	   {
		   MapSqlParameterSource paramSource =new MapSqlParameterSource();
		   if(Feedback!= null)
		   {
			   paramSource.addValue("fid", Feedback.getFid());
			   paramSource.addValue("givenby", Feedback.getGivenby());
			   paramSource.addValue("fdate", Feedback.getFdate());
			   paramSource.addValue("remarks", Feedback.getRemarks());
			   }
		   
		 return paramSource;
	   }
	   
	   
	   
	   private static final class FeedbackMapper implements RowMapper<Feedback>
	   {
		   public Feedback mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Feedback Feedback=new Feedback();
			   Feedback.setFid(rs.getInt("fid"));
			   Feedback.setGivenby(rs.getString("givenby"));
			   Feedback.setFdate(rs.getString("fdate"));
			   Feedback.setRemarks(rs.getString("remarks"));
			   return Feedback;
			   
		   }
	   }
		@Override
		public void addFeedback(Feedback Feedback) {
			// TODO Auto-generated method stub
			String sql="INSERT INTO feedback(givenby,fdate,remarks)"
					+ " values (:givenby,curdate(),:remarks)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Feedback));
		}

		@Override
		public void updateFeedback(Feedback Feedback) {
			// TODO Auto-generated method stub
			String sql="UPDATE Feedback"
					+ " set givenby= :givenby,remarks=:remarks"
					+ " where fid=:fid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(Feedback));
			 
		}

		@Override
		public void deleteFeedback(int fid) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM feedback WHERE fid=:fid";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Feedback(fid)));
			
		}

		@Override
		public Feedback findFeedbackById(int fid) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM feedback WHERE fid=:fid";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Feedback(fid)),new FeedbackMapper() );
			
		}
		
		
}