<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<link rel="stylesheet" href="css/npgeekdetails.css"  />
    <div class="fiveDayForecast">
    <form action="convertTemp">
    		<button type="submit" name="tempConvert" value="C">Convert to Celsius</button>
    		</form>

        <div class="forcast" id="one">
		<div>Today</div>
			<c:url var="weatherImage" value="/img/weather/${weather.get(0).forecast}" />
            <img class="weatherImg" id="today" src="${weatherImage}.png">
            <div class="high">${weather.get(0).high} F</div>
            <div class="low">${weather.get(0).low} F</div>
        </div>
       <div class="forcast" id="two">
       <div>Day Two</div>
			<c:url var="weatherImage" value="/img/weather/${weather.get(1).forecast}" />
            <img class="weatherImg" id="dayTwo" src="${weatherImage}.png">
            <div class="high">${weather.get(1).high} F</div>
            <div class="low">${weather.get(1).low} F</div>
        </div>
        <div class="forcast" id="three">
        <div>Day Three</div>
			<c:url var="weatherImage" value="/img/weather/${weather.get(2).forecast}" />
            <img class="weatherImg" id="dayThree" src="${weatherImage}.png">
            <div class="high">${weather.get(2).high} F</div>
            <div class="low">${weather.get(2).low} F</div>
        </div>
        <div class="forcast" id="four">
        <div>Day Four</div>
			<c:url var="weatherImage" value="/img/weather/${weather.get(3).forecast}" />
            <img class="weatherImg" id="dayFour" src="${weatherImage}.png">
            <div class="high">${weather.get(3).high} F</div>
            <div class="low">${weather.get(3).low} F</div>
        </div>
        <div class="forcast" id="five">
        <div>Day Five</div>
			<c:url var="weatherImage" value="/img/weather/${weather.get(4).forecast}" />
            <img class="weatherImg" id="dayFive" src="${weatherImage}.png">
            <div class="high">${weather.get(4).high} F</div>
            <div class="low">${weather.get(4).low} F</div>
        </div>
    </div>
 