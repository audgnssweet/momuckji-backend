package momuckji.com.backend.domain.service

import momuckji.com.backend.domain.dto.NaverRestaurantsRes
import momuckji.com.backend.infra.naver.NaverClient
import momuckji.com.backend.infra.naver.dto.NaverSearchReq
import org.springframework.stereotype.Service

@Service
class NaverRestaurantSearcher(
    private val naverClient: NaverClient,
) : RestaurantSearcher<NaverSearchReq, NaverRestaurantsRes> {

    override fun search(req: NaverSearchReq): NaverRestaurantsRes {
        return NaverRestaurantsRes(naverClient.search(req))
    }
}
