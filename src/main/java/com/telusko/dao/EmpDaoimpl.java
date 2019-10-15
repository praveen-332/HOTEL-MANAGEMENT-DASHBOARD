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

import com.telusko.model.Emp;

@Repository
public class EmpDaoimpl implements EmpDao{
	
      NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}

	 public List listAllEmps() {
		  String sql = "SELECT eid,e_firstname,e_lastname,birthday,strtdate,e_sex,e_email,ephone,eaddress FROM emps";
		  //eid,e_firstname,e_lastname,birthday,strtdate,e_sex,e_email,ephone,eaddress
		  List list = namedParameterJdbcTemplate
		.query(sql, getSqlParameterByModel(null), new EmpMapper());
		  
		  return list;	
		 }
   private SqlParameterSource getSqlParameterByModel(Emp emp)
   {
	   MapSqlParameterSource paramSource =new MapSqlParameterSource();
	   if(emp!= null)
	   {
		   paramSource.addValue("eid", emp.getEid());
		   paramSource.addValue("e_firstname", emp.getE_firstname());
		   paramSource.addValue("e_lastname", emp.getE_lastname());
		  
		   paramSource.addValue("birthday",emp.getBirthday());
		   paramSource.addValue("strtdate",emp.getStrtdate());
		   paramSource.addValue("e_sex",emp.getE_sex());
		   paramSource.addValue("e_email",emp.getE_email());

		   paramSource.addValue("ephone",emp.getEphone());

	       paramSource.addValue("eaddress", emp.getEaddress());
	   }
	   
	   
	   return paramSource;
   }
   private static final class EmpMapper implements RowMapper<Emp>
   {
	   public Emp mapRow(ResultSet rs,int rowNum) throws SQLException
	   {
		   Emp emp=new Emp();
		   emp.setEid(rs.getInt("eid"));
		   emp.setE_firstname(rs.getString("e_firstname"));
		   emp.setE_lastname(rs.getString("e_lastname"));
		   emp.setBirthday(rs.getString("birthday"));
		   emp.setStrtdate(rs.getString("strtdate"));
		   emp.setE_sex(rs.getString("e_sex"));
		   emp.setE_email(rs.getString("e_email"));
		   emp.setEphone(rs.getString("ephone"));
		   
		   emp.setEaddress(rs.getString("eaddress"));
		   return emp;
		   
	   }
   }
   
	@Override
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO "
				+ "emps (e_firstname,e_lastname,birthday,strtdate,e_sex,e_email,ephone,eaddress) "
				+"values (:e_firstname,:e_lastname,:birthday,:strtdate,"
				+ ":e_sex,:e_email,:ephone,:eaddress)";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(emp));
	}

	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		String sql="UPDATE emps set e_firstname=:e_firstname,e_lastname=:e_lastname,"
				+ "birthday=:birthday,strtdate=:strtdate,e_sex=:e_sex,e_email=:e_email,"
				+ "ephone=:ephone,eaddress=:eaddress where eid=:eid";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(emp));
		 
	}

	@Override
	public void deleteEmp(int eid) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM emps WHERE eid=:eid";
		namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Emp(eid)));
		
	}

	@Override
	public Emp findEmpByeid(int eid) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM emps WHERE eid=:eid";
	return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Emp(eid)),new EmpMapper() );
		
	}

	
	

}
  