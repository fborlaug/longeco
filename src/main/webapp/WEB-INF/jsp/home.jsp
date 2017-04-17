<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:useBean id="totalUserDistances" scope="request" type="java.util.List<com.ambita.model.report.UserSum>"/>
<jsp:useBean id="totalUserCounts" scope="request" type="java.util.List<com.ambita.model.report.UserSum>"/>
<t:genericpage>
  <jsp:body>
    <br/>
    <h2>Ranking</h2>
    <div class="row">
      <div class="col">
        <table class="table">
          <thead>
          <tr>
            <th colspan="3">Total distance</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${totalUserDistances}" var="userDistance" varStatus="loopStatus">
            <tr>
              <th>
                ${loopStatus.index+1}
              </th>
              <td>
                  ${userDistance.name}
              </td>
              <td class="numberInTable">
                  ${userDistance.sum}
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="col">
        <table class="table">
          <thead>
          <tr>
            <th colspan="3">Number of times</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${totalUserCounts}" var="userCount" varStatus="loopStatus">
            <tr>
              <th >
                  ${loopStatus.index+1}
              </th>
              <td>
                  ${userCount.name}
              </td>
              <td class="numberInTable">
                  ${userCount.sum}
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
    <div class="row">
      <div class="col">
        <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
<script>
  Highcharts.chart('container', {
    chart: {
      plotBackgroundColor: null,
      plotBorderWidth: null,
      plotShadow: false,
      type: 'pie'
    },
    title: {
      text: 'Total distance'
    },
    tooltip: {
      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
      pie: {
        allowPointSelect: true,
        cursor: 'pointer',
        dataLabels: {
          enabled: true,
          format: '<b>{point.name}</b>: {point.percentage:.1f} %',
          style: {
            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
          }
        }
      }
    },
    series: [{
      name: 'Brands',
      colorByPoint: true,
      data: [
      <c:forEach items="${totalUserDistances}" var="userDistance" varStatus="loopStatus">
      {
        name: '${userDistance.name}',
        y: ${userDistance.sum}
      }<c:if test="${!loopStatus.last}">,</c:if>
      </c:forEach>
      ]
    }]
  });
</script>