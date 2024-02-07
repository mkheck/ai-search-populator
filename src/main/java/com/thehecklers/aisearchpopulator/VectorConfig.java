package com.thehecklers.aisearchpopulator;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class VectorConfig {
    @Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingClient embeddingClient) {
        return new PgVectorStore(jdbcTemplate, embeddingClient);
    }

//    @Bean
//    public VectorStore vectorStore(Driver driver, EmbeddingClient embeddingClient) {
//        return new Neo4jVectorStore(driver, embeddingClient,
//                Neo4jVectorStore.Neo4jVectorStoreConfig.defaultConfig());
//    }

//    @Bean
//    public Driver driver() {
////        return GraphDatabase.driver(neo4jContainer.getBoltUrl(),
////                AuthTokens.basic("neo4j", neo4jContainer.getAdminPassword()));
////		return GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "needcoffee"));
//
////        System.out.println(" <<<>>> ");
////        System.out.println(System.getenv("SPRING_NEO4J_URI"));
////        System.out.println(System.getenv("SPRING_NEO4J_AUTHENTICATION_USERNAME"));
////        System.out.println(System.getenv("SPRING_NEO4J_AUTHENTICATION_PASSWORD"));
////        System.out.println(" <<<>>> ");
//
////        return GraphDatabase.driver(System.getenv("SPRING_NEO4J_URI"));
//        return GraphDatabase.driver(System.getenv("SPRING_NEO4J_URI"),
//                AuthTokens.basic(System.getenv("SPRING_NEO4J_AUTHENTICATION_USERNAME"),
//                        System.getenv("SPRING_NEO4J_AUTHENTICATION_PASSWORD")));
//    }

//    @Bean
//    public EmbeddingClient embeddingClient() {
//        return new OpenAiEmbeddingClient(new OpenAiApi(System.getenv("OPENAI_API_KEY")));
//    }
}
