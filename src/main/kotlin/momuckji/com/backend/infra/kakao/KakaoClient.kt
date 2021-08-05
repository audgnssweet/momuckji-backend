package momuckji.com.backend.infra.kakao

import momuckji.com.backend.infra.kakao.dto.KakaoSearchReq
import momuckji.com.backend.infra.kakao.dto.KakaoSearchRes
import momuckji.com.backend.infra.kakao.exception.KakaoApiException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class KakaoClient(
    @Value("\${kakao.api.key}") val kakaoApiKey: String,
    @Value("\${kakao.api.url}") val kakaoSearchUrl: String,
) {
    fun search(req: KakaoSearchReq): KakaoSearchRes {
        return WebClient.create(kakaoSearchUrl)
            .get()
            .uri { uriBuilder ->
                uriBuilder.queryParams(req.makeQueryParams())
                    .build()
            }
            .headers {
                it["Authorization"] = "KakaoAK $kakaoApiKey"
            }
            .retrieve()
            .bodyToMono(KakaoSearchRes::class.java)
            .block() ?: throw KakaoApiException()
    }
}
