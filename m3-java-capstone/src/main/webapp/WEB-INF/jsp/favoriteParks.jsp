<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
<link rel="stylesheet" href="css/npgeekfaves.css"  />
    <section>
        <div class="parkName">
        
             <h2>Your favorite park: ${PName}</h2>
        </div>
        <div class="favoriteDesc">
            <p>Thank for submitting your survey! Your opinion is valuable to us!<br> Below is a list of visitor favorites!</p>
        </div>
        <div class="favoritesPanel">
            <div class="favList" id="first">
                <!-- Image of Park -->
            <div class="parkImage">
            		<c:url var="parkDetail" value="/parkDetail">
            			<c:param name="parkcode" value="${FavoritePark.get(0).parkcode}"></c:param>
            		</c:url>

                <c:url var="parkImgSrc" value="/img/parks/${FavoritePark.get(0).imagename}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />

                <a href="${parkDetail}">
                		<img id="parkImg" src="${parkImgSrc}" alt="Park Image" />
                </a>
            </div>
            <!-- Name of Park -->
            <div class="parkName">
            <c:url var="parkDetail" value="/parkDetail">
            		<c:param name="parkCode" value="${FavoritePark.get(0).parkname}"></c:param>
            	</c:url>
                <c:url var="parkName" value="${FavoritePark.get(0).parkname}" />
                <h3 id="parkNames"><a href="${parkDetail}">${parkName}</a></h3>
            </div>
            <!-- Count of votes -->
            <div class="parkVote">
                <c:url var="count" value="${FavoritePark.get(0).count}" />
                <p id="parkVote">${count}</p>
            </div>
            
                
   <%--              <c:url var="parkImgSrc" value="/img/parks/${FavoritePark.get(0).imagename}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />
                <img class="parkImg" src="${parkImgSrc}" alt="${broken}" />
                <div class="parkName">
                    <h3>${FavoritePark.get(0).parkname}</h3>
                </div>
                <div class="count">
                    <p>${FavoritePark.get(0).count}</p>
                </div> 
   --%>
   
            </div>
            <div class="favList" id="second">
                <!-- Image of Park -->
            <div class="parkImage">
            		<c:url var="parkDetail" value="/parkDetail">
            			<c:param name="parkcode" value="${FavoritePark.get(1).parkcode}"></c:param>
            		</c:url>

                <c:url var="parkImgSrc" value="/img/parks/${FavoritePark.get(1).imagename}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />

                <a href="${parkDetail}">
                		<img id="parkImg" src="${parkImgSrc}" alt="Park Image" />
                </a>
            </div>
            <!-- Name of Park -->
            <div class="parkName">
            <c:url var="parkDetail" value="/parkDetail">
            		<c:param name="parkCode" value="${FavoritePark.get(1).parkname}"></c:param>
            	</c:url>
                <c:url var="parkName" value="${FavoritePark.get(1).parkname}" />
                <h3 id="parkNames"><a href="${parkDetail}">${parkName}</a></h3>
            </div>
            <!-- Count of votes -->
            <div class="parkVote">
                <c:url var="count" value="${FavoritePark.get(1).count}" />
                <p id="parkVote">${count}</p>
            </div>
            </div> 
           
            
            <div class="favList" id="third">
                <!-- Image of Park -->
            <div class="parkImage">
            		<c:url var="parkDetail" value="/parkDetail">
            			<c:param name="parkcode" value="${FavoritePark.get(2).parkcode}"></c:param>
            		</c:url>

                <c:url var="parkImgSrc" value="/img/parks/${FavoritePark.get(2).imagename}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />

                <a href="${parkDetail}">
                		<img id="parkImg" src="${parkImgSrc}" alt="Park Image" />
                </a>
            </div>
            <!-- Name of Park -->
            <div class="parkName">
            <c:url var="parkDetail" value="/parkDetail">
            		<c:param name="parkCode" value="${FavoritePark.get(2).parkname}"></c:param>
            	</c:url>
                <c:url var="parkName" value="${FavoritePark.get(2).parkname}" />
                <h3 id="parkNames"><a href="${parkDetail}">${parkName}</a></h3>
            </div>
            <!-- Count of votes -->
            <div class="parkVote">
                <c:url var="count" value="${FavoritePark.get(1).count}" />
                <p id="parkVote">${count}</p>
            </div>
            </div>
            
        <c:forEach var="loop" items="${LessFavorite}">
            <!-- Image of Park -->
            <div class="parkImage">
            		<c:url var="parkDetail" value="/parkDetail">
            			<c:param name="parkcode" value="${loop.parkcode}"></c:param>
            		</c:url>

                <c:url var="parkImgSrc" value="/img/parks/${loop.imagename}.jpg" />
                <c:url var="broken" value="/img/broken.gif" />

                <a href="${parkDetail}">
                		<img id="parkImg" src="${parkImgSrc}" alt="Park Image" />
                </a>
            </div>
            <!-- Name of Park -->
            <div class="parkName">
            <c:url var="parkDetail" value="/parkDetail">
            		<c:param name="parkCode" value="${loop.parkname}"></c:param>
            	</c:url>
                <c:url var="parkName" value="${loop.parkname}" />
                <h3 id="parkNames"><a href="${parkDetail}">${parkName}</a></h3>
            </div>
            <!-- Count of votes -->
            <div class="parkVote">
                <c:url var="count" value="${loop.count}" />
                <p id="parkVote">${count}</p>
            </div>
            </c:forEach>
            
        </div>
    </section>

    <c:import url="/WEB-INF/jsp/common/footer.jsp" />



    <!--  The favorite parks page lists the parks in the order of the number of surveys submitted for them. Tying parks should be listed in alphabetical order. At a minimum, the list must include the name of the park, and the count of their surveys. In order to avoid embarrassing any of our wonderful Nation Parks, only show parks with a count of at least 1.  -->
