<%@page import="web.CreditModel"%>
  <%
  CreditModel model=(CreditModel)request.getAttribute("creditModel");
  %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Credit bancaire</title>
<link rel="stylesheet" type="text/css" href="Css\Style.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
	<div class="container">
	 <div  id="center-div" class=" col-md-offset-3 col-md-6 col-md-offset-3 col-xm-12" >
	 
	 		<div class="panel panel-primary ">
			<div class="panel-heading">
				Simulateur de credit
			</div>
			<div class="panel-body">
			<form action="calculerMensualite.do" method="post">
				<div class="form-group">
					<label class="control-label">Montant</label>			
					<input type="text"  class="form-control" name="montant" value="<%=model.getMontant()%>"/>					
				</div>
				<div class="form-group">
					<label class="control-label">Durée</label>			
					<input type="text"  class="form-control" name="duree" value="<%=model.getDuree()%>"/>					
				</div>
				<div class="form-group">
					<label class="control-label">Taux</label>			
					<input type="text"  class="form-control" name="taux" value="<%=model.getTaux()%>"/>					
				</div>
				<button class="btn btn-warning"	 type="submit">Calculer</button>			
			
			</form>
		
			
			</div>
				<div class="panel-footer">
			<label>Mensualitée:</label>
			<label><%=model.getMensualite()%></label>
			</div> 
		
		</div>
	 
	 </div>

	
	
	
	</div>


</body>
</html>