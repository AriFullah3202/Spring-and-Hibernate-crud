<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/Spring_hibernate/UrlToResourceFolder/css/MyStyle.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 <script type="text/javascript" src="/Spring_hibernate/UrlToResourceFolder/js/myscript.js"></script>
 
</head>
<body>
 <h1 align="center">Please add Offer</h1>
 <div align="center">
<form:form action="processOffer" method ="post" modelAttribute="offer">
 <form:hidden path="id"/><br>
 Company Name: <form:input path="companayName"/><br>
 Offer Details : <form:input path="offerDetails"/><br>
 Price : <form:input path="price"/><br>
 <button type="submit">Submit</button>
</form:form>
</div>
</body>
</html>