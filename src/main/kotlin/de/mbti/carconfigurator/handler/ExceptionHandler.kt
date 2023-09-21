package de.mbti.carconfigurator.handler

import de.mbti.carconfigurator.api.model.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    companion object {
        private val log = LoggerFactory.getLogger(de.mbti.carconfigurator.handler.ExceptionHandler::class.java)
    }

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(throwable: Throwable): ResponseEntity<ErrorResponse> {
        log.error("An error occurred:", throwable)
        return ResponseEntity(
            ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), throwable.message ?: "error"),
            HttpStatus.INTERNAL_SERVER_ERROR,
        )
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleConstraintViolationException(exception: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        log.warn("Constraint has been violated", exception)
        return ResponseEntity<ErrorResponse>(
            ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.message ?: "error"),
            HttpStatus.BAD_REQUEST,
        )
    }


}