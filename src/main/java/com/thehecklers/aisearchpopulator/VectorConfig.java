package com.thehecklers.aisearchpopulator;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.openai.OpenAiEmbeddingClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.vectorstore.Neo4jVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VectorConfig {
/*
    @Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingClient embeddingClient) {
        return new PgVectorStore(jdbcTemplate, embeddingClient);
    }
*/

    @Bean
    public VectorStore vectorStore(Driver driver, EmbeddingClient embeddingClient) {
        return new Neo4jVectorStore(driver, embeddingClient,
                Neo4jVectorStore.Neo4jVectorStoreConfig.defaultConfig());
    }

    @Bean
    public Driver driver() {
        return GraphDatabase.driver(System.getenv("SPRING_NEO4J_URI"),
                AuthTokens.basic(System.getenv("SPRING_NEO4J_AUTHENTICATION_USERNAME"),
                        System.getenv("SPRING_NEO4J_AUTHENTICATION_PASSWORD")));
    }

    @Bean
    public EmbeddingClient embeddingClient() {
        return new OpenAiEmbeddingClient(new OpenAiApi(System.getenv("OPENAI_API_KEY")));
    }
}
