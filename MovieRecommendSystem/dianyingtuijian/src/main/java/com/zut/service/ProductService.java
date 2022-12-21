package com.zut.service;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;

public interface ProductService {
	//查询热销商品
	public FindIterable<Document> getHotProduct(Bson bson);

	FindIterable<Document> findByMid(Bson bson);
	FindIterable<Document> findByUser(Bson bson);

	FindIterable<Document> getHotRecentlyProduct(Bson yearmonth);
	//查询近期热销商品
	//
}
