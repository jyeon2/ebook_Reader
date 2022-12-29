<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	.err{
		color:red;
		font-size: 8pt;
	}
		
</style> 

<%@ include file="ad_header.jsp" %><br>

<section class="anime-details spad">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="anime__details__form">
					<div class="section-title">
						<h5>장르 수정</h5>
					</div>
					<form:form commandName="genre" action="updateGenre.ad" method="post">
					 <input type="hidden" name="gno" value="${genre.gno }">
						<textarea placeholder="장르 이름을 입력하세요" name="name">${genre.name }</textarea>
						<form:errors cssClass="err" path="name" /><br><br>

						<button type="submit" class="site-btn">수정하기</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="ad_footer.jsp"%>