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
    </head>
    <body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Hotel Administration</a>
	    </div>
	  </div>
	</nav>

	<div class="jumbotron">
	  <div class="container">
	  </div>
	</div>

	<div class="container">
	    <form method="POST" class="form-horizontal" action="HotelController?action=store">
		<div class="form-group">
		    <div class="col-xs-10">
			<input type="hidden" class="form-control" id="inputId" name="inputId" value="${hotel.hotelId}">
		    </div>
	       </div>
 		<div class="form-group">
		    <label for="inputName" class="control-label col-xs-2">Name</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputName" name="inputName" placeholder="Name" value="${hotel.hotelName}">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputStreet" class="control-label col-xs-2">Street</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputStreet" name="inputStreet" placeholder="Street" value="${hotel.streetAddress}">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputCity" class="control-label col-xs-2">City</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputCity" name="inputCity" placeholder="City" value="${hotel.city}">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputState" class="control-label col-xs-2">State</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputState" name="inputState" placeholder="State" value="${hotel.state}">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputPostalCode" class="control-label col-xs-2">Postal Code</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputPostalCode" name="inputPostalCode" placeholder="Postal Code" value="${hotel.postalCode}">
		    </div>
		</div>
		<div class="form-group">
		    <label for="inputNotes" class="control-label col-xs-2">Notes</label>
		    <div class="col-xs-10">
			<input type="text" class="form-control" id="inputNotes" name="inputNotes" placeholder="Notes" value="${hotel.notes}">
		    </div>
		</div>
		<div class="form-group">
		    <div class="col-xs-offset-2 col-xs-10">
			<button type="submit" class="btn btn-primary" name="btnSave">Save</button>
			<button type="submit" class="btn btn-primary" name="btnCancel">Cancel</button>
		    </div>
		</div>
	    </form>
	</div>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
    </body>
    
</html>
