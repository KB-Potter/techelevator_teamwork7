<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>National Park Geek</title>
        <link rel="stylesheet" href="css/header.css" />
    </head>
        <header>
            <div class="headerImg">
                <c:url value="/img/logo.png" var="logoImgSrc" />
                <c:url var="homePageHref" value="/" />
                <a href="">
                		<img id="logoImg" src="${logoImgSrc}" alt="Logo">
                </a>
            </div>
        </header>
        
       		<div class="pages">
                <c:url var="homePageHref" value="/" />
                <p class="options" id="linkOne"><a href="${homePageHref}">Home</a></p>
                <c:url var="surveyPageHref" value="/survey" />
                <p class="options" id="linkTwo"><a href="${surveyPageHref}">Survey</a></p>
            </div>
       
        <div id="container" class="wrapper">
