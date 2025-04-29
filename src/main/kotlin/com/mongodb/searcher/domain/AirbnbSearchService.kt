package com.mongodb.searcher.domain

import com.mongodb.searcher.resources.AirbnbRepository
import org.springframework.stereotype.Service

@Service
class AirbnbSearchService(
    private val airbnbRepository: AirbnbRepository
) {

    fun searchByQueryAndReviews(keyword: String, minimumReviewCount: Int): List<Airbnb> {
        require(keyword.isNotEmpty()) { "Search keyword must not be empty" }
        require(minimumReviewCount > 0) { "Minimum review count must be greater than zero" }

        return airbnbRepository.searchByKeywordAndReviewCount(keyword, minimumReviewCount).map { it.toDomain() }
    }
}
