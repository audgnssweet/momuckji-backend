package momuckji.com.backend.infra.kakao.exception

import momuckji.com.backend.common.exception.ErrorCode
import momuckji.com.backend.common.exception.MomuckjiException
import org.springframework.http.HttpStatus

class KakaoApiException(
    message: String = "카카오 OPEN API 호출을 실패했습니다."
) : MomuckjiException(
    status = HttpStatus.SERVICE_UNAVAILABLE,
    errorCode = ErrorCode.KAKAO,
    message = message
)
