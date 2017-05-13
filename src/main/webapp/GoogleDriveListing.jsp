<!DOCTYPE html>
 <html>
<script type="text/javascript"  src="code.js"></script>
   <h1>Ficheros en tu Google Drive</h1>
	<div style="text-align:center" class="container">
	 <p class="message">${message}</p>
	
	 <div style="text-align:center">
		
		<a href="/interfaz.jsp" class="button">Vuelve a la interfaz</a>
		<br>
		
		<br>
		<table style="margin-left:auto;margin-right:auto" id="files">
			<tr>
				<th>Nombre</th>
				
				<th>Eliminar</th>
			</tr>
			<c:forEach items="${requestScope.files.items}" var="file">
				<tr>
				<td><c:out value="${file.title}"/></td>
				
				<td>
					<a href="GoogleDriveFileDelete?id=${file.id}"><img src="./images/papelera.png" width="30px"></a>
				</td>
				</tr>
			</c:forEach>			
		</table>
	 </div>
		<br><br>
		<a href="/EditFile.jsp" class="button">Crear archivo de texto</a>
	</div>


 <%@include file="includes/footer.jsp"%>
 </html>