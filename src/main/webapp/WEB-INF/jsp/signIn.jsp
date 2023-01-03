<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/signIn.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="flex-col">
	<div class="flex-row header">
        <a class="header-links" href="/signUp">Sign Up</a>
        <a class="header-links" href="/">Home</a>
        <a class="header-links" href="/signIn">Sign In</a>
    </div>
	<div class="flex-row main-content">
        <div class="out-of-the-box">
			<div class="box">
				<div class="box-content flex-col margin-center">
					<h1 class="box-header">Syn In</h1>
					<form:form modelAttribute="sapp" action="signIn" method="post">
						<div class="flex-col content-center">
							<div class="flex-row">
								<div class="box-input">
									<form:input path="sappname" placeholder="Username" type="text" />
								</div>
								<div class="arrow">&</div>
								<div class="box-input">
									<form:input path="password" placeholder="Password" type="password" />
								</div>
							</div>
							<form:button type="submit" class="result-button">Submit</form:button>
							<c:if test="${message != null}">${message}</c:if>
						</div>
					</form:form>
				</div>
			</div>
		</div>
    </div>
</body>
</html>
