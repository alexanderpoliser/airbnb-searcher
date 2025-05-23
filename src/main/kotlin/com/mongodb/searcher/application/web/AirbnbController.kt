package com.mongodb.searcher.application.web

import com.mongodb.searcher.domain.Airbnb
import com.mongodb.searcher.domain.AirbnbSearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AirbnbController(
    private val airbnbService: AirbnbSearchService
) {

    @GetMapping("/airbnb/search")
    fun find(
        @RequestParam("query") query: String,
        @RequestParam("minNumberReviews") minNumberReviews: Int
    ): List<Airbnb> {
        return airbnbService.searchByQueryAndReviews(query, minNumberReviews)
    }
}