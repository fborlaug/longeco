<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:useBean id="week" scope="request" type="com.ambita.gui_model.Week"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Longeco</title>
</head>

<body>
<h1>Week</h1>

<label for="jumpWeek">Current week:</label><input type="week" id="jumpWeek" value="${week.year}-W<fmt:formatNumber minIntegerDigits="2" value="${week.weekNumber}" />" oninput="jumpWeek()"/>

<a href="<spring:url value='/week?weekYear=${week.previousWeekNumber}.${week.previousYear}'/>">Previous</a>
<a href="<spring:url value='/week?weekYear=${week.nextWeekNumber}.${week.nextYear}'/>">Next</a>

<a href="<spring:url value='/week'/>">Today</a>
<a href="<spring:url value='/home'/>">Home</a>

<spring:url value='/week' var="saveUrl"/>
<form:form action="${saveUrl}" modelAttribute="week">

  <form:hidden path="year"/>
  <form:hidden path="weekNumber"/>

  <table>
    <tr>
      <c:forEach items="${week.days}" var="day" varStatus="loopStatus">
        <td>
          <fmt:formatDate value="${day.date}" pattern="EEEE" var="nameOfDay"/>
          <div>${nameOfDay}</div>

          <form:input path="days[${loopStatus.index}].distance"/>

          <div>
            <form:errors path="days[${loopStatus.index}].distance"/>
          </div>

          <form:hidden path="days[${loopStatus.index}].date"/>
        </td>
      </c:forEach>
    </tr>
    <tr>
      <td colspan="7">
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
      </td>
    </tr>
  </table>

</form:form>

<form action="<spring:url value='/logout'/>">
  <input type="submit" value="Sign Out"/>
</form>
<script src="<spring:url value='/public/js/longeco.js'/>" type="application/javascript"></script>
</body>
</html>