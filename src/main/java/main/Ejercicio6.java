package main;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejercicio6 {
	public final static MongoClient MONGO_CLIENT = new MongoClient();
	public final static MongoDatabase DB = MONGO_CLIENT.getDatabase("EjercicioJava");
	public final static MongoCollection<Document> collection = DB.getCollection("inventario");

	public static void main(String[] args) {
		// Aqui hariamos la llamada de las funciones
		// ej6a(); etc...
	}

	public static void ej6a() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("articulo", "MNO2");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("detalles.modelo", "14Q4").append("categoria", "hogar"));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6b() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("categoria", "hogar");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("categoria", "casa"));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6c() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("articulo", "IJK2");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("stock.talla", "M").append("stock.cantidad", 7));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6d() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("articulo", "ABC2");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("precio", 8.5));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6e() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("articulo", "ABC2");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("precio", 3));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6f() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("categoria", "ropa");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("precio", 6));

		collection.updateMany(searchQuery, updateQuery);
	}

	private static void ej6h() {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.append("articulo", "TBD2");

		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append("$set", new BasicDBObject().append("detalles.modelo", "14Q3").append("proveedor", "IJK Co.")
				.append("categoria", "hogar").append("$upsert", true));

		collection.updateMany(searchQuery, updateQuery);
	}
}
