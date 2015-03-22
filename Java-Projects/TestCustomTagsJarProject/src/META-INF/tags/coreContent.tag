<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag body-content="scriptless"  %>
<%@ attribute name="area" %>
<%@ attribute name="var" required="true" rtexprvalue="false" %>
<%@ variable name-from-attribute="var" alias="name" scope="NESTED" %>
<c:set var="name" value="${ requestScope.firstName }"/>
<c:choose>
  <c:when test="${ area == 'top' }"> 
    <div style="color:crimson;" ><jsp:doBody/></div>
    <!-- A whole bunch of markup here.. -->
  </c:when>
  <c:otherwise>
    <div style="color:blue;" ><jsp:doBody/></div>
  </c:otherwise>
</c:choose>
