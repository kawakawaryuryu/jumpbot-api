package com.kawakawaryuryu.jumpbot.jumpbotweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JumpbotWebApplication

fun main(args: Array<String>) {
    runApplication<JumpbotWebApplication>(*args)
}
