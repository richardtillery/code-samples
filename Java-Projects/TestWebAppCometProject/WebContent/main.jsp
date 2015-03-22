<html>
<head>
<script>
function onLoad() {
var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function(e) {
	document.getElementById("richDiv").innerHTML = xhr.responseText;
}
xhr.open("GET", "http://localhost:8080/TestWebAppProject/tillery", true);
xhr.send();
}
</script>
</head>

<body onload="javascript:onLoad();">
Content from server: <div id="richDiv"></div>
</body>
</html>