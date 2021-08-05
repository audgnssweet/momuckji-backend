package momuckji.com.backend.infra.kakao.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class KakaoSearchRes(
    val meta: Meta,
    val documents: List<Document>,
) {
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class Meta(
        val sameName: SameName,
        val pageableCount: Int,
        val totalCount: Int,
        val isEnd: Boolean,
    ) {
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
        data class SameName(
            val region: List<String>?,
            val keyword: String,
            val selectedRegion: String,
        )
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
    data class Document(
        val placeName: String,
        val distance: String,
        val placeUrl: String,
        val categoryName: String,
        val addressName: String,
        val roadAddressName: String,
        val id: String,
        val phone: String,
        val categoryGroupCode: String,
        val categoryGroupName: String,
        val x: String,
        val y: String,
    )
}
