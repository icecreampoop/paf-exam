package ibf2024.assessment.paf.batch4.repositories;

public interface SQLQueries {
    public static final String SQL_GET_STYLE_MODEL_INFO = """
        select count(s.style_name) as beer_count,s.id,s.style_name from styles as s
        join beers as b
        on s.id = b.style_id
        group by s.id
        order by
        beer_count desc,
        style_name asc;
        """;

    public static final String SQL_GET_BEER_MODEL_INFO = """
        select beers.name as beer_name, beers.id as beer_id, breweries.id as brewery_id, beers.descript, breweries.name as brewery_name from beers
        join breweries
        on breweries.id = beers.brewery_id
        where beers.style_id = ?
        order by beers.name asc;
        """;


    public static final String SQL_FIND_BEERS_BY_BREWERYID = """
        select b.id as brewery_id, beers.id as beer_id, beers.name as beer_name, beers.descript as beer_descript, b.name as brewery_name, b.address1, b.address2, b.city, b.phone, b.website, b.descript as brewery_descript from breweries as b
        join beers
        on b.id = beers.brewery_id
        where beers.brewery_id = ?
        order by beer_name asc;
        """;
}
