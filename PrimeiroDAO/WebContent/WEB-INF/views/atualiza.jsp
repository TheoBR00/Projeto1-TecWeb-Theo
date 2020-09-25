<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='atualiza' method='post'>
Nome: <input type='text' name='nome' value='${param.nome}'><br>
Idade: <input type='number' name='idade' value = '${param.idade}'><br>
<input type='hidden' name='id' value='${param.id}'>
<input type='submit' value='atualizar'>
</form>

</body>
</html>