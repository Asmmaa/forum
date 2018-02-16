package io.pax.forum.ws;

import io.pax.forum.dao.TopicDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

/**
 * Created by AELION on 16/02/2018.
 */
@Path("topics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TopicWs {



//    @GET
//    @Path("{id}/topics")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<Topic> getTopics(@PathParam("id") int idUser) throws SQLException {
//        TopicDao dao = new TopicDao();
//        return dao.findTopic(idUser);
//    }


    @POST
    public void createTopic(int id_user, String subject) throws SQLException {

        TopicDao dao = new TopicDao();
        dao.create(id_user, subject);
    }


    }
