package com.turbomates.betbalancer.api.prematch

import com.turbomates.betbalancer.PreMatchConfig
import com.turbomates.betbalancer.api.client
import com.turbomates.betbalancer.api.prematch.request.CategoriesRequest
import com.turbomates.betbalancer.api.prematch.request.CompetitorsRequest
import com.turbomates.betbalancer.api.prematch.request.MarketsRequest
import com.turbomates.betbalancer.api.prematch.request.MatchRequest
import com.turbomates.betbalancer.api.prematch.request.OutcomesRequest
import com.turbomates.betbalancer.api.prematch.request.OutrightsRequest
import com.turbomates.betbalancer.api.prematch.request.PlayersRequest
import com.turbomates.betbalancer.api.prematch.request.SpecsRequest
import com.turbomates.betbalancer.api.prematch.request.SportsRequest
import com.turbomates.betbalancer.api.prematch.request.TournamentsRequest
import com.turbomates.betbalancer.api.prematch.response.CategoriesResponse
import com.turbomates.betbalancer.api.prematch.response.CompetitorsResponse
import com.turbomates.betbalancer.api.prematch.response.MarketsResponse
import com.turbomates.betbalancer.api.prematch.response.MatchesResponse
import com.turbomates.betbalancer.api.prematch.response.OutcomesResponse
import com.turbomates.betbalancer.api.prematch.response.PlayersResponse
import com.turbomates.betbalancer.api.prematch.response.SpecsResponse
import com.turbomates.betbalancer.api.prematch.response.SportsResponse
import com.turbomates.betbalancer.api.prematch.response.TournamentsResponse
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PreMatchAPI(val config: PreMatchConfig) {
    suspend inline fun <reified T> get(path: String, parameters: HttpRequestBuilder.() -> Unit = {}): T {
        return client.get(config.host + path) {
            parameter("bookmakerName", config.bookmakerName)
            parameter("key", config.key)
            parameters()
        }.body()
    }

    suspend fun sports(request: SportsRequest.() -> Unit = {}): SportsResponse {
        val parameters = SportsRequest().apply(request)
        return get("/export/getSports") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
        }
    }

    suspend fun categories(request: CategoriesRequest.() -> Unit = {}): CategoriesResponse {
        val parameters = CategoriesRequest().apply(request)
        return get("/export/getCategories") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
            parameter("categoryId", parameters.categoryId?.toString())
        }
    }

    suspend fun tournaments(request: TournamentsRequest.() -> Unit = {}): TournamentsResponse {
        val parameters = TournamentsRequest().apply(request)
        return get("/export/getTournaments") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
            parameter("categoryId", parameters.categoryId?.toString())
        }
    }

    suspend fun markets(request: MarketsRequest.() -> Unit = {}): MarketsResponse {
        val parameters = MarketsRequest().apply(request)
        return get("/export/getMarkets") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
            parameter("marketId", parameters.marketId?.toString())
        }
    }

    suspend fun specs(request: SpecsRequest.() -> Unit = {}): SpecsResponse {
        val parameters = SpecsRequest().apply(request)
        return get("/export/getSpecs") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
            parameter("marketId", parameters.marketId?.toString())
            parameter("specId", parameters.specId?.toString())
        }
    }

    suspend fun players(playerIds: List<Int>, request: PlayersRequest.() -> Unit = {}): PlayersResponse {
        val parameters = PlayersRequest(playerIds).apply(request)
        return get("/export/getPlayers") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("playerId", parameters.playerIds.joinToString())
        }
    }

    suspend fun competitors(playerIds: List<Int>, request: CompetitorsRequest.() -> Unit = {}): CompetitorsResponse {
        val parameters = CompetitorsRequest(playerIds).apply(request)
        return get("/export/getCompetitors") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("competitorId", parameters.competitorIds.joinToString())
        }
    }

    suspend fun outright(outrightId: Int, request: OutrightsRequest.() -> Unit = {}): CompetitorsResponse {
        val parameters = OutrightsRequest(outrightId).apply(request)
        return get("/export/getOutrights") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("outrightId", parameters.outrightId)
        }
    }

    suspend fun outcomes(outcomeIds: List<Int>, request: OutcomesRequest.() -> Unit = {}): OutcomesResponse {
        val parameters = OutcomesRequest(outcomeIds).apply(request)
        return get("/export/getOutcomes") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("outcomeId", parameters.outcomeIds.joinToString())
        }
    }

    suspend fun match(request: MatchRequest.() -> Unit = {}): MatchesResponse {
        val parameters = MatchRequest().apply { request }
        return get("/export/getMatch") {
            parameter("matchIdList", parameters.matchIdList?.joinToString())
            parameter("matchId", parameters.matchId?.toString())
            parameter("sportId", parameters.sportId?.toString())
            parameter("categoryId", parameters.categoryId?.toString())
            parameter("tournamentId", parameters.tournamentId?.toString())
        }
    }
}
