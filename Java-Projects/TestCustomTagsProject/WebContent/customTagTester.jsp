<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
          xmlns:myTags="http://com.pst.tags/mytags"
          xmlns:myClassicTags="http://com.pst.tags.classic/myClassicTags"
          xmlns:myTagFileTags="http://com.pst.tags/myFileTags">
<jsp:directive.page contentType="text/html; charset=ISO-8859-1"/>
<html>
<head></head>
<body>
  <h1>Custom Tag Tester Page</h1>

  <!-- Tag File Test Tag -->
  <div>
    <h2>Tag File Test Tag: </h2>
    <div style="padding-left: 30px;">
      <myTagFileTags:coreContent area="top" var="name" >Content to be included - should be crimson - for ${ name }</myTagFileTags:coreContent>
      <myTagFileTags:coreContent area="unknown" var="name">Content to be included - should be blue -  for ${ name }</myTagFileTags:coreContent>
    </div>
  </div>

  <!-- Classic Iteration Test Tag -->
  <div>
    <h2>Classic Iteration Tag: </h2>
    <div style="padding-left: 30px;">
      <myClassicTags:forEach var="item" collection="${ classicIterationCollection }">
        Item: ${ item }<br/>
      </myClassicTags:forEach>
    </div>
  </div>
  
  <!-- Simple Iteration Test Tag -->
  <div>
    <h2>Simple Iteration Tag: </h2>
    <div style="padding-left: 30px;">
      <myTags:forEach var="item" collection="${ simpleIterationCollection }">
        Item: ${ item }<br/>
      </myTags:forEach>
    </div>
  </div>

  <!-- Simple Conditional Test Tag -->
  <div>
    <h2>Simple Choose/When/Otherwise Tags: </h2>
    <div style="padding-left: 30px;">
      <myTags:choose>
        <myTags:when test="${ testToDisplay == 1 }">
          First when, should not display
        </myTags:when>
        <myTags:when test="${ testToDisplay == 2 }">
          Second when, should display
        </myTags:when>
        <myTags:otherwise>
          Otherwise, should not display
        </myTags:otherwise>
      </myTags:choose>
    </div>
  </div>

  <!-- Simple Dynamic Attribute Tag -->
  <div>
    <h2>Simple Dynamic Attribute Tag: </h2>
    <div style="padding-left: 30px;">
      <myTags:dynamicAttributeTag style="${ providedStyles }"/>
    </div>
  </div>
  
</body>
</html>
          
</jsp:root>