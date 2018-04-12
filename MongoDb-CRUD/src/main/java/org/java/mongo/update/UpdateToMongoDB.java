package org.java.mongo.update;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class UpdateToMongoDB {
	
	Document document = new Document();
	Document documentSearched = new Document();
	Document docUpdated = new Document();
	Scanner scanner = new Scanner(System.in);
	
	public void updateToMongoDb(MongoCollection<Document> mongoCollection) {
		System.out.println("Enter the document key / id you want to search for update ...");
		String searchKey = scanner.nextLine();

		System.out.println("Enter the document value you want to search for update ...");
		Object searchValue = scanner.nextLine();

		documentSearched.put(searchKey, searchValue);

		System.out.println("Enter the document value you want to update ...");
		Object updatedValue = scanner.nextLine();

		document.put(searchKey, updatedValue);
		docUpdated.put("$set", document);
		scanner.close();
		mongoCollection.updateOne(documentSearched, docUpdated);
	}

}
