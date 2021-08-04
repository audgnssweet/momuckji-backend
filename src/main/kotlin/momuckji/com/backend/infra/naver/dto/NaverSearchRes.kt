package momuckji.com.backend.infra.naver.dto

data class NaverSearchRes(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val category: String?,
    val items: List<SearchItem>
) {

    data class SearchItem(
        val title: String,
        val link: String,
        val description: String,
        val telephone: String,
        val address: String,
        val roadAddress: String,
        val mapx: Int,
        val mapy: Int,
    )

}