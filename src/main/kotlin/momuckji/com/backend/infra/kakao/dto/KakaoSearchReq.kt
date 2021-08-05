package momuckji.com.backend.infra.kakao.dto

import momuckji.com.backend.infra.searchCommon.Queryable
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class KakaoSearchReq(
    val query: String,
    val page: Int = 1,
    val count: Int = 15,
    val sort: String = "accuracy",
    val x: String?,
    val y: String?,
    val radius: Int?,
    val rect: String?,
) : Queryable {
    override fun makeQueryParams(): MultiValueMap<String, String> {
        return LinkedMultiValueMap<String, String>().apply {
            add("query", query)
            add("page", page.toString())
            add("size", count.toString())
            add("sort", sort)
            x?.let { add("x", x) }
            x?.let { add("y", y) }
            radius?.let { add("radius", radius.toString()) }
            rect?.let { add("rect", rect) }
        }
    }
}
