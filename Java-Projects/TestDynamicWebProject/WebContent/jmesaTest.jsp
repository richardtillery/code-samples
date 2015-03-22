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
      <h1>JMesa Test</h1>
      <span>Note: The jmesa:tableModel tag must be child of a form tag.</span>
      <br>
      <br>
    </div>
    <div style="width:1500px;">
		<form id="testForm" action="jmesaTest" method="post">
			<jmesa:tableModel id="testTable" editable="false" items="${sessionScope.personList}" var="person" 
								view="com.pst.jmesa.view.CustomTableView" columnSort="com.pst.jmesa.view.CustomColumnSort" >
				<jmesa:htmlTable caption="People">
					<jmesa:htmlRow>
						<jmesa:htmlColumn sortable="true" property="personName" width="20%" title="Person Name" />
						<jmesa:htmlColumn sortable="true" property="age" width="10%" title="Age" />
						<jmesa:htmlColumn sortable="true" property="birthDate" width="10%" title="Pagan Birth Date" 
							pattern="MM/dd/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
						<jmesa:htmlColumn sortable="true" property="hireDate" width="10%" title="Hire Date" 
							pattern="MM/dd/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
						<jmesa:htmlColumn sortable="true" property="favoriteColor" width="10%" title="Favorite Color" />										
						<jmesa:htmlColumn sortable="true" property="hobbies" width="40%" title="Hobbies" 
							cellEditor="com.pst.jmesa.editor.ListCellEditor"/>									
					</jmesa:htmlRow>
				</jmesa:htmlTable>
			</jmesa:tableModel>
		</form>
	</div>
</body>
</html>