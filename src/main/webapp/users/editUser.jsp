<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<%@ include file="header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
    <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate List of Users</a>
  </div>

  <!-- Content -->
  <%--          list all users --%>
  <table class="table table-bordered">
    <thead>
    <tr>
      <th>ID</th>
      <th>Username</th>
      <th>Email</th>
      <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td><c:out value="${user.id}" /></td>
      <td><c:out value="${user.userName}" /></td>
      <td><c:out value="${user.email}" /></td>
      <td><c:out value="${user.password}" /></td>
    </tr>
    <tr>
      <td><c:out value="${user.id}" /></td>

      <form action="<c:url value='/user/edit' />" method="get">
        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        <td><input type="text" name="userName" value="<c:out value='${user.userName}' />" class="form-control" /></td>
        <td><input type="text" name="email" value="<c:out value='${user.email}' />" class="form-control" /></td>
        <td><input type="text" name="password" value="<c:out value='${user.password}' />" class="form-control" /></td>
        <td><input type="submit" name="submit" value="Edit" class="btn btn-primary" /></td>
      </form>
      </td>
    </tr>
    </tbody>
  </table>



</div>
<!-- /.container-fluid -->

<%@ include file="footer.jsp" %>

</body>

</html>