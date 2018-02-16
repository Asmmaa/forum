package io.pax.forum.ws;

import io.pax.forum.attribute.Topic;
import io.pax.forum.attribute.User;
import io.pax.forum.dao.TopicDao;
import io.pax.forum.dao.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by AELION on 15/02/2018.
 */
@Path("clients")
@Produces(MediaType.APPLICATION_JSON)

public class UserWs {

    @GET
    public List<User> getUsers() throws SQLException {
        UserDao dao = new UserDao();
        return dao.findUsers();
    }

    @GET
    @Path("{id}/topics")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Topic> getTopics(@PathParam("id") int idUser) throws SQLException {
        TopicDao dao = new TopicDao();
        return dao.findTopic(idUser);
    }


    @POST
    /* returns future wallet with an id */
    public void createUser(String name) throws SQLException {

        UserDao dao = new UserDao();
        //User user = new
        dao.create(name);




    }




}