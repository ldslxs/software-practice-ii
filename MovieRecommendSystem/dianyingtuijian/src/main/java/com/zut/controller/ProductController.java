package com.zut.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.zut.pojo.Data;
import com.zut.pojo.Movie;
import com.zut.pojo.MovieHot;
import com.zut.service.ProductService;
import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/pro")
public class ProductController {
	@Autowired
	private ProductService prodcutService;
	@RequestMapping("/findhot")
	public @ResponseBody List<MovieHot> getHotProductList(@RequestParam int counts){
		System.out.println("counts = " + counts);
		FindIterable<Document> iterator=prodcutService.getHotProduct(Filters.gte("count", counts));
		MongoCursor<Document> mongoCursor2 = iterator.iterator();
		int sum=0;
		List<MovieHot>list=new ArrayList<>();
		while(mongoCursor2.hasNext()){
			if(sum==5)break;
			Document next = mongoCursor2.next();
			int mid = (int)next.get("mid");
			FindIterable<Document> iterator1=prodcutService.findByMid(Filters.gte("mid", mid));
			MongoCursor<Document> iterator2 = iterator1.iterator();
			Document movie = iterator2.next();
			MovieHot movieHot=new MovieHot();
			movieHot.setMid(mid);
			movieHot.setName((String) movie.get("name"));
			movieHot.setImgUrl("img/"+mid+"");
			list.add(movieHot);
			System.out.println(next);
			sum+=1;
		}  

		return list;
	}
	@RequestMapping("/findrecentlyhot")
	public @ResponseBody List<MovieHot> getHotRecentlyProductList(@RequestParam int yearmonth){
		System.out.println("counts = " + yearmonth);
		FindIterable<Document> iterator=prodcutService.getHotRecentlyProduct(Filters.gte("yearmonth", yearmonth));
		MongoCursor<Document> mongoCursor2 = iterator.iterator();
		int sum=0;
		List<MovieHot>list=new ArrayList<>();
		while(mongoCursor2.hasNext()){
			if(sum==5)break;
			Document next = mongoCursor2.next();
			int mid = (int)next.get("mid");
			FindIterable<Document> iterator1=prodcutService.findByMid(Filters.gte("mid", mid));
			MongoCursor<Document> iterator2 = iterator1.iterator();
			Document movie = iterator2.next();
			MovieHot movieHot=new MovieHot();
			movieHot.setMid(mid);
			movieHot.setName((String) movie.get("name"));
			movieHot.setImgUrl("img/"+mid+"");
			list.add(movieHot);
			System.out.println(next);
			sum+=1;
		}

		return list;
	}
	@RequestMapping("/getdata")
	public @ResponseBody List<MovieHot> getData(@RequestParam int counts){
		System.out.println("counts = " + counts);
		FindIterable<Document> iterator=prodcutService.getHotProduct(Filters.gte("count", counts));
		MongoCursor<Document> mongoCursor2 = iterator.iterator();
		int sum=0;

		List<MovieHot>list=new ArrayList<>();
		while(mongoCursor2.hasNext()){
			if(sum==5)break;
			Document next = mongoCursor2.next();
			int mid = (int)next.get("mid");
			long count=(long)next.get("count");//电影评价总数
			FindIterable<Document> iterator1=prodcutService.findByMid(Filters.gt("mid", mid));
			MongoCursor<Document> iterator2 = iterator1.iterator();
			Document movie = iterator2.next();

			MovieHot movieHot=new MovieHot();
			movieHot.setMid(mid);
			movieHot.setName((String) movie.get("name"));
			System.out.println("movieHot.getName() = " + movieHot.getName());
			movieHot.setImgUrl("img/"+mid+"");
			movieHot.setCount(count);
			list.add(movieHot);

			System.out.println(next);
			sum+=1;
		}

		return list;
	}
	@RequestMapping("/getrecentlydata")
	public @ResponseBody List<Data> getRecentlyData(@RequestParam int yearmonth){
		FindIterable<Document> iterator=prodcutService.getHotRecentlyProduct(Filters.gte("yearmonth", yearmonth));
		System.out.println("yearmonth = " + yearmonth);
		MongoCursor<Document> mongoCursor2 = iterator.iterator();
		int sum=0;
		List<Data>list=new ArrayList<>();
		while(mongoCursor2.hasNext()){
			if(sum==5)break;
			Document next = mongoCursor2.next();
			int mid = (int)next.get("mid");
			long count=(long)next.get("count");//电影评价总数
			FindIterable<Document> iterator1=prodcutService.findByMid(Filters.gt("mid", mid));
			MongoCursor<Document> iterator2 = iterator1.iterator();
			Document movie = iterator2.next();

			Data data=new Data();
			data.setName((String) movie.get("name"));
			data.setValue((int)count);

			System.out.println("movieHot.getName() = " + data.getName()+mid);


			list.add(data);
			System.out.println(next);
			sum+=1;
		}

		return list;
	}
}	
