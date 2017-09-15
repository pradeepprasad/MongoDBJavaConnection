package MongoTest.JavaClient;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Java + MongoDB  Example
 *
 */
public class AppForMongoJavaDriver {
	public static void main(final String[] args) {
		// Establish connection
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        // get handle to "admin" database
        MongoDatabase database = mongoClient.getDatabase("admin");

        // get a handle to the "Customer" collection
        MongoCollection<Document> collection = database.getCollection("Customer");

        // Print the count
               
        System.out.println("Count of Collection - " + collection.count());

        // Print all documents
        System.out.println(" collection print starts here");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
                
            }
        } finally {
        	System.out.println("Collection print Ends here");
            cursor.close();
            mongoClient.close();
        }
             
}
}