package com.mongodb.searcher.application.config

import com.mongodb.kotlin.client.MongoClient
import com.mongodb.kotlin.client.MongoDatabase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MongoConfig {

    @Value("\${spring.data.mongodb.uri}")
    lateinit var mongoUri: String

    @Value("\${spring.data.mongodb.database}")
    lateinit var mongoDatabaseName: String

    @Bean
    fun mongoClient(): MongoClient {
        return MongoClient.create(mongoUri)
    }

    @Bean
    fun mongoDatabase(mongoClient: MongoClient): MongoDatabase {
        return mongoClient.getDatabase(mongoDatabaseName)
    }
}
