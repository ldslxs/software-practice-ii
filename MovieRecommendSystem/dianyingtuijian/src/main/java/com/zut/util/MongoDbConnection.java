package com.zut.util;

import com.zut.pojo.Movie;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class MongoDbConnection {
	public MongoDatabase getDb(String dbname) {
		String uri = "mongodb://localhost";
		MongoClient mongo = MongoClients.create(uri);
		MongoDatabase db=mongo.getDatabase(dbname);
		return db;
	}
	public MongoCollection<Document> getTable(String tablename){
		MongoDatabase db=getDb("recommender");
		MongoCollection<Document> table = db.getCollection(tablename);
		return table;
	}
	public FindIterable<Document> findByFilter(Bson filter){
		MongoCollection<Document> table=getTable("RateMoreMovies");
		// Filters.gt("counts", 3000)
		 FindIterable<Document> findIterable = table.find(filter);
		System.out.println("hahhah"+table.countDocuments());
		 return findIterable;
	}
	public FindIterable<Document> findByUser(Bson filter){
		MongoCollection<Document> table=getTable("User");
		FindIterable<Document> findIterable = table.find(filter);
		System.out.println("hahhah"+table.countDocuments());
		 return findIterable;
	}

	public FindIterable<Document> findByMid(Bson filter) {
		MongoCollection<Document> table=getTable("Movie");
		FindIterable<Document> findIterable = table.find(filter);
		return findIterable;

	}
	public FindIterable<Document> findByRecently(Bson filter) {
		MongoCollection<Document> table=getTable("RateMoreRecentlyMovies");
		FindIterable<Document> findIterable = table.find(filter);
		return findIterable;

	}
}
