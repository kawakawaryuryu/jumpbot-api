package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jumps")
class JumpController(
        val jumpService: JumpService
) {

    @GetMapping(value = "/next", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun getNextJump(): JumpResource {
        val jump = jumpService.getNextJump()
        return JumpResource(jump.releaseDay.toString(), jump.price, jump.combinedIssue)
    }
}