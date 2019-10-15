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
<title>Customer Page</title>
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




 <spring:url value="/Customer/add" var="addURL" />
 <a href="${addURL }">Add Customer</a>

 <h1>Customers List</h1>
 <table width="100%" border="1">
  <tr>
  
   <th>Customer Id</th>
      <th>Customer name</th>
   
   <th>Customer Gender</th>
    <th>Customer DOB</th>
     <th>Customer phone</th>
     
   <th>Customer address</th>
     
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listCustomer }" var="Customer" >
   <tr>
    <td>${Customer.cid }</td>
    <td>${Customer.cname }</td>
        <td>${Customer.csex }</td>
    
        <td>${Customer.cdob }</td>
    
        <td>${Customer.cphone }</td>
    
    <td>${Customer.caddress }</td>
  
    <td>
     <spring:url value="/Customer/update/${Customer.cid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Customer/delete/${Customer.cid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>