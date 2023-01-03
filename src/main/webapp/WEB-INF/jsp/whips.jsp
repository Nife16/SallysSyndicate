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
                <h1 class="text-center">Filter Whips</h1>
                <c:forEach items="${filterList}" var="filter">
                    <c:choose>

                        <c:when test = "${activeFilter == 'Reset'}">

                        </c:when>
            
                        <c:when test = "${activeFilter == 'Make'}">
                            <a class="filter-link" href="/whipsBy${activeFilter}/${filter}">${filter}</a>
                        </c:when>
                        
                        <c:otherwise>
                            <a class="filter-link" href="/whipsBy${activeFilter}/${activeMake}/${filter}">${filter}</a>
                        </c:otherwise>
                    </c:choose>
                    </c:forEach> 
                <a class="filter-link reset" href="/whips">RESET</a>
            </div>
            <div class="flex-col content-col">
                <div class="flex-row wrap">
                    <c:forEach items="${whipsOnLot}" var="whip">
                        <a class="whip-link" href="/whipDetailPage/${whip.getVin()}">
                            <div class="flex-col whip-box">
                                <img src="${whip.getImage()}" class="whip-image">
                                <h3 class="ellipsis">${whip.getTitleName()}</h3>
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
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
