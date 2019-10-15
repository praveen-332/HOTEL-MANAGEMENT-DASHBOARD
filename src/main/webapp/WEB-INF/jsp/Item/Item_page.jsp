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
<title>Item Page</title>
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




 <spring:url value="/Item/add" var="addURL" />
 <a href="${addURL }">Add Item</a>

 <h1>Items List</h1>
 <table width="100%" border="1">
  <tr>
   <th>Item Id</th>
   <th>Item name</th>
   <th>Item type</th>
     <th>Item price</th>
      <th>Item stock</th>
     
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listItem }" var="Item" >
   <tr>
    <td>${Item.iid }</td>
    <td>${Item.iname }</td>
    <td>${Item.itype }</td>
    <td>${Item.istock }</td>
    <td>
     <spring:url value="/Item/update/${Item.iid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Item/delete/${Item.iid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>