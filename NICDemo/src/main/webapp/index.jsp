<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NIC Demo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="main.css"> -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- <form action="getCompanyDetails">
		<input type="text" name="cname" id="cname"/>
		<input type="text" name="cin" id="cin"/>
		<input type="text" name="city" id="city"/>
		<input type="text" name="postalcode" id="postalcode"/>
		<input type="submit"/>
	</form> -->
	<!-- <form>
		<input type="text" name="cname" id="cname"/>
		<input type="text" name="cin" id="cin"/>
		<input type="text" name="city" id="city"/>
		<input type="text" name="postalcode" id="postalcode"/>
		<button type="button" onclick="getCompanyDetails(0)">Submit</button>
	</form> -->
	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Search Company using any field</legend>

		<div class="form-group">
				<label class="col-md-3 control-label" for="cname">Company
					Name</label>
				<div class="col-md-3">
					<input id="cname" name="cname" type="text"
						placeholder="Company Name" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="cin">CIN</label>
				<div class="col-md-3">
					<input id="cin" name="cin" type="text" placeholder="CIN"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="city">City</label>
				<div class="col-md-3">
					<input id="city" maxlength="200" name="city" type="text" placeholder="City"
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="postalcode">Postal
					Code</label>
				<div class="col-md-3">
					<input id="postalcode" maxlength="6" minlength="6" name="postalcode" type="text"
						placeholder="Postal Code" class="form-control input-md">

				</div>
			</div>

			<!-- Select Basic -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="rpp">Records Per
					Page</label>
				<div class="col-md-3">
					<select id="rpp" name="rpp" class="form-control">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
					</select>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<button class="btn btn-primary" onclick="getCompanyDetails(0)" onsubmit="return false">Submit</button>
				</div>
			</div>
		</fieldset>
	</form>

	<div class="container">
		<div class="row">

			<div class="col-md-10 col-md-offset-1">

				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h3 class="panel-title">Company Details</h3>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-list"
							id="comp">
							<thead>
								<tr>
									<th>Company Name</th>
									<th>CIN</th>
									<th>City</th>
									<th>Postal Code</th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>

					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col col-xs-4" id="page_info">Page 1 of 1</div>
							<div class="col col-xs-8">
								<ul class="pagination hidden-xs pull-right" id="pages">
									<li><a href="#">1</a></li>
								</ul>
								<ul class="pagination visible-xs pull-right">
									<li><a href="#">«</a></li>
									<li><a href="#">»</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		var pageSize = 5;
		$("form").submit(function(e){
	        e.preventDefault();
	    });
		function getCompanyDetails(pageNo) {
			pageSize=$('#rpp').val();
			const TR_OPEN = "<tr>";
			const TD_OPEN = "<td>";
			const TR_CLOSE = "</tr>"
			const TD_CLOSE = "</td>"
			$.ajax({
						url : "getCompanyDetails",
						method : "POST",
						data : {
							name : $('#cname').val(),
							cin : $('#cin').val(),
							city : $('#city').val(),
							postalcode : $('#postalcode').val(),
							pageNo : pageNo,
							pageSize : pageSize
						},
						success : function(result) {
							console.log(result);
							let html = "";
							$.each(result.cd, function(i, obj) {
								//use obj.id and obj.name here, for example:
								html += TR_OPEN;
								html += TD_OPEN + obj.name + TD_CLOSE;
								html += TD_OPEN + obj.cin + TD_CLOSE;
								html += TD_OPEN + obj.city + TD_CLOSE;
								html += TD_OPEN + obj.postalcode + TD_CLOSE;
								html += TR_CLOSE;
							});
							console.log(html);
							$('#comp tbody').html(html);
							let pageHTML = "";
							for (let i = 0; i < result.totalPages; i++) {
								pageHTML += "<li><a href='#' onclick='getCompanyDetails("
										+ i
										+ ","
										+ pageSize
										+ ")'>"
										+ (i + 1)
										+ "</a></li>";
							}
							$('#pages').html(pageHTML);
							$('#page_info').html(
									"Page " + (pageNo + 1) + " of "
											+ result.totalPages);
						}
					});
			return false;
		}
	</script>
</body>
</html>