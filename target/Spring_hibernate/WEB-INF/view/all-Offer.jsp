<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
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
    <h1 align="center">See all the Offer</h1>
    <div align="right">
     <form action="search" method="get">
        <input type="text" placeholder="Search" name="keyword">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
    <div align="center">
    
    
    <form action="offer">
    
     <input type="submit" value="Add">
    </form>
    <table border="1" cellpadding = "8">
    <thead>
    <tr>
     <th>id</th>
     <th>Company Name</th>
     <th>Offer Details</th>
     <th>Price</th>
     <th>Action</th>
    </tr>     
     <c:forEach var="temp" items="${allOffers}">
      <tr>
        <td>${temp.id}</td>
        <td>${temp.companayName}</td>
        <td>${temp.offerDetails}</td>
        <td>${temp.price}</td>
        <td><a href="/Spring_hibernate/deleteOffer?offerId=${temp.id}">Delete</a></td>
        <td><a href="/Spring_hibernate/updateOffer?offerId=${temp.id}">Update</a></td>
      </tr>
    
    </c:forEach>    
    
    </table>
    </div>
   
</body>
</html>