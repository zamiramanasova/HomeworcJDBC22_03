package org.example.test;

public class City {

    private int id;
    private String cityName;
    private int ageCity;
    private int people;
    private int mayorId;

    public City() {
    }

    public City(int id, String cityName, int ageCity, int people, int mayorId) {
        this.id = id;
        this.cityName = cityName;
        this.ageCity = ageCity;
        this.people = people;
        this.mayorId = mayorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAgeCity() {
        return ageCity;
    }

    public void setAgeCity(int continent) {
        this.ageCity = continent;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getMayorId() {
        return mayorId;
    }

    public void setMayorId(int mayorId) {
        this.mayorId = mayorId;
    }
//
//    @Override
//    public String toString() {
//        return "City{" +
//                "id=" + id +
//                ", cityName='" + cityName + '\'' +
//                ", ageCity='" + ageCity + '\'' +
//                ", people=" + people +
//                ", mayorId=" + mayorId +
//                '}';
//    }

    @Override
    public String toString() {
        return  "{City: "+ id + " " + cityName + '\'' +
                ", " + ageCity + '\'' +
                ", " + people +
                ",mayorId- " + mayorId +
                '}';
    }
}
