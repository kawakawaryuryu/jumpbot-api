package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import java.time.LocalDate

interface JumpService {
    fun getJump(date: LocalDate)
}