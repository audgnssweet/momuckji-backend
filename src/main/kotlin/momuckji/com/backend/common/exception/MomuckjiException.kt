package momuckji.com.backend.common.exception

import org.springframework.http.HttpStatus

abstract class MomuckjiException(
    message: String?,
    val status: HttpStatus,
    val errorCode: ErrorCode,
) : RuntimeException(message)