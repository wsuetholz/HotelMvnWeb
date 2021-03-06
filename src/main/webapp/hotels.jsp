
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hotel Administration</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" type="text/css" href="default.css">	
	<script language="JavaScript">
	    <!--
		function submitForm(){
		    document.hotelListing.btnAddEdit.click();
		}
		function submitDelete(){
		    document.hotelListing.btnDelete.click();
		}
	    -->
	</script>
    </head>
    <body>
	<c:if test="${fn:length(hotels) == 0}">
	    <% response.sendRedirect(response.encodeRedirectURL("HotelController?action=findAll")); %>
	</c:if>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="HotelController?action=findAll">${applicationScope['ManagementName']}</a>
	    </div>
	    <div id="navbar" class="navbar-collapse collapse">
		<div class="form-group navbar-form navbar-right">
		    <button type="submit" class="btn btn-primary" name="btnDeleteHdr" onclick="submitDelete();">Delete</button>
		</div>
		<div class="form-group navbar-form navbar-right">
		    <button type="submit" class="btn btn-primary" name="btnAddEditHdr" onclick="submitForm();">Add/Edit</button>
		</div>
	    </div><!--/.navbar-collapse -->
	  </div>
	</nav>

	<div class="jumbotron">
	  <div class="container">
	  </div>
	</div>

	<div class="container">
	    <form name="hotelListing" method="POST" action="HotelController?action=doChanges">
		<input type="submit" class="hidden" value="Add/Edit" name="btnAddEdit" />&nbsp;
		<input type="submit" class="hidden" value="Delete" name="btnDelete" />
		<br><br>
		<table id="hotelTable" class="table table-striped">
		    <thead>
			<tr>
			    <th>ID</th>
			    <th>Name</th>
			    <th>Street</th>
			    <th>City</th>
			    <th>State</th>
			    <th>Zip</th>
			    <th>Notes</th>
			</tr>
		    </thead>
		    <tbody>
			<c:forEach var="hotel" items="${hotels}" varStatus="rowCount">
			    <div class="row">
				<tr>
				    <td><input type="checkbox" name="id" value="${hotel.hotelId}" /></td>
				    <td align="left">${hotel.hotelName}</td>
				    <td align="left">${hotel.streetAddress}</td>
				    <td align="left">${hotel.city}</td>
				    <td align="left">${hotel.state}</td>
				    <td align="left">${hotel.postalCode}</td>
				    <td align="left">${hotel.notes}</td>
				</tr>
			    </div>
			</c:forEach>
		    </tbody>
		</table>
	    </form>
	</div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
    </body>
    
</html>
