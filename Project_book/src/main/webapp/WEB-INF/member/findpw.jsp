<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style type="text/css">
	
</style>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <%@ include file="header.jsp" %>

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="resources/img/read2.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>비밀번호 찾기</h2>
                        <p>Reader에 오신 것을 환영합니다.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->
    
     <section class="anime-details spad">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-lg-6">
				<div class="blog__details__form">
					<div class="section-title">
						<h5>비밀번호 찾기</h5>
					</div>
					<form action="findpw.me" method="post">
						<div class="row">
							
							<div class="col-lg-12">
								<input type="text" name="name" value="${member.name }" placeholder="이름을 입력하세요">
							</div>
							
							<div class="col-lg-12">
								<input type="text" name="email" value="${member.email }" placeholder="이메일를 입력하세요">
								<button type="submit" class="site-btn">검색하기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
    
    <%@ include file="footer.jsp" %>