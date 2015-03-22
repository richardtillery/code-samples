<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
<jsp:directive.page isErrorPage="true" contentType="text/html; charset=ISO-8859-1"/>
	<html>
	<head></head>
	<body>
	  <h1>Object Checker Page</h1>
	
	  <!-- Scriptlet Objects -->
	  <div>
	    <h2>Scriplet Objects: </h2>
	    <div style="padding-left: 30px;">
	      <jsp:expression>request</jsp:expression><br/><br/>
	      <jsp:expression>response</jsp:expression><br/><br/>
	      <jsp:expression>session</jsp:expression><br/><br/>
	      <jsp:expression>application</jsp:expression><br/><br/>
	      <jsp:expression>pageContext</jsp:expression><br/><br/>
	      <jsp:expression>out</jsp:expression><br/><br/>
	      <jsp:expression>exception</jsp:expression><br/><br/>
	      <jsp:expression>config</jsp:expression><br/><br/>
	      <jsp:expression>page</jsp:expression><br/><br/>
	      <jsp:expression>this</jsp:expression><br/><br/>
	    </div>
	  </div>
	  
	  <!-- EL Objects -->
	  <div>
	    <h2>EL Objects: </h2>
	    <div style="padding-left: 30px;">
	      ${ pageScope }<br/><br/>
	      ${ requestScope }<br/><br/>
	      ${ sessionScope }<br/><br/>
	      ${ applicationScope }<br/><br/>
	      ${ pageContext }<br/><br/>
	      ${ header }<br/><br/>
	      ${ headerValues }<br/><br/>
	      ${ param }<br/><br/>
	      ${ paramValues }<br/><br/>
	      ${ cookie }<br/><br/>
	      ${ initParam }<br/><br/>
	    </div>
	  </div>
	
	</body>
	</html>
</jsp:root>