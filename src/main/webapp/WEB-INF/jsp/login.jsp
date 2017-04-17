<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:simplegenericpage>
  <jsp:body>
    <div class="container">
      <div class="jumbotron">
        <h1>Login</h1>
        <form action="<spring:url value='/login'/>" method='POST'>
          <table>
            <tr>
              <td><label for="login.username">User</label></td>
              <td><input class="form-control" id="login.username" type='text' name='username'></td>
            </tr>
            <tr>
              <td><label for="login.password">Password</label></td>
              <td><input class="form-control" id="login.password" type='password' name='password'/></td>
            </tr>
            <tr>
              <td><button type="submit" class="btn btn-primary" value="Login">Login</button></td>

            </tr>
          </table>
        </form>
      </div>
    </div>
  </jsp:body>
</t:simplegenericpage>