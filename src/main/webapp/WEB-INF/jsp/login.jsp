<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Longeco</title>
</head>
<body>

<h1>Login</h1>
<form action="<spring:url value='/login'/>" method='POST'>
  <table>
    <tr>
      <td><label for="login.username">User:</label></td>
      <td><input id="login.username" type='text' name='username'></td>
    </tr>
    <tr>
      <td><label for="login.password">Password:</label></td>
      <td><input id="login.password" type='password' name='password'/></td>
    </tr>
    <tr>
      <td><input name="submit" type="submit" value="submit"/></td>
    </tr>
  </table>
</form>
</body>
</html>