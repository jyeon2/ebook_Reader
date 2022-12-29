<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../common/common.jsp" %>
    
<% 
	String[] preferArr = {"소설","에세이","시","자기계발","IT","경제/경영","예술"};
%>

<c:set var="preferArr" value="<%=preferArr %>"/>

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
<style type="text/css">
	
	#input-check{
		height: 30px;
		width: 20px;
	}
	p {
    font-size: 15px;
    font-family: "Mulish", sans-serif;
    color: #f8f9fa;
    font-weight: 400;
    line-height: 25px;
    margin: 0 0 15px 0;
	}
	.err{
		color:red;
		font-size: 8pt;
	}
</style>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	   //alert(1);
	   var use;
	   var isCheck = false;
	   
	   $('form').find('#email_check').click(function(){
		   //alert(2);
	       isCheck = true;
	      
	       if($('input[name="email"]').val().length == 0) {
	            alert("이메일을 입력하세요.(중복체크)");
	            $('input[name="email"]').focus();
	            return;
	       } //if
	       
	       $.ajax({
	          url : "emailCheck.me",
	          data : { 
	                useremail :$('input[name="email"]').val() 
	                },
	          success : function(data){
	             	//alert(data);
	                   if($.trim(data) == '사용가능'){
	                      $('#emailmessage').html("<font color=green>사용 가능한 이메일입니다.</font>");
	                      use = "possible";
	                      $('#emailmessage').show();
	                   }else{
	                      $('#emailmessage').html("<font color=red>이미 사용 중인 이메일입니다.</font>");
	                      use = "impossible";
	                      $('#emailmessage').show();
	                   }
	                }//success
	       }); // ajax
	      
	   }); // id_check click
	   
	   $('input[name="email"]').keydown(function(){
	      //alert(3);
	      
	      $('#emailmessage').css('display','none');
	      isCheck = false;
	      use = "";
	   });
	   
	   
	   $('#sub').click(function(){
	      if(use == "impossible"){
	         alert("이미 사용 중인 이메일입니다.");
	         return false;
	      }
	      else if(isCheck == false){
	         alert("중복확인 먼저 하세요.");
	         return false;
	      }
	      
	   });
	}); // ready
	</script>
</head>
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
                        <h2>회원가입</h2>
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
						<h5>회원가입</h5>
					</div>
					<form:form commandName="member" action="join.me" method="post">
						<div class="row">
						
							<div class="col-lg-7">
								<form:errors cssClass="err" path="email"/>
								<input type="email" name="email" value="${member.email }" placeholder="이메일을 입력하세요">
							</div>
							<div class="col-lg-5">
							<button type="button" id="email_check" class="site-btn">중복확인</button><br>
							<span class="message" id="emailmessage" style="display:none;"></span><br>
							</div>
							
							<div class="col-lg-12">
								<form:errors cssClass="err" path="password"/>
								<input type="password" name="password" value="${member.password }" placeholder="비밀번호를 입력하세요">
							</div>
							
							<div class="col-lg-12">
								<form:errors cssClass="err" path="name"/>
								<input type="text" name="name" value="${member.name }" placeholder="이름을 입력하세요">
							</div>
							
							<div class="col-lg-12">
								<form:errors cssClass="err" path="phone" />
								<input type="tel" name="phone" value="${member.phone }" placeholder="연락처를 입력하세요">
							</div>
							
							<div style="padding-left: 15px;">
							<p>선호 장르</p>
							<c:forEach var="prefer" items="${preferArr }">
								 <input id="input-check" name="prefer" type="checkbox" value="${prefer }"
								 	<c:if test="${fn:contains(member.prefer,prefer)}">checked</c:if>> 
								 	<label style="color:white">${prefer} </label>&nbsp;&nbsp;&nbsp;
							</c:forEach>
							<form:errors cssClass="err" path="prefer"/><br><br>
							<button type="submit" class="site-btn">가입하기</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>
    
    <%@ include file="footer.jsp" %>