package org.java.mongo.view;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class SelectFromMongoDB {

	Scanner sc =  new Scanner(System.in);;

	public void viewAllDataFrommongo(MongoCollection<Document> mongoCollection) {
		FindIterable<Document> cursor = mongoCollection.find();
		MongoCursor<Document> mongoCursor = cursor.iterator();
		while (mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next());
		}
	}

	public void viewSpecificDataFromMongo(MongoCollection<Document> mongoCollection) {
		Document searchedDocument = new Document();
		System.out.println("Enter the record id you want to view ... ");
		String key = sc.nextLine();
		System.out.println("Enter the record value you want to view ... ");
		Object value = sc.nextLine();
		searchedDocument.put( key, value);
		System.out.println(searchedDocument.containsValue(value));
		mongoCollection.deleteOne(searchedDocument);
		FindIterable<Document> cursor = mongoCollection.find(searchedDocument);
		MongoCursor<Document> mongoCursor = cursor.iterator();
		while (mongoCursor.hasNext()) {
			System.out.println(mongoCursor.next());
		}
	}
}
