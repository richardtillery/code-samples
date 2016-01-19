Each project in this repo contains a README directly under the project's directory root - they are also all below:  

# Java-Projects/TestWebAppCometProject

Comet example, coded up against Tomcat 8.0.  Launch main.jsp and watch the Comet!

Also a simple custom tag example.

# Java-Projects/TestCustomTagsProject

This project contains a 'test harness' for the tags in the TestCustomTagsJarProject.  You must jar that project up and 
include it in the lib folder of this .war for it to work.  To test, request the URL /TestCustomTagsProject/customTagTester (the 
servlet sets up the test data).

This project also contains a couple of test jsps that output all the implicit JSP and EL objects - request the url
/TestCustomTagsProject/objectCheckerRedirect.jsp to test this out.

Note the jsps in this project are in the JSP Document format (as in: well-formed XML documents).  

# Java-Projects/TestDynamicJarProject

This jar contains the SPI configuration to tell the container there is a ServletContainerInitializer it needs to execute when 
the web app containing this jar is deployed.

It also contains an example of xsd usage and programmatic validation of an xml document with provided xsds.

# Java-Projects/TestWebEar

This ear contains   
	TestWebProject  
	TestWebProject1

The entire purpose of these two projects is to demonstrate that one web app can fetch the attributes of another web app's context.

To demonstrate, hit /TestWebProject/tillery and notice the 'Howdy! null' message.   
Then hit /TestWebProject1/newtillery.   
Then hit /TestWebProject/tillery and notice the null is gone - the other app set an attribute the first app fetched

# Java-Projects/TestDynamicWebEar

This ear contains  
TestCustomTagsProject (tests custom tags)  
TestDynamicWebProject (test programmatically creating/deploying servlets/filters/listeners)

# Java-Projects/TestDynamicWebProject

This project tests dynamic creation/deployment of servlets/filters/listeners.
This project needs TestDynamicJarProject in it's lib folder (it doesn't have to be exported as a jar first, let 
Eclipse do it's thing and automatically include the project in the lib folder).
See ServletContainerInitializerImpl for a starting point in seeing what the code is doing.

This project also contains two JMesa tests, one to test declaratively creating a table and one to test programmatically
creating a table (note: the programmatically created table's sorting doesn't work, no clue why not).
To test, use these two URLs: 

		/TestDynamicWebProject/jmesaTest (the declarative method) and 
		/TestDynamicWebProject/jmesaApiTest (the programmatic method)
	
Again, this project is configured for WebLogic, you'll need to remove those project facets and add your own runtime container.

# Java-Projects/TestCustomTagsJarProject

This project MUST be exported into a jar and included in your .war's lib for containers to properly load up the tlds 
(at least, it does for WebLogic 12.1.3 and Tomcat 8.0).

Note that WebLogic 12.1.3 does not load the tld for the tag file (but does load the other tlds).  
Tomcat 8.0 does not have that problem.

This project contains a classic tag, several simple tags, and a tag file.

This project is currently configured as a WebLogic project, you'll need to remove that and add your container's 
runtime instead.

A reminder: if you use Tomcat, you'll need to download and include the JSTL library in your .war's lib as well.

# Java-Projects/TestSpringMVCHibernateProject

This project requires a lot of setup.
It is currently configured for WebLogic, you'll need to change that to your container.  
It is also set up to hit Oracle DB, you'll need to change that to your DB.  You'll also need to create the schema and tables (just two tables).

This project is a Spring MVC + Hibernate example.  JQuery is used in the UI to make Ajax calls.  The UI allows for CRUD operations on a person table in the DB.

This is a Maven project so your version of Eclipse must have that capability (this was made with Eclipse Luna).  Look at the pom and grab those jars (or replace them with comparable jars) as needed.  You'll need Maven set up on your box.

This war is not associated with an .ear, so if your container requires that (doesn't create a default for you), you'll need to create one.

# Java-Projects/TestHibernateJarProject

This project is a java app (not a web app, therefore this doesn't need to run on a container) testing out
Hibernate; and also testing out a SQL Injection attack (on classic JDBC code).  
See the test case for the 'starting point'.

The database configuration is targeting mySQL so you'll need to change that for your DB.

Also, this is a Maven project so see the pom.xml for items you'll need in your repo.

Example of how to install into your local repo:  

	bond@HAL:~/.m2/repository$ mvn install:install-file 
	-Dfile=/home/bond/lib/hibernate-release-4.3.7.Final/lib/required/hibernate-core-4.3.7.Final.jar 
	-DgroupId=hibernate 
	-DartifactId=hibernate-core 
	-Dversion=4.3.7 
	-Dpackaging=jar


Example of setting up the person table used by the Hibernate example:

	create table person (
	id int(11) NOT NULL AUTO_INCREMENT,
	firstname varchar(50) DEFAULT NULL,
	lastname varchar(50) DEFAULT NULL,
	PRIMARY KEY (id)
	);

	insert into person (id, firstname, lastname) 
	values (1, "Rich1", "Tillery1"), (2, "Rich2", "Tillery2");


# IBM-ODM-Rules-Project/TestRulesProject


I do not recommend attempting to import this project into Eclipse - it was created with Rules Designer IDE, a specific 
'flavor' of Eclipse; I recommend just checking out the code 'manually.'  Unfortunately that means missing out on the pretty
Rules Designer GUIs, sorry.  I did include a screenshot of how the main rule flow (HealthCheckRuleFlow) appears in the Rules 
Designer IDE.

There are 3 rule flows in this project.  

The main rule is HealthCheckRuleFlow.  
It does not contain any action rules or technical rules; only action tasks - therefore
the only 'code' required to make it work is the ruleflow itself, the bom (defines the java objects) and the domain (the java objects, in
the TestDomain project).  
The TestRules-DVS-Runner.xlsx was generated by the Rules Designer IDE; but the rows (the tests and expected results) are filled in
by the developer.  It is run by the Rules Designer IDE (run as 'DVS Excel File') and the TestRulesProject-DVS-Report.html 
is generated with the results.

The other two rule flows are executed by the Rules Designer IDE (run as 'Java Application with Rules', inputs are configured in the
Run Configuration) but they each must be set as the main rule flow first (Properties tab of each file - this is also Rules Designer IDE
specific).
These two rule flows no longer 'work' (due to changes in the domain POJOs) but provide examples of Action Rules, BAL and IRL.

# Java-Projects/TestWebService

Project containing Web Service(s) and Clients:

1) PersonRESTService and client - a @WebServiceProvider implementation, a REST service via JAX-WS.  
The Client communicates using core java.net APIs.  Also included is a method to communicate using Apache Commons HttpConnection.

2) PersonSOAPService and client - a @WebServiceProvider implementation, a JAX-WS service using SOAP.
The Client communicates using core java.net APIs.  

3) GeneratedPersonSoapService and client - a @WebService for which Eclipse's built-in tools (using Apache Axis) generated the 
WSDL and mapping(s).  To test, install this project to Tomcat.  The client tests using core java.net APIs.


# Java-Projects/TestCXFWebService

Web Service generated/deployed with Apache CXF

The Eclipse 'wizard' to generate a service via CXF did not initially fill in the contents of the cxf-beans.xml (or I did something wrong), 
had to populate the spring bean entry with the @WebService pojo and the jaxws:endpoint entry.
For the second Web Service I generated, it *did* fill in cxf-beans.xml for me.

Note that CXF appends a / onto the namespace (while Axis does not):

	CXF: http://service.test.pst.com/
	Axis: http://service.test.pst.com