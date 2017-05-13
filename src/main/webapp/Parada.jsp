<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parada</title>
</head>
<body>
       <table id="files">

			<c:forEach items="${requestScope.parada}" var="parada">
				<tr>
				<th> <c:out value="${parada.correspondencias}"/></td>
                <th><c:out value="${parada.idParada}"/></td>
				</tr>
			</c:forEach>			
		</table>

</body>
</html>