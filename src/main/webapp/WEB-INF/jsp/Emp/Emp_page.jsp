<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: rgb(112, 169, 190);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Emp Page</title>
</head>
<body>

<p> </p>
<p> </p>
<p> </p>
<p> </p>
<a href="/">HOME</a><br>
<p> </p>
<p> </p>
<p> </p>
<a href="/Oitems/list">orderitems</a><br>
<p> </p>
<p> </p>
<p> </p>




 <spring:url value="/Emp/add" var="addURL" />
 <a href="${addURL }">Add Emp</a>

 <h1>Emps List</h1>
 <table width="100%" border="1">
  <tr>
  
   <th>Emp Id</th>
   
      <th>e_firstname </th>
<th> e_lastname</th>
<th>birthday </th>
<th> strtdate</th>
<th> e_sex</th>
<th> e_email</th>
<th>ephone</th>
<th>eaddress</th>
    
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listEmp }" var="Emp" >
   <tr>
    <td>${Emp.eid }</td>
    <td>${Emp.e_firstname }</td>
    
    <td>${Emp.e_lastname }</td>
    <td>${Emp.birthday }</td>
    <td>${Emp.strtdate }</td>
    <td>${Emp.e_sex }</td>
    <td>${Emp.e_email }</td>
<td>${Emp.ephone }</td> <td>${Emp.eaddress }</td>
    <td>
     <spring:url value="/Emp/update/${Emp.eid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Emp/delete/${Emp.eid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>