<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/common.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="resources/css/plyr.css" type="text/css">
    <link rel="stylesheet" href="resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<style>
th{
background-color: #d9534f;
color:white;
border:solid 2px white;
}
td{
background-color: #53577f;
color:white;
}
a {
    color: #ffffff;
    text-decoration: none;
    background-color: transparent;
}
</style>
<%@ include file="ad_header.jsp" %><br>

<section class="anime-details spad">
	<div class="container">
		<div class="row d-flex justify-content-center">
<div class="anime__details__form">
					<div class="section-title">
						<h5>장르 목록/관리</h5>
					</div>
	<table class="tb">
		<tr align="center">
			<th width="130">번호</th>
			<th width="300">장르 이름</th>
			<th width="130">관리</th>
		</tr>
		<c:forEach var="genre" items="${lists}">
		<tr align="center">
			<td>${genre.gno}</td>
			<td>${genre.name}</td>
			<td ><a href="updateGenre.ad?gno=${genre.gno}">수정</a> |
		        <a href="deleteGenre.ad?gno=${genre.gno}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</div>
</div>
</section>
<%@ include file="ad_footer.jsp" %><br>