package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class JumpController {

    @GetMapping(value = "/jump", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun getJump(@RequestParam date: String): JumpResource {
        // TODO
        return JumpResource("20180724", 100, false)
    }
}