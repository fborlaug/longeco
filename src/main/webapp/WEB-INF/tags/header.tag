<%@tag description="Overall Page template" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="pageheader">

  <nav class="navbar navbar-toggleable-md navbar-light bg-faded">

    <img src="<spring:url value='/public/images/logo_small.png'/>" width="60" height="60" class="d-inline-block align-top" alt="">
    <a class="navbar-brand" href="#">
      <h1 class="navbar-brand mb-0">Logeco</h1>
    </a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="<spring:url value='/home'/>">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<spring:url value='/week'/>">Week</a>
        </li>
      </ul>
      <form action="<spring:url value='/logout'/>" class="form-inline my-2 my-lg-0">
        <button class="btn btn-danger my-2 my-sm-0" type="submit" value="Sign Out">Sign Out</button>
      </form>
    </div>
  </nav>

</div>