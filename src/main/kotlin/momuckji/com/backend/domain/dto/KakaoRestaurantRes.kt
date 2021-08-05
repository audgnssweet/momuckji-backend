package momuckji.com.backend.domain.dto

import momuckji.com.backend.infra.kakao.dto.KakaoSearchRes

data class KakaoRestaurantRes(
    val keyword: String,
    val totalCount: Int,
    val isEnd: Boolean,
    val restaurants: List<KakaoRestaurant>
) {
    constructor(res: KakaoSearchRes) : this(
        keyword = res.meta.sameName.keyword,
        totalCount = res.meta.totalCount,
        isEnd = res.meta.isEnd,
        restaurants = res.documents.map { KakaoRestaurant(it) }
    )

    data class KakaoRestaurant(
        val name: String,
        val url: String,
        val roadAddressName: String,
        val phone: String,
        val x: String,
        val y: String,
    ) {
        constructor(res: KakaoSearchRes.Document) : this(
            name = res.placeName,
            url = res.placeUrl,
            roadAddressName = res.roadAddressName,
            phone = res.phone,
            x = res.x,
            y = res.y,
        )
    }
}
