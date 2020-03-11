package main;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoDatabase;

public class Ejercicio5 {
	public final static MongoClient MONGO_CLIENT = new MongoClient();
	public final static MongoDatabase DB = MONGO_CLIENT.getDatabase("EjercicioJava");
	public final static MongoCollection<Document> collection = DB.getCollection("inventario");

	public static void main(String[] args) {
		// Aqui hariamos la llamada de las funciones
		//ej5a(); etc...
	}
	
	// No se como se filtra por 'x' campo hago la consulta normal
	private static void ej5a() {
		System.out.println("-= Ejercicio 5a =-");
		Iterable<Document> iterable = collection.find(and(eq("categoria", "ropa"), eq("detalles.modelo", "14Q3")));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}
	
	private static void ej5b() {
		System.out.println("-= Ejercicio 5b =-");
		Iterable<Document> iterable = collection.find(or(eq("categoria", "hogar"), eq("categoria", "comida")));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}
	
	private static void ej5c() {
		System.out.println("-= Ejercicio 5c =-");
		Iterable<Document> iterable = collection.find(or(gt("stock.cantidad", 10), lte("stock.cantidad", 4)));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}
	
	private static void ej5d() {
		System.out.println("-= Ejercicio 5d =-");
		Iterable<Document> iterable = collection.find(eq("stock.talla", "L"));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}
}
