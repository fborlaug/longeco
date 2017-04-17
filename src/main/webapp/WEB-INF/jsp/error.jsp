<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:simplegenericpage>
  <jsp:body>
    <h1>Error</h1>
    <h2>An error was encountered.</h2>
    <a href="<spring:url value='/home'/>">Home</a>
  </jsp:body>
</t:simplegenericpage>