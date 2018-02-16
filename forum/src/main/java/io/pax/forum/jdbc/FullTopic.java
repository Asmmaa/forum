package io.pax.forum.jdbc;

import io.pax.forum.attribute.Topic;
import io.pax.forum.attribute.User;

/**
 * Created by AELION on 15/02/2018.
 */
public class FullTopic implements Topic {

    int id;
    String subject;
    User user;

    public FullTopic(int id, String subject, User user) {
        this.id = id;
        this.subject = subject;
        this.user = user;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", user=" + user +
                '}';
    }
}
