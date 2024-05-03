package ibf2024.assessment.paf.batch4.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2024.assessment.paf.batch4.models.Beer;
import ibf2024.assessment.paf.batch4.models.Brewery;
import ibf2024.assessment.paf.batch4.models.Style;

@Repository
public class BeerRepository implements SQLQueries {

	@Autowired
	private JdbcTemplate sqTemplate;

	// DO NOT CHANGE THE SIGNATURE OF THIS METHOD
	public List<Style> getStyles() {
		List<Style> styleList = new ArrayList<>();

		SqlRowSet rs = sqTemplate.queryForRowSet(SQL_GET_STYLE_MODEL_INFO);

		while (rs.next()) {
			Style style = new Style();
			style.setStyleId(rs.getInt("id"));
			style.setName(rs.getString("style_name"));
			style.setBeerCount(rs.getInt("beer_count"));
			styleList.add(style);
		}

		return styleList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public List<Beer> getBreweriesByBeer(String id) {
		List<Beer> beerList = new ArrayList<>();

		SqlRowSet rs = sqTemplate.queryForRowSet(SQL_GET_BEER_MODEL_INFO, id);

		while(rs.next()) {
			Beer beer = new Beer();
			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("descript"));
			beer.setBreweryId(rs.getInt("brewery_id"));
			beer.setBreweryName(rs.getString("brewery_name"));
			beerList.add(beer);
		}

		return beerList;
	}

	// DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
	public Optional<Brewery> getBeersFromBrewery(int id) {
		SqlRowSet rs = sqTemplate.queryForRowSet(SQL_FIND_BEERS_BY_BREWERYID, id);
		Brewery brewery = new Brewery();
		List<Beer> beerList = new ArrayList<>();		

		while (rs.next()) {
			Beer beer = new Beer();
			brewery.setBreweryId(rs.getInt("brewery_id"));
			brewery.setName(rs.getString("brewery_name"));
			brewery.setAddress1(rs.getString("address1"));
			brewery.setAddress2(rs.getString("address2"));
			brewery.setCity(rs.getString("city"));
			brewery.setPhone(rs.getString("phone"));
			brewery.setWebsite(rs.getString("website"));
			brewery.setDescription(rs.getString("brewery_descript"));

			beer.setBeerId(rs.getInt("beer_id"));
			beer.setBeerName(rs.getString("beer_name"));
			beer.setBeerDescription(rs.getString("beer_descript"));
			beer.setBreweryId(rs.getInt("brewery_id"));
			beer.setBreweryName(rs.getString("brewery_name"));

			beerList.add(beer);
		}

		brewery.setBeers(beerList);

		return Optional.of(brewery);
	}
}
