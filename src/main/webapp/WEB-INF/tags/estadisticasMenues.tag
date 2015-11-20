<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<canvas id="canvas" height="450" width="600"></canvas>

<script>
var BarChart = {
 labels: ["Menu1", "Menu2", "Menu3", "Menu4", "Menu5"],
 datasets: [{
 fillColor: "rgba(151,249,190,0.5)",
 strokeColor: "rgba(255,255,255,1)",
 data: [13, 20, 30, 40, 50]
 }, {
 fillColor: "rgba(252,147,65,0.5)",
 strokeColor: "rgba(255,255,255,1)",
 data: [28, 68, 40, 19, 96]
 }]
}
var myBarChart = new Chart(document.getElementById("canvas").getContext("2d")).Bar(BarChart, {scaleFontSize : 13, scaleFontColor : "#ffa45e"});
</script>
