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

    /**
     * @deprecated 카카오 API로 대체되었다. 추후에 Naver API를 사용할 가능성이 있기에 남겨둔다.
     */
    @GetMapping("/naver")
    @ResponseStatus(HttpStatus.OK)
    fun getNaverRestaurants(req: NaverSearchReq): NaverRestaurantsRes {
        return naverRestaurantSearcher.search(req)
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun getKakaoRestaurants() {
        
    }

}
