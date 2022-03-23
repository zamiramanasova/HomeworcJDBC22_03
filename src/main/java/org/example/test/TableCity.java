package org.example.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class TableCity {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "stulchik";

    static Connection connection() {
        Connection connectionCity = null;
        try {
            connectionCity = DriverManager.getConnection(url, login, password);
            Statement statement = connectionCity.createStatement();
            String sql;
            {
                sql = "CREATE TABLE IF NOT EXISTS CITIES " +
                        "(ID SERIAL PRIMARY KEY," +
                        "CITYNAME VARCHAR(250)," +
                        "AGECITY INTEGER NOT NULL," +
                        "PEOPLE INTEGER NOT NULL," +
                        "MAYORID INTEGER REFERENCES MAYORS(ID))";
            }
            statement.executeUpdate(sql);
            System.out.println("Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionCity;
    }

    public static void addCity(int id,String cityName, int ageCity, int people, int mayorId) {
        String sql1 = "INSERT INTO CITIES(id,cityName ,agecity, people, mayorId) values(?,?,?,?,?)";
        try {
            Connection connect = connection();
            PreparedStatement prepare = connect.prepareStatement(sql1);
            prepare.setInt(1,id);
            prepare.setString(2,cityName);
            prepare.setInt(3,ageCity);
            prepare.setInt(4,people);
            prepare.setInt(5,mayorId);
            prepare.executeUpdate();
            System.out.println("успешно добавлено");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<City> getAllCity() {
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("Вывод всех из таблицы");
        String sql = "SELECT * FROM CITIES";
        List<City> cityList = new ArrayList<>();
        try {
            Connection conn = connection();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setCityName(resultSet.getString("cityName"));
                city.setAgeCity(resultSet.getInt("ageCity"));
                city.setPeople(resultSet.getInt("people"));
                city.setMayorId(resultSet.getInt("mayorId"));
                cityList.add(city);

                System.out.println(cityList);
            }
        }catch(SQLException e){
            System.out.println("неуспешно");
        }return cityList;
    }

}
