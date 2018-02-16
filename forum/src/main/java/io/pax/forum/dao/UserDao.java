package io.pax.forum.dao;


import io.pax.forum.attribute.User;
import io.pax.forum.jdbc.FullUser;
import io.pax.forum.jdbc.JdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AELION on 15/02/2018.
 */

public class UserDao {

    JdbcConnector connector = new JdbcConnector();

    public void create(String name) throws SQLException {

        int user_id = 0;
        String query = "INSERT INTO user (name) VALUES (?)";

        Connection conn = this.connector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, name);
        //stmt.setInt(2, id);

        stmt.executeUpdate();

        stmt.close();
        conn.close();

       // return user_id;

    }

    public List<User> findUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        String query ="SELECT id, name FROM user ";

        Connection conn = this.connector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();


        while (rs.next()){

        int id = rs.getInt("id");
        String name = rs.getString("name");


            User user = new FullUser(id, name);
            users.add(user);

        }

        stmt.close();
        conn.close();

        return users;
    }

    public static void main(String[] args) throws SQLException {
        UserDao dao = new UserDao();
        /*dao.create("kelly");
        dao.create("ken");
        dao.create("kinder");
        dao.create("kate");*/

        System.out.println(dao.findUsers());


    }


}
