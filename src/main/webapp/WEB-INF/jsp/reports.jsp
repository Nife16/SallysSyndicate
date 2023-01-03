<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/whips.css">
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="flex-col">
	<div class="flex-row header">
        <a class="header-links" href="/logout">Log Out</a>
        <a class="header-links" href="/whips">HOP IN A WHIP TODAY!</a>
        <div class="icon">${loggedInSapp.getSappname().toUpperCase().charAt(0)}</div>
        <c:if test="${loggedInSapp.getRole() == 'ROLE_ADMIN'}">
            <a class="header-links" href="/admin-tool">Admin tool</a>
        </c:if>
    </div>
	<div class="flex-row main-content">
        <div class="content-width">
            <div class="flex-col filters-col">
                <h1 class="text-center">Filter Sapp</h1>
                <c:forEach items="${sappList}" var="sapp">
                    <c:choose>
                        <c:when test = "${focusSapp.getId() == sapp.getId()}">
                            <a class="filter-link-flip" href="/reports/${sapp.getId()}">${sapp.getSappname()} - ${sapp.getId()}</a>
                        </c:when>
                        <c:otherwise>
                            <a class="filter-link" href="/reports/${sapp.getId()}">${sapp.getSappname()} - ${sapp.getId()}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach> 
                <a class="filter-link reset" href="/reports">RESET</a>
            </div>
            <div class="flex-col content-col">
                <div class="flex-row wrap">
                    <c:forEach items="${purchasedWhips}" var="whip">
                        <div class="flex-col whip-box">
                            <img src="${whip.getImage()}" class="whip-image">
                            <h3 class="ellipsis">${whip.getTitleName()}</h3>
                            <h3 class="ellipsis">Create Date - ${whip.getPrettyCreateDate()}</h3>
                            <h3 class="ellipsis">Purchase Date - ${whip.getPrettyPurchaseDate()}</h3>
                            <div class="flex-row wrap">
                                <div class="flex-col fields">
                                    <p>Price:</p>
                                    <p>Odometer:</p>
                                    <p>MPG:</p>
                                </div>
                                <div class="flex-col values">
                                    <p>$${whip.getPrice()}</p>
                                    <p>${whip.getMileage()} mi</p>
                                    <p>City: ${whip.getcMpg()} / Highway ${whip.gethMpg()}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
