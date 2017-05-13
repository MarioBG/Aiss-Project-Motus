<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	
		<p>${message}</p>
		
		<form action="list" method="post">
			Paradas: <select name="playlistId" onchange="this.form.submit()">
				<c:forEach items="${requestScope.paradas}" var="parada">
    				<option value="${parada.id}" ${parada.id == pradaId ? 'selected' : ''}>${parada.nombre}</option>
    			</c:forEach>
  			</select>
  			<a href="playlistEditView.jsp?playlistId=${paradaId}" class="button">New parada</a>
		</form>
		
		
	</div>

</body>
</html>