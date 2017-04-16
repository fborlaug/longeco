function jumpWeek() {
  var jumpWeekInput = document.getElementById("jumpWeek").value;
  var year = jumpWeekInput.substring(0, 4);
  var week = jumpWeekInput.substring(6, 8);
  window.location.href = "/week?year=" + year + "&weekNumber="+week;
}