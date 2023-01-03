<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/add-whips.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="flex-col">
	<div class="flex-row header">
        <a class="header-links" href="/logout">Log Out</a>
        <a class="header-links" href="/whips">HOP IN A WHIP TODAY!</a>
        <a class="header-links" href="/admin-tool">Admin tool</a>
        <div class="icon">${admin.getSappname().toUpperCase().charAt(0)}</div>
    </div>
	<div class="flex-row main-content content-center">
        <form:form modelAttribute="whip" action="addWhips" method="post">
            <div class="flex-col content-center box">
                <h1>Create Whip for Lot</h1>
                <div class="flex-row">
                    <div class="box-input">
                        <form:input path="year" placeholder="Year" type="number" />
                    </div>
                    <div class="box-input">
                        <form:input path="make" placeholder="Make" type="text" />
                    </div>
                    <div class="box-input">
                        <form:input path="model" placeholder="Model" type="text" />
                    </div>
                    <div class="box-input">
                        <form:input path="trim" placeholder="Trim" type="text" />
                    </div>
                </div>
                <div class="flex-row">
                    <div class="box-input">
                        <form:input path="engine" placeholder="Type of Engine" type="text" />
                    </div>
                    <div class="box-input">
                        <form:input path="vin" placeholder="Vin" type="text" />
                    </div>
                    <div class="box-input">
                        <form:input path="mileage" placeholder="Mileage" type="number" />
                    </div>
                </div><div class="flex-row">
                    <div class="box-input">
                        <form:input path="cMpg" placeholder="City MPG" type="number" />
                    </div>
                    <div class="box-input">
                        <form:input path="hMpg" placeholder="Highway MPG" type="number" />
                    </div>
                    <div class="box-input">
                        <form:input path="image" placeholder="Image Url" type="text" />
                    </div>
                    <div class="box-input">
                        <form:input path="price" placeholder="Price" type="decimal" />
                    </div>
                </div>
                <div class="box-input">
                    <form:input path="slogan" placeholder="What does this car say to you in a sentence" type="text" />
                </div>
                <form:button type="submit" class="button">Submit</form:button>
                <c:if test="${message != null}">${message}</c:if>
                <c:if test="${createdMessage != null}">${message}</c:if>
            </div>
        </form:form>
    </div>
</body>

</html>
