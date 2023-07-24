<%@page import="com.entity.Student"%>
<%@page import="com.conn.DbConncet"%>
<%@page import="com.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>


<div class="container">
<div class="row" >
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<p class="fs-3 text-center">Edit student</p>

<%
int id=Integer.parseInt(request.getParameter("id"));
StudentDao dao = new StudentDao(DbConncet.getCon()) ;
Student s= dao.getDetailById(id);
%>

<form action="update" method="post">

<div class="mb-3">
    <label class="form-label">Full Name</label>
    <input type="text" name="name" value="<%=s.getFullName() %> " class="form-control" >
  </div>

<div class="mb-3">
    <label class="form-label">D.O.B</label>
    <input type="text" name="dob" value="<%=s.getDob() %> " class="form-control" >
  </div>
  
  <div class="mb-3">
    <label class="form-label">Address</label>
    <input type="text" name="add" value="<%=s.getAddress() %> " class="form-control" >
  </div>
  
  
  <div class="mb-3">
    <label class="form-label">Qualification</label>
    <input type="text" name="qualification" value="<%=s.getQualification() %> " class="form-control" >
  </div>
  
  <div class="mb-3">
    <label class="form-label">Email address</label>
    <input type="email" name="email" value="<%=s.getEmail() %> " class="form-control" >
  </div>
  <input type="hidden" value="<%=s.getId()%>" name="id">
  
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>

</div>
</div>
</div>
</div>
</div>



</body>
</html>