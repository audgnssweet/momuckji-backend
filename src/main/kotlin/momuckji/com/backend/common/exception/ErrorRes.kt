package momuckji.com.backend.common.exception

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorRes(
    val timestamp: LocalDateTime,
    val status: Int,
    val errorCode: String,
    val message: String
) {
    constructor(httpStatus: HttpStatus, errorCode: String, message: String) : this(
        timestamp = LocalDateTime.now(),
        status = httpStatus.value(),
        errorCode = errorCode,
        message = message,
    )
}
