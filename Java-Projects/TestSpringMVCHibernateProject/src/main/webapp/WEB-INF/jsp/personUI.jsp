<html>

<head>
<title>PersonUI</title>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/css/jquery-ui.css"/>
<script src="${ pageContext.request.contextPath }/js/jquery-2.1.3.js"></script>
<script src="${ pageContext.request.contextPath }/js/jquery-ui.js"></script>
<script>
  var showWait = function() {
    var deferred = new $.Deferred();
    $("#people-table").hide(0, function() {
    	$(".wait").show(500, function() { 
    		deferred.resolve(); 
    	});
    });
    return deferred;
  };
  
  var hideWait = function() {
   	$(".wait").fadeOut(500, function() {
		  $("#people-table").fadeIn(500);
	});          
  };
  
  var fetchPeople = function() {
	$.ajax({
		url : "${ pageContext.request.contextPath }/spring/person/fetchPeople",
		type : 'GET',
		contentType : 'application/json',
		cache : false,
  	    dataFilter : function(data, type) {
          //configure ajax setup to filter off json hijacking prevention if present
  	      data = data.replace("{} &&", "");
  	      return data;
  	    },		
		success : function(data, status, jqXHR) {
			showWait().then( function() {
				//clear out data table
				$("#data-table").empty();
				//build markup with new data
				$( data.webPersonList ).each(function(index, item){
				    var skills = "<td>";
				    $( item.skills ).each(function(index, skill) {
				      skills += skill.skillType + "<br/>"; 
				    });
				    skills += "</td>";
					$("<tr id=\"" + item.id + "\">" +
									"<td>" + item.id + "</td>" +
									"<td><input type=\"text\" value=\"" + item.firstName + "\"></td>" + 
									"<td><input type=\"text\" value=\"" + item.lastName + "\"></td>" + 
									skills + 			    	  				
									"<td><input type=\"text\"></td>" + 
			    	  				"<td><button class=\"addSkillsButton\" id=\"" + item.id + "\">Add Skill</button></td>" +
			    	  				"<td><button class=\"updateButton\" id=\"" + item.id + "\">Update Person</button></td>" +
			    	  				"<td><button class=\"deleteButton\" id=\"" + item.id + "\">Delete Person</button></td>" + 
			    	  				"</tr>").appendTo($("#data-table"));
			    	});

			    //attach onclicks to the newly-generated update buttons
			    $(".addSkillsButton").each(function(index, button) {
			        button.onclick = function() {
			        				addSkill(button.id, 
			        						 $("tr#" + button.id + " td:nth-child(5) input")[0].value
			        					); 
			        				};
			    });
			    	
			    //attach onclicks to the newly-generated update buttons
			    $(".updateButton").each(function(index, button) {
			        button.onclick = function() {
			        				updatePerson(button.id, 
			        							 $("tr#" + button.id + " td:nth-child(2) input")[0].value, 
			        							 $("tr#" + button.id + " td:nth-child(3) input")[0].value
			        			    	); 
			        				};
			    });
	
		    	//attach onclicks to the newly-generated delete buttons
		    	$(".deleteButton").each(function(index, button) {
		    	    button.onclick = function() {deletePerson(button.id);};
		    	});

				//clear out input fields
    			$("#newFirstName")[0].value = "";
			    $("#newLastName")[0].value = "";

				hideWait();
			});
  		}
  	})
  };

  var insertPerson = function() {
  	showWait().then(function() {
		$( "#insertPersonDialog" ).dialog( "close" );
		
	    var firstName = $("#newFirstName")[0].value;
	    var lastName = $("#newLastName")[0].value;
	    var person = JSON.stringify({"firstName":firstName,"lastName":lastName});
		$.ajax({
			url : "${ pageContext.request.contextPath }/spring/person/insertPerson",
			type : 'POST',
			contentType : 'application/json',
			data : person, 
	  	    dataFilter : function(data, type) {
	          //configure ajax setup to filter off json hijacking prevention if present
	  	      data = data.replace("{} &&", "");
	  	      return data;
	  	    },		
			success : function() {
	    		fetchPeople();	    		
	    	}
	    });
  	});
  };

  var addSkill = function(id, skill) {
    var person = JSON.stringify({"personId":id,"skillType":skill});
	$.ajax({
		url : "${ pageContext.request.contextPath }/spring/person/addSkill",
		type : 'POST',
		contentType : 'application/json',
		data : person, 
  	    dataFilter : function(data, type) {
          //configure ajax setup to filter off json hijacking prevention if present
  	      data = data.replace("{} &&", "");
  	      return data;
  	    },		
		success : function() {        
    		fetchPeople();
    	}
    });
  };
  
  var updatePerson = function(id, firstName, lastName) {
    var person = JSON.stringify({"id":id,"firstName":firstName,"lastName":lastName});
	$.ajax({
		url : "${ pageContext.request.contextPath }/spring/person/updatePerson",
		type : 'POST',
		contentType : 'application/json',
		data : person, 
  	    dataFilter : function(data, type) {
          //configure ajax setup to filter off json hijacking prevention if present
  	      data = data.replace("{} &&", "");
  	      return data;
  	    },		
		success : function() {        
    		fetchPeople();
    	}
    });
  };

  var deletePerson = function(id) {
    $.ajax({ 
    	url : "${ pageContext.request.contextPath }/spring/person/deletePerson/" + id, 
    	type : 'DELETE',
		contentType : 'application/json',
  	    dataFilter : function(data, type) {
            //configure ajax setup to filter off json hijacking prevention if present
    	      data = data.replace("{} &&", "");
    	      return data;
  	    },		
    	success: function(data, status, jqXHR) {
    		fetchPeople();
    	}
    });
  };
  
  var openModal = function() {
  	$( "#insertPersonDialog" ).dialog( "open" );
  };
  
  $(function() {  
	$( "#insertPersonDialog" ).dialog({
	    autoOpen: false,
  		draggable: true,
  		modal: true,
  		width: 500
	});
  
  	$("#drag").draggable({
  		appendTo : "body",
  		scroll : true
  	});
  });
  
