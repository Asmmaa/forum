package io.pax.forum.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by AELION on 15/02/2018.
 */
public class JpaUserDao {

    public JpaUser create(String name){

        JpaUser user = new JpaUser();
        EntityManagerFactory em = Persistence.createEntityManagerFactory("forum");



        return user;

    }
}
