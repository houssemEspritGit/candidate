package ecommerce.cartservice;

import com.mongodb.client.*;
import ecommerce.cartservice.model.Candidate;
import ecommerce.cartservice.repository.CandidateRepository;
import ecommerce.cartservice.service.CandidateService;
import ecommerce.cartservice.service.CandidateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Collection;
import java.util.List;


@SpringBootTest

class CandidateServiceApplicationTests {
	CandidateRepository candidate;

	CandidateServiceApplicationTests() {
		try (MongoClient mongoClient = MongoClients.create("mongodb+srv://root:root@cluster0.kyifc.mongodb.net/?retryWrites=true&w=majority")) {
			MongoDatabase database = mongoClient.getDatabase("candidateDB");
		}
	}

	@Test
	public void testRetrieveAllUsers() {
		try (MongoClient mongoClient = MongoClients.create("mongodb+srv://root:root@cluster0.kyifc.mongodb.net/?retryWrites=true&w=majority")) {
			MongoDatabase database = mongoClient.getDatabase("candidateDB");
			MongoCollection<Document> collection = database.getCollection("candidate");
			long doc = collection.countDocuments();
			Assertions.assertEquals(true, doc>-1);
		}

	}
	@Test
	public void testCreateUser() {
		try (MongoClient mongoClient = MongoClients.create("mongodb+srv://root:root@cluster0.kyifc.mongodb.net/?retryWrites=true&w=majority")) {
			MongoDatabase database = mongoClient.getDatabase("candidateDB");
			MongoCollection<Document> collection = database.getCollection("candidate");
			long old_doc = collection.countDocuments();
			Document new_user = new Document("name","test_mongo");
			collection.insertOne(new_user);
			long new_doc = collection.countDocuments();
			Assertions.assertEquals(true, new_doc>old_doc);

		}

	}

	@Test
	public void testDeleteUser() {
		try (MongoClient mongoClient = MongoClients.create("mongodb+srv://root:root@cluster0.kyifc.mongodb.net/?retryWrites=true&w=majority")) {
			MongoDatabase database = mongoClient.getDatabase("candidateDB");
			MongoCollection<Document> collection = database.getCollection("candidate");
			long old_doc = collection.countDocuments();
			Document new_user = new Document("name","test_mongo");
			collection.deleteOne(new_user);
			long new_doc = collection.countDocuments();
			Assertions.assertEquals(true, new_doc<old_doc);

		}

	}

}
