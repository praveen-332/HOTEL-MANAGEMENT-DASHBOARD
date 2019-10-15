<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Supplier Form</title>
</head>
<body><p> </p>
<p> </p>
<a href="/">HOME</a><br>
<p> </p>
<p> </p><div>
 <spring:url value="/Supplier/save" var="saveURL" />
 <form:form modelAttribute="SupplierForm" method="post" action="${saveURL }" >
 <form:hidden path="sid"/>
  <table>

   <tr>
    <td>Supplier name: </td>
    <td>
     <form:input path="sname"/>
    </td>
   </tr>
   
   <tr>
    <td>Supplier Gender: </td>
    <td>
     <form:input path="ssex"/>
    </td>
   </tr>
   
   
   
   <tr>
    <td>Supplier DOB: </td>
    <td>
     <form:input path="sdob"/>
    </td>
   </tr>
   
    
   <tr>
    <td>Supplier phone </td>
    <td>
     <form:input path="sphone"/>
    </td>
   </tr>
   
   
    <tr>
    <td>Supplier Address: </td>
    <td>
     <form:input path="location"/>
    </td>
   </tr>
   
   <tr>
    <td></td>
    <td>
     <button type="submit">Save</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 </div>
</body>
</html>