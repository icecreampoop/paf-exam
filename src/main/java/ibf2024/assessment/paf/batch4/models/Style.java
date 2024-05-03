package ibf2024.assessment.paf.batch4.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

// DO NOT MODIFY THIS FILE.

public class Style {

    private int styleId;
    private String name;
    private int beerCount;

    public int getStyleId() {
        return styleId;
    }
    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBeerCount() {
        return beerCount;
    }
    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
    }

    public static Style create (SqlRowSet styleRS) {
        Style style = new Style();

        style.setStyleId(styleRS.getInt("id"));
        style.setName(styleRS.getString("style_name"));
        style.setBeerCount(styleRS.getInt("beer_count"));

        return style;
    }

    @Override
    public String toString() {
        return "Style [styleId=" + styleId + ", name=" + name + ", beerCount=" + beerCount + "]";
    }
}
