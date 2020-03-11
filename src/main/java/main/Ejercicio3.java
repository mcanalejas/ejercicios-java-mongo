package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejercicio3 {
	public final static MongoClient MONGO_CLIENT = new MongoClient();
	public final static MongoDatabase DB = MONGO_CLIENT.getDatabase("EjercicioJava");
	public final static MongoCollection<Document> collection = DB.getCollection("inventario");

	public static void main(String[] args) {
		//insertarDocumentos(collection);
	}

	public static void insertarDocumentos(MongoCollection<Document> collection) {
		Document doc1 = new Document("articulo", "ABC1")
				.append("detalles", new Document("modelo", "14Q3").append("proveedor", "XYZ Company"))
				.append("stock", Arrays.asList(new Document("talla", "S").append("cantidad", 25),
						new Document("talla", "M").append("cantidad", 50)))
				.append("categoria", "ropa");

		Document doc2 = new Document("articulo", "ABC2")
				.append("detalles", new Document("modelo", "14Q3").append("proveedor", "M1 Corporation"))
				.append("stock", Arrays.asList(new Document("talla", "M").append("cantidad", 50)))
				.append("categoria", "ropa");

		Document doc3 = new Document("articulo", "MNO2")
				.append("detalles", new Document("modelo", "14Q3").append("proveedor", "ABC Company"))
				.append("stock",
						Arrays.asList(new Document("talla", "S").append("cantidad", 5),
								new Document("talla", "M").append("cantidad", 5),
								new Document("talla", "L").append("cantidad", 1)))
				.append("categoria", "ropa");

		Document doc4 = new Document("articulo", "IJK2")
				.append("detalles", new Document("modelo", "14Q2").append("proveedor", "M5 Corporation"))
				.append("stock", Arrays.asList(new Document("talla", "S").append("cantidad", 5),
						new Document("talla", "L").append("cantidad", 1)))
				.append("categoria", "ropa");

		Document doc5 = new Document("articulo", "IJK2")
				.append("detalles", new Document("modelo", "14Q2").append("proveedor", "M5 Corporation"))
				.append("stock", Arrays.asList(new Document("talla", "S").append("cantidad", 5),
						new Document("talla", "L").append("cantidad", 1)))
				.append("categoria", "hogar");

		List<Document> documents = new ArrayList<Document>();
		documents.add(doc1);
		documents.add(doc2);
		documents.add(doc3);
		documents.add(doc4);
		documents.add(doc5);

		collection.insertMany(documents);
	}
}
