package org.example.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableCountry {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "stulchik";

    static Connection connection() {
        Connection connectionCountry = null;
        try {
            connectionCountry = DriverManager.getConnection(url, login, password);
            Statement statement = connectionCountry.createStatement();
            String sql;
            {
                sql = "CREATE TABLE IF NOT EXISTS COUNTRIES " +
                        "(ID SERIAL PRIMARY KEY," +
                        "NAME VARCHAR(250)," +
                        "CONTINENT VARCHAR(250)," +
                        "CURRENCY VARCHAR NOT NULL," +
                        "CITYID INTEGER REFERENCES CITIES(ID))";
            }
            statement.executeUpdate(sql);
            System.out.println("Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionCountry;
    }

    public static void addCountry(int id,String name, String continent, String currency, int cityId) {
        String sql = "INSERT INTO COUNTRIES(id,name, continent, currency, cityId) values(?,?,?,?,?)";
        try {
            Connection connect = connection();
            PreparedStatement prepare = connect.prepareStatement(sql);
            prepare.setInt(1,id);
            prepare.setString(2,name);
            prepare.setString(3,continent);
            prepare.setString(4,currency);
            prepare.setInt(5,cityId);
            prepare.executeUpdate();
            System.out.println("успешно добавлено");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Country> getAllCountry() {
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("Вывод всех из таблицы");
        String sql = "SELECT * FROM COUNTRIES";
        List<Country> countryList = new ArrayList<>();
        try {
            Connection conn = connection();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setContinent(resultSet.getString("continent"));
                country.setCurrency(resultSet.getString("currency"));
                country.setCityId(resultSet.getInt("cityId"));
                countryList.add(country);

                System.out.println(countryList);
            }
        }catch(SQLException e){
            System.out.println("неуспешно");
        }return countryList;
    }

}
