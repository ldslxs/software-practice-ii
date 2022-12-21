package com.zut.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.zut.pojo.MovieHot;
import com.zut.pojo.User;
import com.zut.service.ProductService;
import com.zut.util.MongoDbConnection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/login")
    public @ResponseBody User getHotProductList(@RequestParam String username, @RequestParam String password) {
        System.out.println(username + password);
        FindIterable<Document> iterator = productService.findByUser(Filters.eq("username", username));
        MongoCursor<Document> mongoCursor2 = iterator.iterator();
        User user = new User();
        if(!mongoCursor2.hasNext()){
            throw new RuntimeException("用户名或密码错误");
        }
            Document next = mongoCursor2.next();

            if (password.equals(next.getString("password"))) {
                user.setUsername(username);
                user.setPassword(password);
            }




        return user;
    }
    @Autowired
    private ObjectMapper objectMapper;
    @RequestMapping("/registry")
    public @ResponseBody User Registry(@RequestParam String username, @RequestParam String password) {
        System.out.println(username + password);
        MongoDbConnection mongoDbConnection = new MongoDbConnection();
        MongoCollection<Document> user1 = mongoDbConnection.getTable("User");
        User user=new User(username,password);
        try {
            user1.insertOne(Document.parse(objectMapper.writeValueAsString(user)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


}
