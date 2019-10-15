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
<title>Fbill Page</title>
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
<a href="/Bill/list">check bills</a><br>
<p> </p>
<p> </p>
<p> </p>

<a href="/Oitems/list">check ordereditems</a><br>
<p> </p>
<p> </p>



 <spring:url value="/Fbill/add" var="addURL" />
 <a href="${addURL }">Add Fbill</a>

 <h1>Fbills List</h1>
 <table width="100%" border="1">
  <tr>
  
  
      <th> bill id</th>
   
   <th> fbilldate</th>
  
   <th> totalgross</th>
     <th> tax_gst</th>
     <th> totalamount</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listFbill }" var="Fbill" >
   <tr>
    
    <td>${Fbill.billid }</td>
   
    <td>${Fbill.fbilldate }</td>
       <td>${Fbill.totalgross }</td>
       <td>${Fbill.tax_gst }</td>
   <td>${Fbill. totalamount }</td>
   
   <!--   <td>
     <spring:url value="/Fbill/update/${Fbill.id }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>-->
    <td>
     <spring:url value="/Fbill/delete/${Fbill.id }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
<p>Click the button to print the current page.</p>

<button onclick="myFunction()">Print this page</button>

<script>
function myFunction() {
  window.print();
}
</script>
</body>
</html>