package com.thehecklers.aisearchpopulator;

import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class VectorConfig {
/*    @Bean
    public SearchIndexClient searchIndexClient() {
        return new SearchIndexClientBuilder().endpoint(System.getenv("AZURE_AI_SEARCH_ENDPOINT"))
                .credential(new AzureKeyCredential(System.getenv("AZURE_AI_SEARCH_API_KEY")))
                .buildClient();
    }

    @Bean
    public VectorStore vectorStore(SearchIndexClient searchIndexClient, EmbeddingClient embeddingClient) {
        return new AzureVectorStore(searchIndexClient, embeddingClient);
    }*/

    // PostgreSQL / PGvector version
    @Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingClient embeddingClient) {
        return new PgVectorStore(jdbcTemplate, embeddingClient);
    }

/*
    // Neo4j version
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
*/
}
