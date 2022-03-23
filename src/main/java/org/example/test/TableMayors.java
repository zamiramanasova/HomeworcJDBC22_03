package org.example.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableMayors {

        private static final String url = "jdbc:postgresql://localhost:5432/postgres";
        private static final String login = "postgres";
        private static final String password = "stulchik";

    static Connection connection() {
        Connection connectionMayor = null;
        try {
            connectionMayor = DriverManager.getConnection(url, login, password);
            Statement statement = connectionMayor.createStatement();
            String sql;
            {
                sql = "CREATE TABLE IF NOT EXISTS MAYORS " +
                        "(ID SERIAL PRIMARY KEY," +
                        "PROFESSION VARCHAR(250)," +
                        "NAME VARCHAR(250)," +
                        "AGE INTEGER NOT NULL)";
            }
            statement.executeUpdate(sql);
            System.out.println("Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connectionMayor;
    }

    public static void addMayors(int id,String profession, String name, int age) {
        String sql = "INSERT INTO MAYORS(id,profession, name, age) values(?,?,?,?)";
        try {
            Connection connect = connection();
            PreparedStatement prepare = connect.prepareStatement(sql);
            prepare.setInt(1,id);
            prepare.setString(2,profession);
            prepare.setString(3,name);
            prepare.setInt(4,age);
            prepare.executeUpdate();
            System.out.println("успешно добавлено");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Mayor> getAllMayors() {
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("Вывод всех из таблицы");
        String sql = "SELECT * FROM MAYORS";
        List<Mayor> mayorList = new ArrayList<>();
        try {
            Connection conn = connection();
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while(resultSet.next()) {
                Mayor mayor = new Mayor();
                mayor.setId(resultSet.getInt("id"));
                mayor.setProfession(resultSet.getString("profession"));
                mayor.setName(resultSet.getString("name"));
                mayor.setAge(resultSet.getInt("age"));
                mayorList.add(mayor);

                System.out.println(mayorList);
            }
        }catch(SQLException e){
            System.out.println("неуспешно");
        }return mayorList;
    }

}

