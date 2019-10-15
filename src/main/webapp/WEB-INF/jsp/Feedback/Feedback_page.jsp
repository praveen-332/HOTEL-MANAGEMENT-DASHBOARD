<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><style>
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
<title>Feedback Page</title>
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




 <spring:url value="/Feedback/add" var="addURL" />
 <a href="${addURL }">Add Feedback</a>

 <h1>Feedbacks List</h1>
 <table width="100%" border="1">
  <tr>
   <th>Feedback Id</th>
   <th> givenby</th>
   <th>date</th>
     <th> remarks</th>
   <th colspan="2">Action</th>
  </tr>
  <c:forEach items="${listFeedback }" var="Feedback" >
   <tr>
    <td>${Feedback.fid }</td>
    <td>${Feedback.givenby }</td>
    <td>${Feedback.fdate }</td>
    <td>${Feedback.remarks }</td>
    
    <!--  <td>
     <spring:url value="/Feedback/update/${Feedback.fid }" var="updateURL" />
     <a href="${updateURL }">Update</a>
    </td> -->
    
    <td>
     <spring:url value="/Feedback/delete/${Feedback.fid }" var="deleteURL" />
     <a href="${deleteURL }">Delete</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>