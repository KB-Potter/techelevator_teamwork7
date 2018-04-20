<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
	<link rel="stylesheet" href="css/npgeekdetails.css"  />
    <section class="parkDetailPanel">
        <!-- PARK IMAGE -->
        <div class="parkImage">
            <c:url var="parkImgSrc" value="/img/parks/${ParkDetail.parkcode}.jpg" />
            <c:url var="broken" value="/img/broken.gif" />
            <img id="parkImg" src="${parkImgSrc}" alt="${broken}" />
        </div>
        <!-- PARK NAME -->
        <div class="parkName">
            <c:url var="parkName" value="${ParkDetail.parkname}" />
            <h3 id="parkName">${parkName}</h3>
        </div>
        <!-- QUOTE -->
        <div class="inspirationalQuote">
            <div class="quote">
                <c:url var="quote" value="${ParkDetail.inspirationalquote}" />
                <p id="inspirationalquote">${quote}</p>
            </div>
            <div class="quoteSource">
                <c:url var="quoteSource" value="${ParkDetail.inspirationalquotesource}" />
                <p id="inspirationalquotesource">${quoteSource}</p>
            </div>
        </div>
        <!-- DESCRIPTION -->
        <c:url var="parkDescription" value="${ParkDetail.parkdescription}" />
                <p id="parkDescription">${parkDescription}</p>
        <!-- FACT AND FIGURES DROPDOWN -->
        <div class="factAndFigures">
            <span>Facts &amp; Figures &#9660;</span>
            <div class="dropdown-content">
                <table class="dropdownTable">
                    <tr>
                        <th>State:</th>
                        <td>${ParkDetail.state}</td>
                        <th></th>
                        <th>Climate:</th>
                        <td>${ParkDetail.climate}</td>
                    </tr>
                    <tr>
                        <th>Year Founded:</th>
                        <td>${ParkDetail.yearfounded}</td>
                        <th></th>
                        <th>Acreage:</th>
                        <td>${ParkDetail.acreage}</td>
                    </tr>
                    <tr>
                        <th>Number of Campsites:</th>
                        <td>${ParkDetail.numberofcampsites}</td>
                        <th></th>
                        <th>Miles of Trail:</th>
                        <td>${ParkDetail.milesoftrail}</td>
                    </tr>
                    <tr>
                        <th>Entry Fee:</th>
                        <td>$${ParkDetail.entryfee}</td>
                        <th></th>
                        <th>Number of Animal Species:</th>
                        <td>${ParkDetail.numberofanimalspecies}</td>
                    </tr>
                    <tr>
                        <th>Annual Visitor Count:</th>
                        <td>${ParkDetail.annualvisitorcount}</td>
                    </tr>
                </table>
            </div>
        </div>
    </section>
    <section class="weatherForcastPanel">
    <c:choose>
		<c:when test = "${Temp == 'C'}">
            <c:import url="/WEB-INF/jsp/weatherPanelCel.jsp" />
         </c:when>
         
         <c:otherwise>
          <c:import url="/WEB-INF/jsp/weatherPanel.jsp" />
         </c:otherwise>
         
    </c:choose>

    </section>

    <c:import url="/WEB-INF/jsp/common/footer.jsp" />