</script>
<style>
  .ui-widget-content {
	  background-color: #FFFFFF;
  }
  .main {
      position : relative;
      height : 500px;
      width : 1300px;
      text-align: center;
  }
	.secondary .tertiary {
      position : absolute;
      top : 500px;
      height : 100px;
      width : 100px;
      text-align: center;
  }  
  .wait {
      position : absolute;
      top : 10%;
      height : 100%;
      width : 100%;
  }
  table {
  	width: 100%;
  }
  #people-table {
      min-height : 500px;
      min-width : 1300px;
  }
  #people-table th {
   	width:12%;
   	text-align:center;
   	border-style:solid;
   	border-width:1px;
  }  
  #data-table td {
   	width:12%;
   	text-align:center;
   	border-style:solid;
   	border-width:1px;
  }
  #insert-person-table td {
   	width:12%;
   	text-align:center;
  }
  #insert-person-table td.bigger {
   	width:60%;
   	text-align:center;
  }
  .controls {
    text-align: center;
  }
</style>
</head>

<body onload="javascript:fetchPeople();">
<div class="main">
    <!-- <div id="greeting">${greeting}</div>  -->
    <div id="people-table" style="display:none;">
		<table>
		<thead>
		  <tr>
			  <th>ID</th>
			  <th>First Name</th>
			  <th>Last Name</th>
			  <th>Skills</th>
			  <th>New Skill</th>
			  <th></th>
			  <th></th>
			  <th></th>
		  </tr>
		</thead>		
		</table>
		<table id="data-table">
		</table>
		<br>
		<div id="insertPersonDialog">
			<table id="insert-person-table">
		  	<tr>
		    	<td><input id="newFirstName" type="text"></td>
		    	<td><input id="newLastName" type="text"></td>
		    	<td class="bigger"><button onclick="javascript:insertPerson();">Insert Person</button></td>		    
		  	</tr>
			</table>
		</div>			
		<br><br>
		<div class="controls">
		  <button onclick="javascript:openModal();">Insert Person</button>
		  <button onclick="javascript:fetchPeople();">Reload People</button>
		</div>
	</div>
	<div class="wait"  style="display:none;">
		<img src="../../ajax-loader.gif"><br>		
		<b>...Please wait...</b>
	</div>
</div>
</body>

</html>