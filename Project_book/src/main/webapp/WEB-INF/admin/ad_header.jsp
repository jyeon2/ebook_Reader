<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="home.ad">
                            <img src="resources/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li class="active"><a href="home.ad">홈</a></li>
                                <li><a href="">관리자 페이지<span class="arrow_carrot-down"></span></a>
                                    <ul class="dropdown">
                                        <li><a href="addGenre.ad">책 장르 등록</a></li>
                                        <li><a href="genreList.ad">책 장르 목록/관리</a></li>
                                        <li><a href="addBook.ad">상품 등록</a></li>
                                        <li><a href="bookList.ad">상품 목록/관리</a></li>
                                        <li><a href="home.me">사용자 홈</a></li>
                                    </ul>
                                </li>
                                <li><a href="./blog.html">공지사항</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    
    <!-- Header End -->