package main;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejercicio7 {
	public final static MongoClient MONGO_CLIENT = new MongoClient();
	public final static MongoDatabase DB = MONGO_CLIENT.getDatabase("EjercicioJava");
	public final static MongoCollection<Document> collection = DB.getCollection("inventario");

	public static void main(String[] args) {

	}

	private static void ej7a() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("categoria", "casa");

		BasicDBObject deleteQuery = new BasicDBObject();
		deleteQuery.append("$set", new BasicDBObject().append("detalles.modelo", "14Q3"));

		collection.updateMany(searchQuery, deleteQuery);
	}
}
