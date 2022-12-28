<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/home.css">
</head>
<body class="flex-col">
	<div class="flex-row header">
        <a class="header-links" href="/product">Products</a>
        <c:choose>
            <c:when test="${loggedInSapp != null}">
                <a class="header-links" href="/">Home</a>
                <div class="icon">${loggedInSapp.getSappname().toUpperCase().charAt(0)}</div>
            </c:when>    
            <c:otherwise>
                <a class="header-links" href="/signUp">Sign Up</a>
                <a class="header-links" href="/">Home</a>
                <a class="header-links" href="/signIn">Sign In</a>
            </c:otherwise>
        </c:choose>
    </div>
	<div class="flex-row main-content">
        <div class="out-of-the-box">
			<div class="box">
				<div class="box-content flex-col margin-center">
					<h1 class="box-header">Sign Up Box</h1>
					<p class="">Sign Up For Sallys!</p>
					<p class="">Please</p>
					<form:form modelAttribute="user" action="signUp" method="post">
						<div class="flex-col">
							<div class="flex-row">
								<div class="box-input">
									<form:input path="username" placeholder="Username" type="text" />
									<c:if test="${message != null}">${message}</c:if>
								</div>
								<div class="arrow">&</div>
								<div class="box-input">
									<form:input path="password" placeholder="Password" type="password" />
								</div>
							</div>
							<form:button type="submit" class="result-button">Submit</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
    </div>
</body>

</html>
