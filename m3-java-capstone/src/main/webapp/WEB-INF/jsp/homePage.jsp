<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
    <link rel="stylesheet" href="css/npgeek.css"  />
    <section class="parkList">
        <div class="parkPanel">
            <c:forEach var="loop" items="${HomePage}">
            <!-- Image of Park -->
            <div id="parkImage">
            		<c:url var="parkSession" value="/parkSession">
            			<c:param name="parkcode" value="${loop.parkcode}"></c:param>
            		</c:url>

                <c:url var="parkImgSrc" value="/img/parks/${loop.imgname}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />

                <a href="${parkSession}">
                		<img id="parkImg" src="${parkImgSrc}" alt="Park Image" />
                </a>
            </div>
            <!-- Name of Park -->
            <div class= "parkInfo">
            <c:url var="parkSession" value="/parkSession">
            		<c:param name="parkcode" value="${loop.parkcode}"></c:param>
            	</c:url>
                <c:url var="parkName" value="${loop.parkname}" />
                <h3 id="parkName"><a href="${parkSession}">${parkName}</a></h3>
            <!-- Description of Park -->
                <c:url var="parkDescription" value="${loop.parkdescription}" />
                <p id="parkDescription">${parkDescription}</p>
                </div>
            </c:forEach>
        </div>
    </section>

    <c:import url="/WEB-INF/jsp/common/footer.jsp" />