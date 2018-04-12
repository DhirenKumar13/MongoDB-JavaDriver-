package org.java.mongo.insert;

import java.util.Date;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class InsertToMongoDB {

	public void insertToMongoDb(MongoCollection<Document> mongoCollection) {
		Scanner scanner = new Scanner(System.in);
		Document document = new Document();
		System.out.println("Enter the name of the student");
		String name = scanner.nextLine();
		System.out.println("Enter the age of the student");
		Integer age = scanner.nextInt();
		System.out.println("Enter the salary of the student");
		Double salary = scanner.nextDouble();
		scanner.close();
		document.put("name", name);
		document.put("age", age);
		document.put("salary", salary);
		document.put("joined on", new Date());
		mongoCollection.insertOne(document);
		System.out.println("Insertion completed successfully ...");
	}

}
