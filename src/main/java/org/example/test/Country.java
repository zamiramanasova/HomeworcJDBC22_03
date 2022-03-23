package org.example.test;

public class Country {

    private int id;
    private String name;
    private String continent;
    private String currency;
    private int cityId;

    public Country() {
    }

    public Country(int id, String name, String continent, String currency, int cityId) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.currency = currency;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

//    @Override
//    public String toString() {
//        return "Country{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", continent='" + continent + '\'' +
//                ", currency='" + currency + '\'' +
//                ", cityId=" + cityId +
//                '}';
//    }

    @Override
    public String toString() {
        return "{Country: " +
                " ," + id +
                ", " + name + '\'' +
                ", " + continent + '\'' +
                ", " + currency + '\'' +
                ",cityId- " + cityId +
                '}';
    }
}
