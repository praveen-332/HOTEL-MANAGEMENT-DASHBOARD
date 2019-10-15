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
<title>Oitems Page</title>
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
<a href="/Fbill/list">make bill</a><br>
<p> </p>
<p> </p>
<p> </p>


<a href="/Bill/add">click here to create billid</a><br>

 <spring:url value="/Oitems/add" var="addURL" />
 <a href="${addURL }">Add Oitems</a>

 <h1>Oitemss List</h1>
 <table width="100%" border="1">
  <tr>
  
   
   
      <th> bill id</th>
   
   <th> item id</th>
    
   <th> quantity</th>
     <th> item price</th>
     <th> igross</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listOitems }" var="Oitems" >
   <tr>
   
    <td>${Oitems.billid }</td>
    
    <td>${Oitems.iid }</td>
       <td>${Oitems.quantity }</td>
       <td>${Oitems.iprice }</td>
   <td>${Oitems. igross }</td>
    <td>
   
     <spring:url value="/Oitems/update/${Oitems.oid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Oitems/delete/${Oitems.oid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
 
 
 <!--  
 
 <br><br><br>
      
      
    <h1>Bills List</h1>
    
    Your billid is:
    <table width="100%" border="1">
    
  <tr>
  
  
   <th>Bill Id</th>
   
  
   
  </tr>
  <c:forEach items="${lastBill }" var="Bill" >
  
   <tr>
    <td>${Bill.billid }</td>
    
 <tr>
   
   
   </c:forEach>
  </table>-->
  
 
<p>Click the button to print the current page.</p>

<button onclick="myFunction()">Print this page</button>

<script>
function myFunction() {
  window.print();
}
</script>
</body>
</html>