package org.java.mongo.main;

import java.util.Scanner;

import org.bson.Document;
import org.java.mongo.connection.MongoCollectionPool;
import org.java.mongo.delete.DeleteFromMongoDB;
import org.java.mongo.insert.InsertToMongoDB;
import org.java.mongo.update.UpdateToMongoDB;
import org.java.mongo.view.SelectFromMongoDB;

import com.mongodb.client.MongoCollection;

public class MongoMainClass {

	public static void main(String[] args) {

		MongoCollection<Document> collection = new MongoCollectionPool().getConnection();
		SelectFromMongoDB selectOperation = new SelectFromMongoDB();

		/*System.out.println("Enter Any Number from the below options ...");
		System.out.println("\"1\" for Insert ...");
		System.out.println("\"2\" for Update ...");
		System.out.println("\"3\" for Delete ...");
		try (Scanner options = new Scanner(System.in)) {
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		/*InsertToMongoDB insertOperation = new InsertToMongoDB();
		insertOperation.insertToMongoDb(collection);
		selectOperation.viewAllDataFrommongo(collection);*/

		UpdateToMongoDB updateOperation = new UpdateToMongoDB();
		updateOperation.updateToMongoDb(collection);
		selectOperation.viewAllDataFrommongo(collection);

		/*DeleteFromMongoDB deleteOperation = new DeleteFromMongoDB();
		deleteOperation.deleteSpecificDataFromMongo(collection);
		selectOperation.viewAllDataFrommongo(collection);*/

		// selectOperation.viewSpecificDataFromMongo(collection);
	}

}
