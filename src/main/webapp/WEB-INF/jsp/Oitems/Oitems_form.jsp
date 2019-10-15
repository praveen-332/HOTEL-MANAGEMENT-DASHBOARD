<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style>

input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  background-color: rgb(212, 209, 142);
  color: black;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Oitems Form</title>
</head>
<body><p> </p>
<p> </p>
<a href="/">HOME</a><br>
<p> </p>
<p> </p><div>
 <spring:url value="/Oitems/save" var="saveURL" />
 <form:form modelAttribute="OitemsForm" method="post" action="${saveURL }" >
 <form:hidden path="oid"/>
 


  
    <tr>
    <td>billid: </td>
    <td>
     <form:input path="billid"/>
    </td>
   </tr>
    <tr>
    <td>iid: </td>
    <td>
     <form:input path="iid"/>
    </td>
   </tr>
   

  
   
   <tr>
    <td>quantity: </td>
    <td>
     <form:input path="quantity"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
   
    
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
  </table>
   <br><br><br>
items available:
    <table width="100%" border="1">
    
  <tr>
  
  
   <th>iid</th>
   
    <th> name</th>
    <th>price</th>
    <th>type</th>
  </tr>
  <c:forEach items="${lisItems }" var="Item" >
  
   <tr>
    <td>${Item.iid }</td>
     <td>${Item.iname }</td>
     <td>${Item.iprice }</td>
     <td>${Item.itype }</td>
 <tr>
   
   </c:forEach>
  </table>
 </form:form>
 </div>
</body>
</html>