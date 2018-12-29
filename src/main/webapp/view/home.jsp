<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Info</title>
<link type="text/css" rel="stylesheet" href="/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<style type="text/css">
body {
    padding-top: 70px;
  }
 
</style>
</head>
<body>
	
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Telusko Assignment</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="nav navbar-nav  navbar-right" style="margin-left: 630px;">
          <li class="nav-item active">
            <a class="nav-link" href="#" target="_blank">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="https://github.com/Shubhamjain2908" target="_blank">Github</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="https://www.linkedin.com/in/shubham-jain-804970158/" target="_blank">Linkedin</a>
          </li>
        </ul>
        
      </div>
    </nav>
	
	<div class="container">
		
		
		
		
		<div class="row">
			
			<div class="col-md-6">
				
				<div class="col-md-10">
				<form action="">
				<fieldset class="border p-2">

					<legend class="w-auto">Get Top 5 Students</legend>
					<div class="col-md-2"></div>
					<div class="col-md-10">
					<div class="form-group">
					    
					    	<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="city" id="karad" value="Karad" checked="checked">
							  <label class="form-check-label" for="karad">Karad</label>
							</div>
							<div class="form-check form-check-inline">
							  <input class="form-check-input" type="radio" name="city" id="pune" value="Pune">
							  <label class="form-check-label" for="pune">Pune</label>
							</div>
						
						</div>
					  
					  <div class="form-group">
					    <label for="age">Age Group</label>
					    <select class="form-control col-md-6" id="age">
					      <option>Select</option>
					      <option value="10-20">10-20</option>
					      <option value="20-30">20-30</option>
					      <option value="30-60">30-60</option>
					     </select>
					  </div>
					  
					  <div class="form-group">
						  <label for=""></label>
						  <button type="button" class="btn btn-primary" onclick="getData()">Submit</button>
						  <button type="button" class="btn btn-danger" onclick="resetTableData()">Reset</button>
					  </div>
					  </div>
						
								  
					  
				</fieldset>
				</form>
				<br>
				
				
				</div>
				
				
				<div  class="col-md-2"></div>
				
			</div>
			
			<div class="col-md-6">
			<div class="alert alert-success" id="output">
  					<strong>Showing All Students.</strong>
			</div>
		  	<table id="myTable" class="table table-striped">
				<thead>
					<tr>
						<th>Sr .No</th>
						<th>Name</th>
						<th>Age</th>
						<th>Marks</th>
						<th>City</th>
					</tr>
				</thead>
				
				<tbody id="tableContent">
				<%int count = 1; %>
					<c:forEach var="tempStud" items="${studentDetails}" >
					<tr>
						<td><%=count %></td>
						<td>${tempStud.name}</td>
						<td>${tempStud.age}</td>
						<td>${tempStud.marks}</td>
						<td>${tempStud.city}</td>
					</tr>
					<%count++; %>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
		
		
		
		
		
		
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    //$('#myTable').dataTable();
});

function resetTableData()
{
	document.getElementById("age").selectedIndex = "0";
	//alert('working');
	
	 $.ajax({
		  type: "post",
		  url: "${pageContext.request.contextPath}/reset.htm",
		  cache: false,    
		  data:"randon=omkar",
		  success: function(response){
		  var obj = JSON.parse(response);
		  setResetData(obj); 
		  //alert(response);
		  },
		  error: function(){      
		   alert('Error while request..');
		  }
		 });	 
}
function setResetData(obj){
	
	document.getElementById("tableContent").innerHTML="";
	var tableData="";
	var count=1;
	for(var i=0;i<obj.length;i++)
	{
		tableData+="<tr>"
		+"<td>"+count+"</td>"
		+"<td>"+obj[i].name+"</td>"
		+"<td>"+obj[i].age+"</td>"
		+"<td>"+obj[i].marks+"</td>"
		+"<td>"+obj[i].city+"</td>"
		+"</tr>";
			
		count++;	
	}
	
	document.getElementById("tableContent").innerHTML=tableData;
	document.getElementById("output").innerHTML ="<strong>Showing All Students.</strong>";
	
}


function getData()
{
	var a = document.getElementById("age").selectedIndex;
	var age = document.getElementsByTagName("option")[a].value;
	
	var city = $("input:radio[name=city]:checked").val();
	
	if(age=='Select')
	{
		alert('Please select age group');	
	}
	else
	{
		$.ajax({
			  type: "post",
			  url: "/students",
			  cache: false,    
			  data:{"city":city,"age":age},
			  success: function(response){
			  var obj = JSON.parse(response);
			  setInTable(obj,city,age); 
			  //alert(response);
			  },
			  error: function(){      
			   alert('Error while request..');
			  }
			 });	
	}
	
}
function setInTable(obj,city,age)
{
	document.getElementById("tableContent").innerHTML="";
	var tableData="";
	var count=1;
	for(var i=0;i<obj.length;i++)
	{
		tableData+="<tr>"
		+"<td>"+count+"</td>"
		+"<td>"+obj[i].name+"</td>"
		+"<td>"+obj[i].age+"</td>"
		+"<td>"+obj[i].marks+"</td>"
		+"<td>"+obj[i].city+"</td>"
		+"</tr>";
			
		count++;	
	}
	/* $('#myTable').dataTable( {
	    "bPaginate": false,
	    "bLengthChange": false,
	    "bFilter": false,
	    "bSort": false,
	    "bInfo": false,
	    "bAutoWidth": false,
	    "asStripClasses": null //To remove "odd"/"event" zebra classes
	} ); */
	document.getElementById("tableContent").innerHTML=tableData;
	document.getElementById("output").innerHTML ="<strong>Top 5 Students of "+city+" between age "+age+"</strong>";
	
}
</script>		
</body>
</html>