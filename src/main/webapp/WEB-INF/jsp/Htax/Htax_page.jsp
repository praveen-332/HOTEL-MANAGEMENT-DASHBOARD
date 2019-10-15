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
<title>Htax Page</title>
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
<a href="/Hotel/list">Hotels Table</a><br>
<p> </p>
<p> </p>

 <spring:url value="/Htax/add" var="addURL" />
 <a href="${addURL }">Add Htax</a>

 <h1>Htaxs List</h1>
 <table width="100%" border="1">
  <tr>
   <th>Htax Id</th>
   <th> hotel id</th>
   <th>date</th>
      <th>type</th>
   
     <th> return amount</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listHtax }" var="Htax" >
   <tr>
    <td>${Htax.returnid }</td>
    <td>${Htax.hid }</td>
    <td>${Htax.returnamount }</td>
    <td>${Htax.returntype }</td>
    <td>${Htax.returndate }</td>
    
    <td>
     <spring:url value="/Htax/update/${Htax.returnid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td>
    <td>
     <spring:url value="/Htax/delete/${Htax.returnid }" var="deleteURL" />
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