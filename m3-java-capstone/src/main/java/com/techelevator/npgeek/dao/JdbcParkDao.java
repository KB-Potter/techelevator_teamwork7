package com.techelevator.npgeek.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.bean.FavoritePark;
import com.techelevator.npgeek.bean.HomePage;
import com.techelevator.npgeek.bean.ParkDetail;
import com.techelevator.npgeek.bean.ParkSurvey;
import com.techelevator.npgeek.bean.Weather;

@Component
public class JdbcParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<HomePage> getAllParks() {
		List<HomePage> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			HomePage park = new HomePage();
			park.setParkcode(results.getString("parkcode"));
			park.setParkdescription(results.getString("parkdescription"));
			park.setLocation(results.getString("state"));
			park.setParkname(results.getString("parkname"));
			park.setImgname();
			allParks.add(park);
		}
		return allParks;
	}
	
//	@Override
//	public List<Review> getAllReviews() {
//		List<Review> allReviews = new ArrayList<>();
//		String sqlSelectAllReviews = "SELECT * FROM reviews";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews);
//		while(results.next()) {
//			Review review = new Review();
//			review.setId(results.getLong("review_id"));
//			review.setUsername(results.getString("username"));
//			review.setRating(results.getInt("rating"));
//			review.setTitle(results.getString("review_title"));
//			review.setText(results.getString("review_text"));
//			review.setDateSubmitted(results.getTimestamp("review_date").toLocalDateTime());
//			allReviews.add(review);
//		}
//		return allReviews;
//	}

	@Override
	public ParkDetail getParkByParkCode(String parkcode) {
		ParkDetail detail = null;
		String sqlSelectParkById = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkById, parkcode);
		if(results.next()) {
			detail = mapRowToDetail(results);
		}
		return detail;
	}
	


	@Override
	public void storeSurveyInput(ParkSurvey post) {
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) "
								+ "VALUES(?,?,?,?,?)";
		Long id = getNextId();
		jdbcTemplate.update(sqlInsertSurvey, id, post.getParkcode(), post.getEmailaddress(), post.getState(), post.getActivitylevel());
		
	}
	
//	public void save(Product product) {
//		String sqlInsertProduct = "INSERT INTO products(product_id, name, description, price, image_name) VALUES(?, ?, ?, ?, ?)";
//		Long id = getNextId();
//		BigDecimal price = new BigDecimal(product.getPrice(id).toString().replace("$", ""));
//		jdbcTemplate.update(sqlInsertProduct, id, product.getName(), product.getDescription(), price, product.getImageName());
//		product.setId(id);
//	}

	@Override
	public List<Weather> getParkWeatherByParkCode(String parkcode) {
		List<Weather> forecast = new ArrayList<>();
		String sqlSelectWeatherByParkCode = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue asc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkCode, parkcode);
		while(results.next()) {
			Weather weather = new Weather();
			weather.setParkcode(results.getString("parkcode").toLowerCase());
			weather.setFivedayforecastvalue(results.getInt("fivedayforecastvalue"));
			weather.setLow(results.getInt("low"));
			weather.setHigh(results.getInt("high"));
			weather.setForecast(results.getString("forecast"));
			forecast.add(weather);
		}
		return forecast;
	}
	
	@Override
	public String getParkNameByParkCode(String parkcode) {
		String name = "";
		String sqlSelectParkName = "SELECT parkname FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkName, parkcode);
		while(results.next()) {
			name = (String)results.getString("parkname");
		}

		return name;
	}
//	@Override
//	public Product getProductById(Long productId) {
//		Product product = null;
//		String sqlSelectProductById = "SELECT * FROM products WHERE product_id = ?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectProductById, productId);
//		if(results.next()) {
//			product = mapRowToProduct(results);
//		}
//		return product;
//	}


	@Override
	public List<FavoritePark> favCount() {
		List<FavoritePark> favParks = new ArrayList<>();
		String sqlSelectFavParks = "SELECT count(survey_result.parkcode), survey_result.parkcode, parkname "
								   + "FROM survey_result JOIN park on survey_result.parkcode = park.parkcode "
								   + "group by park.parkname, survey_result.parkcode order by count desc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectFavParks);
		while(results.next()) {
			FavoritePark park = new FavoritePark();
			park.setParkcode(results.getString("parkcode"));
			park.setParkname(results.getString("parkname"));
			park.setImagename(results.getString("parkcode").toLowerCase());
			park.setCount(results.getInt("count"));
			
			favParks.add(park);
		}
		return favParks;

	}
	


	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}
	private ParkDetail mapRowToDetail(SqlRowSet row) {
		ParkDetail detail = new ParkDetail();
		detail.setParkcode(row.getString("parkcode").toLowerCase());
		detail.setParkname(row.getString("parkname"));
		detail.setState(row.getString("state"));
		detail.setAcreage(row.getInt("acreage"));
		detail.setElevationinfeet(row.getInt("elevationinfeet"));
		detail.setMilesoftrail(row.getDouble("milesoftrail"));
		detail.setNumberofcampsites(row.getInt("numberofcampsites"));
		detail.setClimate(row.getString("climate"));
		detail.setYearfounded(row.getInt("yearfounded"));
		detail.setAnnualvisitorcount(row.getInt("annualvisitorcount"));
		detail.setInspirationalquote(row.getString("inspirationalquote"));
		detail.setInspirationalquotesource(row.getString("inspirationalquotesource"));
		detail.setParkdescription(row.getString("parkdescription"));
		detail.setEntryfee(row.getInt("entryfee"));
		detail.setNumberofanimalspecies(row.getInt("numberofanimalspecies"));
		return detail;
	}


	
}
