package momuckji.com.backend.infra.naver

import momuckji.com.backend.infra.naver.dto.NaverSearchReq
import momuckji.com.backend.infra.naver.dto.NaverSearchRes
import momuckji.com.backend.infra.naver.exception.NaverApiException
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class NaverClient(
    @Value("\${naver.api.baseurl}") private val naverSearchUrl: String,
    @Value("\${naver.client.id}") private val naverClientId: String,
    @Value("\${naver.client.key}") private val naverClientKey: String,
) {
    fun search(req: NaverSearchReq): NaverSearchRes {
        return WebClient.create(naverSearchUrl)
            .get()
            .uri { uriBuilder ->
                uriBuilder.queryParams(req.makeQueryParams())
                    .build()
            }
            .accept(MediaType.TEXT_PLAIN)
            .headers {
                it["X-Naver-Client-Id"] = naverClientId
                it["X-Naver-Client-Secret"] = naverClientKey
            }
            .retrieve()
            .bodyToMono(NaverSearchRes::class.java)
            .block() ?: throw NaverApiException()
    }
}