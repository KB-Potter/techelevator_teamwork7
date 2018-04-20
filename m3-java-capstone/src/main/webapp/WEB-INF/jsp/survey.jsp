<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:import url="/WEB-INF/jsp/common/header.jsp" />
    <link rel="stylesheet" href="css/npgeeksurvey.css"  />

    <section>
        <!-- PARK SURVEY DETAILS -->
        <div class="parkName">
            <h2>${ParkSurvey.parkname} Survey</h2>
        </div>
        <div class="sentence">
            <p>Please take this short survey of your favorite park!</p>
        </div>
        <!-- PARK SURVEY DETAILS -->
        <!-- SURVEY FORM -->
        <form action="favoriteParks" method = "POST" modelAttribute = "survey">
            <div class="parkSelection">
                <p>Favorite National Park</p>
                <select id="parkDropdown" name="parkcode" required>
                <c:forEach var="parkList" items="${HomePage}">
                    <option value="${parkList.parkcode}">${parkList.parkname}</option>
                </c:forEach>
                </select>
            </div>
            <div class="emailEntry">
                <p>Your Email</p>
                <input name = "emailaddress" value = "emailaddress" type="email" placeholder="Enter Your Email" required>
            </div>
            <div class="stateSelection">
                <p>State of Residence</p>
                <select id="stateDropdown" name="state" required>
                     <option value="AL">Alabama</option>
					<option value="AK">Alaska</option>
					<option value="AZ">Arizona</option>
					<option value="AR">Arkansas</option>
					<option value="CA">California</option>
					<option value="CO">Colorado</option>
					<option value="CT">Connecticut</option>
					<option value="DE">Delaware</option>
					<option value="DC">District Of Columbia</option>
					<option value="FL">Florida</option>
					<option value="GA">Georgia</option>
					<option value="HI">Hawaii</option>
					<option value="ID">Idaho</option>
					<option value="IL">Illinois</option>
					<option value="IN">Indiana</option>
					<option value="IA">Iowa</option>
					<option value="KS">Kansas</option>
					<option value="KY">Kentucky</option>
					<option value="LA">Louisiana</option>
					<option value="ME">Maine</option>
					<option value="MD">Maryland</option>
					<option value="MA">Massachusetts</option>
					<option value="MI">Michigan</option>
					<option value="MN">Minnesota</option>
					<option value="MS">Mississippi</option>
					<option value="MO">Missouri</option>
					<option value="MT">Montana</option>
					<option value="NE">Nebraska</option>
					<option value="NV">Nevada</option>
					<option value="NH">New Hampshire</option>
					<option value="NJ">New Jersey</option>
					<option value="NM">New Mexico</option>
					<option value="NY">New York</option>
					<option value="NC">North Carolina</option>
					<option value="ND">North Dakota</option>
					<option value="OH">Ohio</option>
					<option value="OK">Oklahoma</option>
					<option value="OR">Oregon</option>
					<option value="PA">Pennsylvania</option>
					<option value="RI">Rhode Island</option>
					<option value="SC">South Carolina</option>
					<option value="SD">South Dakota</option>
					<option value="TN">Tennessee</option>
					<option value="TX">Texas</option>
					<option value="UT">Utah</option>
					<option value="VT">Vermont</option>
					<option value="VA">Virginia</option>
					<option value="WA">Washington</option>
					<option value="WV">West Virginia</option>
					<option value="WI">Wisconsin</option>
					<option value="WY">Wyoming</option>
                </select>
            </div>
            <br>
            <div class="activityLevel">
            <p>Level of Activity</p>
                <div id="button"><input type="radio" name="activitylevel" value="inactive" checked/><small>Inactive</small>
                <input type="radio" name="activitylevel" value="sedentary" /><small>Sedentary</small>
                <input type="radio" name="activitylevel" value="active" /><small>Active</small>
                <input type="radio" name="activitylevel" value="extremely active" /><small>Extremely Active</small>
                </div>
            </div>
            <br>
            <div class="submitButton">
            <input type="submit" value="Submit" />
            </div>
        </form>
        <!-- SURVEY FORM -->
    </section>

    <c:import url="/WEB-INF/jsp/common/footer.jsp" />
