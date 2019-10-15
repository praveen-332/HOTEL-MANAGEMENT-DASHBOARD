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
  background-color: rgb(254, 232, 142);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Rawitem Page</title>
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
<p> </p>
<p> </p>
<p> </p>


<p> </p>
<p> </p>

<a href="/Supplier/list">Suppliers Table</a><br>

<p> </p>
<p> </p>


 <spring:url value="/Rawitem/add" var="addURL" />
 <a href="${addURL }">Add Rawitem</a>

 <h1>Rawitems List</h1>
 <table width="100%" border="1">
  <tr>
  
   <th>Rawitem Id</th>
   
      <th>Rawitem suppliedby</th>
   
   <th>Rawitem name</th>
    <th>Rawitem riprice</th>
    
      <th>Rawitem stock</th>
     

     
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listRawitem }" var="Rawitem" >
   <tr>
    <td>${Rawitem.rid }</td>
    <td>${Rawitem.suppliedby }</td>
        <td>${Rawitem.rquantity }</td>
    
        <td>${Rawitem.riprice }</td>
    
       
            <td>${Rawitem.rstock }</td>
    
  
    <td>
     <spring:url value="/Rawitem/update/${Rawitem.rid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Rawitem/delete/${Rawitem.rid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>