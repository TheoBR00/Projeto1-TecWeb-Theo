<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ page import="java.util.*, br.edu.insper.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:import url = "/WEB-INF/views/cabecalho.jsp"/>

<table border = '1'>

<c:forEach var="pessoa" items = "${pessoas}">


<tr>
<td>${pessoa.nome}></td>
<td>${pessoa.idade}></td>
<td>
<form action='remove' method='post'>
<input type='hidden' name='id' value='${pessoa.id}'>
<input type='submit' value='remover'>
</form>
</td>

<td>
<form action='atualiza' method='get'>
<input type='hidden' name='id' value='${pessoa.id}'>
<input type='hidden' name='nome' value='${pessoa.nome}'>
<input type='hidden' name='idade' value='${pessoa.idade}'>
<input type='submit' value='atualizar'>
</form>
</td>


</tr>

</c:forEach>


</table>

</body>
</html>