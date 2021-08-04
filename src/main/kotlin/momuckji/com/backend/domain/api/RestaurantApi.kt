package momuckji.com.backend.domain.api

import momuckji.com.backend.domain.dto.NaverRestaurantsRes
import momuckji.com.backend.domain.service.NaverRestaurantSearcher
import momuckji.com.backend.infra.naver.dto.NaverSearchReq
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/data/restaurants")
class RestaurantApi(
    private val naverRestaurantSearcher: NaverRestaurantSearcher,
) {

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun getRestaurants(req: NaverSearchReq): NaverRestaurantsRes {
        return naverRestaurantSearcher.search(req)
    }
}