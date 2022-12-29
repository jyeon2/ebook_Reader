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
	.forget{
	padding-left: 30px;
	color: #f8f9fa;
	}
	a {
    color: #f8f9fa;
    text-decoration: none;
    background-color: transparent;
	}
	
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
                        <h2>로그인</h2>
                        <p>Reader에 오신 것을 환영합니다.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad">
        <div class="container">
            <div class="row">
				<div class="col-lg-6">
					<div class="login__form">
					<div class="section-title">
						<h4>로그인</h4>
						<form action="login.me" method="post">
							<div class="input__item">
								<input type="email" name="email" placeholder="이메일 주소를 입력하세요"> <span
									class="icon_mail"></span>
							</div>
							<div class="input__item">
								<input type="password" name="password" placeholder="비밀번호를 입력하세요"> <span
									class="icon_lock"></span>
							</div>
							<button type="submit" class="site-btn">로그인</button>
						</form>
					</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login__register">
						<h4>계정이 없으신가요?</h4>
						<a href="join.me" class="primary-btn">회원가입</a>
					</div><br><br><br>
					<div class="forget">
					<a href="findid.me">이메일 찾기</a> &nbsp; | &nbsp;
					<a href="findpw.me">비밀번호 찾기</a>
					</div>
				</div>
			</div>
        </div>
    </section>
    <!-- Login Section End -->

   <%@ include file="footer.jsp" %>