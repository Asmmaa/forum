package io.pax.forum.dao;

import io.pax.forum.attribute.Topic;
import io.pax.forum.attribute.User;
import io.pax.forum.jdbc.FullTopic;
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
public class TopicDao {

    JdbcConnector connector = new JdbcConnector();

    public void create(int id_user, String subject) throws SQLException {


        String query = "INSERT INTO topic (id_user, subject) VALUES (?, ?)";

        Connection conn = this.connector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id_user);
        stmt.setString(2, subject);


        stmt.executeUpdate();

        stmt.close();
        conn.close();

    }

    public List<Topic> findTopic(int id_user) throws SQLException {
        List<Topic> topics = new ArrayList<>();

        String query = "SELECT * FROM topic t LEFT JOIN user u ON t.id_user=u.id WHERE u.id =?";


        Connection conn = this.connector.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id_user);
        ResultSet rs = stmt.executeQuery();


        while (rs.next()){

            // user
            String name = rs.getString("u.name");

            //topic
            int id = rs.getInt("t.id");
            String subject = rs.getString("t.subject");
            User user = new FullUser(id_user, name);


            Topic topic = new FullTopic(id, subject, user);
            topics.add(topic);

        }

        stmt.close();
        conn.close();

        return topics;
    }

    public static void main(String[] args) throws SQLException {
        TopicDao dao = new TopicDao();
        //dao.create(1,"sport");
        /*dao.create(1,"animaux");
        dao.create(2,"nutrition");
        dao.create(3,"travail");
        dao.create(4,"netflix");*/

        System.out.println(dao.findTopic(2));


    }
}
