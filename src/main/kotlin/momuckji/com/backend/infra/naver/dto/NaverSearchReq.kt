package momuckji.com.backend.infra.naver.dto

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class NaverSearchReq(
    val query: String,
    val display: Int = 5,
    val start: Int = 1,
    val sort: String = "random"
) {
    fun makeQueryParams(): MultiValueMap<String, String> {
        return LinkedMultiValueMap<String, String>().apply {
            add("query", query)
            add("display", display.toString())
            add("start", start.toString())
            add("sort", sort)
        }
    }
}