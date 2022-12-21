package com.zut.service.impl;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;
import com.mongodb.client.FindIterable;
import com.zut.service.ProductService;
import com.zut.util.MongoDbConnection;
@Service
public class ProductServiceImpl implements ProductService {
	MongoDbConnection mongoDbConnection=new MongoDbConnection();
	@Override
	public FindIterable<Document> getHotProduct(Bson bson) {
		return mongoDbConnection.findByFilter(bson);
	}

	@Override
	public FindIterable<Document> findByMid(Bson bson) {
		return mongoDbConnection.findByMid(bson);
	}

	@Override
	public FindIterable<Document> findByUser(Bson bson) {
		return mongoDbConnection.findByUser(bson);
	}

	@Override
	public FindIterable<Document> getHotRecentlyProduct(Bson bson) {
		return mongoDbConnection.findByRecently(bson);
	}

}
