package com.kawakawaryuryu.jumpbot.jumpbotweb.exception

/**
 * Exception when system is not normal
 */
class SystemException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, e: Throwable) : super(message, e)
}