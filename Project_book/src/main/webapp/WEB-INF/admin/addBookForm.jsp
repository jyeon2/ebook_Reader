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
	p {
    	font-size: 15px;
    	font-family: "Mulish", sans-serif;
    	color: #dee2e6;
    	font-weight: 400;
    	line-height: 25px;
    	margin: 0 0 15px 0;
	}
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
				<div class="blog__details__form">
					<div class="section-title">
						<h5>상품 등록</h5>
					</div>
					<form:form commandName="book" action="addBook.ad" enctype="multipart/form-data">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6">
								
								<form:errors cssClass="err" path="bname" />
								<input type="text" name="bname" placeholder="책 이름을 입력하세요">${book.bname }
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6">
							<select name="gname">
								<option value="">장르를 선택하세요</option>
								<c:forEach var="g" items="${glists}">
									<option value="${g.name }" <c:if test="${g.name eq book.gname}">selected</c:if>>${g.name }</option>
								</c:forEach>
							</select>
							<form:errors cssClass="err" path="gname" />
							</div><br><br><br>
							
							<div class="col-lg-6 col-md-6 col-sm-6">
								<form:errors cssClass="err" path="author" />
								<input type="text" name="author" placeholder="저자를 입력하세요">${book.author }
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6">
								<form:errors cssClass="err" path="publisher" />
								<input type="text" name="publisher" placeholder="출판사를 입력하세요">${book.publisher }
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6">
								<p>책 사진</p>
								<input type="file" name="upload" value="${book.photo }">
								<form:errors cssClass="err" path="photo"/>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6">
								<p>출판일</p>
								<input type="date" name="bookdate" placeholder="출판일을 입력하세요">${book.bookdate }
								<form:errors cssClass="err" path="bookdate" />
							</div>
							
							<div class="col-lg-12">
								<textarea name="con1" placeholder="책 상세내용을 입력하세요">${book.con1 }</textarea>
								<form:errors cssClass="err" path="con1" />
							</div>
							
							<div class="col-lg-12">
								<textarea name="con2" placeholder="책 상세내용을 입력하세요">${book.con2 }</textarea>
								<form:errors cssClass="err" path="con2" />
								<button type="submit" class="site-btn">등록하기</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="ad_footer.jsp"%>