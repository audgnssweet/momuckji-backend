package momuckji.com.backend.domain.dto

import momuckji.com.backend.infra.naver.dto.NaverSearchRes

data class NaverRestaurantsRes(
    val total: Int,
    val restaurants: List<NaverRestaurant>
) {
    constructor(res: NaverSearchRes) : this(
        total = res.total,
        restaurants = res.items.map { NaverRestaurant(it) }
    )

    data class NaverRestaurant(
        val title: String,
        val link: String,
        val description: String,
        val telephone: String,
        val address: String,
        val roadAddress: String,
        val mapx: Int,
        val mapy: Int,
    ) {
        constructor(res: NaverSearchRes.SearchItem) : this(
            title = res.title,
            link = res.link,
            description = res.description,
            telephone = res.telephone,
            address = res.address,
            roadAddress = res.roadAddress,
            mapx = res.mapx,
            mapy = res.mapy,
        )
    }
}
