package main;

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoDatabase;

public class Ejercicio4 {
	public final static MongoClient MONGO_CLIENT = new MongoClient();
	public final static MongoDatabase DB = MONGO_CLIENT.getDatabase("EjercicioJava");
	public final static MongoCollection<Document> collection = DB.getCollection("inventario");

	public static void main(String[] args) {
		// Aqui hariamos la llamada de las funciones
		//ej4a(); etc...
	}

	private static void ej4a() {
		System.out.println("-= Ejercicio 4a =-");
		Iterable<Document> iterable = collection.find();
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4b() {
		System.out.println("-= Ejercicio 4b =-");
		Iterable<Document> iterable = collection.find(eq("categoria", "ropa"));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4c() {
		System.out.println("-= Ejercicio 4c =-");
		Iterable<Document> iterable = collection.find(and(eq("categoria", "ropa"), eq("detalles.modelo", "14Q3")));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4d() {
		System.out.println("-= Ejercicio 4d =-");
		Iterable<Document> iterable = collection.find(or(eq("categoria", "hogar"), eq("categoria", "comida")));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4e() {
		System.out.println("-= Ejercicio 4e =-");
		Iterable<Document> iterable = collection.find(or(gt("stock.cantidad", 10), lte("stock.cantidad", 4)));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4f() {
		System.out.println("-= Ejercicio 4f =-");
		Iterable<Document> iterable = collection.find(eq("detalles.proveedor", "M1 Corporation"));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4g() {
		System.out.println("-= Ejercicio 4g =-");
		Iterable<Document> iterable = collection.find(eq("stock.talla", "L"));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}

	private static void ej4h() {
		System.out.println("-= Ejercicio 4h =-");
		Iterable<Document> iterable = collection.find(and(eq("stock.talla", "L"), eq("stock.cantidad", 1)));
		iterable.forEach(doc -> System.out.println(doc.toJson()));
	}
}
