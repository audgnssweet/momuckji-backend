package momuckji.com.backend.common.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(MomuckjiException::class)
    fun handleMomuckjiException(exception: MomuckjiException, request: WebRequest): ResponseEntity<Any> {
        return handleExceptionInternal(exception, null, HttpHeaders(), exception.status, request)
    }

    override fun handleExceptionInternal(
        exception: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest,
    ): ResponseEntity<Any> {
        val errorRes = if (exception is MomuckjiException) {
            ErrorRes(exception.status, exception.errorCode.name, exception.message!!)
        } else {
            ErrorRes(HttpStatus.INTERNAL_SERVER_ERROR, "UNKNOWN", exception.message!!)
        }
        return ResponseEntity(errorRes, headers, status)
    }
}
