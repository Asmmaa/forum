package io.pax.forum.jdbc;

import io.pax.forum.attribute.Topic;
import io.pax.forum.attribute.User;

import java.util.List;

/**
 * Created by AELION on 15/02/2018.
 */
public class FullUser implements User {
    int id;
    String name;

    public FullUser() {

    }

    public FullUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Topic> getTopic() {
        return null;
    }

    @Override
    public String toString() {
        return "User" + id +
                ": { name='" + name + '\'' +
                '}';
    }
}
