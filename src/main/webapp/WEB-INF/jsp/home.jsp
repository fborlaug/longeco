<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:useBean id="total" scope="request" type="java.util.List<com.ambita.report.UserDistance>"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Longeco</title>
</head>

<body>
<h1>Home</h1>

<a href="<spring:url value='/week'/>">Register</a>

<form action="<spring:url value='/logout'/>">
  <input type="submit" value="Sign Out"/>
</form>

<h2>Ranking:</h2>

<table>
  <c:forEach items="${total}" var="userDistance">
    <tr>
      <td>
          ${userDistance.name}
      </td>
      <td>
          ${userDistance.distance}
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>