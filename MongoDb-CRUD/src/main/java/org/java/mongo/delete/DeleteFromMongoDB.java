package org.java.mongo.delete;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class DeleteFromMongoDB {
	
	Scanner sc =  new Scanner(System.in);

	public void deleteSpecificDataFromMongo(MongoCollection<Document> mongoCollection) {
		Document searchedDocument = new Document();
		System.out.println("Enter the record id you want to delete ... ");
		String key = sc.nextLine();
		System.out.println("Enter the record id value you want to delete ... ");
		String value = sc.nextLine();
		searchedDocument.put(key,value);
		mongoCollection.deleteOne(searchedDocument);
	}
}
