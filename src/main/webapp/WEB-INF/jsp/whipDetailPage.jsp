<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/whip-detail-page.css">
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	<div class="flex-row main-content content-center">
        <div class="flex-col content-center">
            <h1>${whip.getTitleName()} - $${whip.getPrice()}</h1>
            <h4 class="slogan">${whip.getSlogan()}</h4>
            <img src="${whip.getImage()}" class="whip-image" />
            <div class="flex-row">
                <div class="flex-col whip-details">
                    <div class="flex-row image-width">
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2mbz03NRQ2MjRXJoNAsGkFFaLensnrdR9yAeetNGEunLNUMaO-GnoBpax5GPt-ydX5L8&usqp=CAU" />
                            <div class="flex-col">
                                <p class="icon-text">City MPG: ${whip.getcMpg()}</p>
                                <p class="icon-text">Highway MPG: ${whip.gethMpg()}</p>
                            </div>
                        </div>
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://www.pngkey.com/png/full/318-3185809_check-engine-light-repairs-check-engine-icon-vector.png" />
                            <div class="flex-col">
                                <p class="icon-text">Engine: ${whip.getEngine()}</p>
                            </div>
                        </div>
                    </div>
                    <div class="flex-row image-width">
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://static.thenounproject.com/png/780267-200.png" />
                            <div class="flex-col">
                                <p class="icon-text">Mileage: ${whip.getMileage()} mi</p>
                            </div>
                        </div>
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://play-lh.googleusercontent.com/JribfaS5kxYHuVO51JadZ4GQDJnW0buYHj1oRJWvLbEe2L9OFFF6td4i18KP4Ksemqg" />
                            <div class="flex-col">
                                <p class="icon-text">Vin: ${whip.getVin()}</p>
                            </div>
                        </div>
                    </div>
                    <div class="flex-row image-width">
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://ps.w.org/ymm-search/assets/icon-256x256.png?rev=1750193" />
                            <div class="flex-col">
                                <p class="icon-text">YMM: ${whip.getYear()} ${whip.getMake()} ${whip.getModel()}</p>
                            </div>
                        </div>
                        <div class="half-width content-left">
                            <img class="detail-icon" src="https://www.shutterstock.com/image-vector/car-trim-icon-vector-on-260nw-1278378709.jpg" />
                            <div class="flex-col">
                                <p class="icon-text">Trim: ${whip.getTrim()}</p>
                            </div>
                        </div>
                    </div>
                    <form:form modelAttribute="whip" action="/whipDetailPage/${whip.getVin()}" method="post">
					    <form:button type="submit" class="buy-button">Buy NOW!</form:button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
