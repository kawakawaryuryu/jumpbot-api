package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RestController
class JumpController(
        val jumpService: JumpService
) {

    @GetMapping(value = "/jump", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun getJump(@RequestParam date: String): JumpResource {
        jumpService.getJump(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE))
        return JumpResource("20180724", 100, false)
    }
}