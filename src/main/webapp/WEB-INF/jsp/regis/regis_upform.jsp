<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>regis Form</title>
</head>
<body>
 <spring:url value="/regis/up" var="upURL" />
 <form:form modelAttribute="regisupform" method="post" action="${upURL }" >
 <form:hidden path="username"/>
  <table>
  
   <tr>
    <td>Email: </td>
    <td>
     <form:input path="email" type="email"/>
    </td>
   </tr>
   <tr>
    <td>Password: </td>
    <td>
     <form:input path="password" type = "password" minlength="5"/>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">update</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>