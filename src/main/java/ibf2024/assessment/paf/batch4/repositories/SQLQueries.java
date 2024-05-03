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
}
