package com.project.journalApp.repository;

import com.project.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;



public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSentimentAnalysis() {
        Query query = new Query();
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        query.addCriteria(Criteria.where("email").exists(true).ne(""));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;

    }
}
