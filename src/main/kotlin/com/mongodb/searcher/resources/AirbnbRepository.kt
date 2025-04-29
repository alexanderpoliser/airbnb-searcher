package com.mongodb.searcher.resources

import com.mongodb.client.model.Aggregates
import com.mongodb.client.model.Projections
import com.mongodb.client.model.search.FuzzySearchOptions
import com.mongodb.client.model.search.SearchOperator
import com.mongodb.client.model.search.SearchOptions
import com.mongodb.client.model.search.SearchPath
import com.mongodb.kotlin.client.MongoDatabase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class AirbnbRepository(
    private val mongoDatabase: MongoDatabase
) {

    companion object {
        private val logger = LoggerFactory.getLogger(AirbnbRepository::class.java)
        private const val AIRBNB_COLLECTION_NAME = "listingsAndReviews"
    }

    fun searchByKeywordAndReviewCount(keyword: String, minimumReviewCount: Int): List<AirbnbEntity> {
        val airbnbCollection = mongoDatabase.getCollection<AirbnbEntity>(AIRBNB_COLLECTION_NAME)

        return try {
            airbnbCollection.aggregate(
                listOf(
                    buildSearchStage(keyword, minimumReviewCount),
                    buildLimitStage(),
                    buildProjectionStage()
                )
            ).toList()
        } catch (e: Exception) {
            logger.error("Error aggregating Airbnb collection: ${e.message}")
            emptyList()
        }
    }

    private fun buildSearchStage(keyword: String, minimumReviewCount: Int) =
        Aggregates.search(
            SearchOperator.compound().filter(
                listOf(
                    SearchOperator.numberRange(SearchPath.fieldPath("number_of_reviews"))
                        .gte(minimumReviewCount),
                    SearchOperator.text(SearchPath.fieldPath(AirbnbEntity::summary.name), keyword)
                        .fuzzy(FuzzySearchOptions.fuzzySearchOptions().maxEdits(2))
                )
            ),
            SearchOptions.searchOptions().index("searchPlaces")
        )

    private fun buildLimitStage() =
        Aggregates.limit(5)

    private fun buildProjectionStage() =
        Aggregates.project(
            Projections.fields(
                Projections.include(
                    listOf(
                        AirbnbEntity::name.name,
                        AirbnbEntity::id.name,
                        AirbnbEntity::summary.name,
                        AirbnbEntity::price.name,
                        "number_of_reviews",
                        AirbnbEntity::address.name
                    )
                )
            )
        )

}