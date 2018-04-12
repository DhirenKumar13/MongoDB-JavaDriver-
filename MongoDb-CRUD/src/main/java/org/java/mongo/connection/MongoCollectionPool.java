package org.java.mongo.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoCollectionPool {

	private MongoCollection<Document> collection;
	private String url = "" ;
	private Integer port;
	public MongoCollection<Document> getConnection() {
		Properties prop = new Properties();
		try(InputStream input = new FileInputStream("src/main/resources/database.properties")) {
			
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			System.out.println(prop.getProperty("database.mongo.url"));
			System.out.println(prop.getProperty("database.mongo.port"));
			url = prop.getProperty("database.mongo.url");
			port = Integer.valueOf(prop.getProperty("database.mongo.port"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient(url, port);
		MongoDatabase database = mongoClient.getDatabase(prop.getProperty("database.name"));
		collection = database.getCollection(prop.getProperty("database.collection.name"));
		return collection;
	}

}
