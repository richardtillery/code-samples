<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa" %>
<html>
<head>
	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath  }/css/jmesa.css" type="text/css" />
	<script type="text/javascript" src="${ pageContext.servletContext.contextPath }/script/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="${ pageContext.servletContext.contextPath }/script/jmesa/jmesa.min.js"></script>
	<script type="text/javascript" src="${ pageContext.servletContext.contextPath }/script/jmesa/jquery.jmesa.min.js"></script>
	<script>
		//JMesa callback - should be overridden by pages
		function onInvokeAction(id, action) {
    		createHiddenInputFieldsForLimitAndSubmit(id);
		}
	</script>
</head>

<body>
    <div>
      <h1>JMesa API Test</h1>
      <span>Note: The jmesa:tableModel tag must be child of a form tag.</span>
      <br>
      <br>
    </div>
    <div style="width:1500px;">
		<form id="testForm" action="jmesaApiTest" method="post">
		  ${ apiTestTable }
		</form>
	</div>
</body>
</html>