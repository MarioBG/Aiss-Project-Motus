<%@include file="includes/header.jsp"%>

<!DOCTYPE html>
 <html>
<script type="text/javascript"  src="code.js"></script>
   <h1>Guarda tu ruta</h1>
	<div class="container">
	 <div>
		<form action="/GoogleDriveFileNew" method="POST">
			Nombre:<input type="text" id="title" name="title">
			 <br>
			Parámetros:<input type="text" id="content" name="content" value="<c:out value="${content}"/>">
			 <br>
			 <div style="display:inline">
			  <input type="submit" value="Guardar" class="button">
			  <a href="/interfaz.jsp" class="button">Cancelar</a>	
			  </div>
		</form>
		<br>
			
	 </div></div>


 <%@include file="includes/footer.jsp"%>
 </html>