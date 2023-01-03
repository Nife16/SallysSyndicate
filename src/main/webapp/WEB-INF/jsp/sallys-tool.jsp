<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Sallys Mopar Syndicate</title>
    <link rel="stylesheet" href="/css/flex.css">
    <link rel="stylesheet" href="/css/sallys-tool.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body class="flex-col">
	<div class="flex-row header">
        <a class="header-links" href="/logout">Log Out</a>
        <a class="header-links" href="/whips">HOP IN A WHIP TODAY!</a>
        <a class="header-links" href="/admin-tool">Admin tool</a>
        <div class="icon">${admin.getSappname().toUpperCase().charAt(0)}</div>
    </div>
	<div class="flex-row main-content">
        <div class="center-margin">
            <a href="/reports" class="button">Reports</a>
            <a href="/addWhips" class="button">Add Whips to Lot</a>
        </div>
    </div>
</body>

</html>
