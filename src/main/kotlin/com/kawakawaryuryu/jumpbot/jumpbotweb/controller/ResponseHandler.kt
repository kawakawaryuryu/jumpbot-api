package com.kawakawaryuryu.jumpbot.jumpbotweb.controller

import com.kawakawaryuryu.jumpbot.jumpbotweb.exception.SystemException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ResponseHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleSystemError(e: SystemException): ErrorResponseResource {
        return ErrorResponseResource("500", e.message)
    }
}