package momuckji.com.backend.infra.naver.exception

import momuckji.com.backend.common.exception.ErrorCode
import momuckji.com.backend.common.exception.MomuckjiException
import org.springframework.http.HttpStatus

class NaverApiException(
    message: String = "네이버 OPEN API 호출을 실패했습니다."
) : MomuckjiException(
    status = HttpStatus.SERVICE_UNAVAILABLE,
    errorCode = ErrorCode.NAVER,
    message = message
)
