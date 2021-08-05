package momuckji.com.backend.domain.service

import momuckji.com.backend.domain.dto.KakaoRestaurantRes
import momuckji.com.backend.infra.kakao.KakaoClient
import momuckji.com.backend.infra.kakao.dto.KakaoSearchReq
import org.springframework.stereotype.Service

@Service
class KakaoRestaurantSearcher(
    private val kakaoClient: KakaoClient,
) : RestaurantSearcher<KakaoSearchReq, KakaoRestaurantRes> {

    override fun search(req: KakaoSearchReq): KakaoRestaurantRes {
        return KakaoRestaurantRes(kakaoClient.search(req))
    }
}
