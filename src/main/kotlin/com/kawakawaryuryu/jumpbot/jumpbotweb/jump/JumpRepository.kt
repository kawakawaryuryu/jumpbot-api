package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface JumpRepository : JpaRepository<Jump, Int> {
    fun findByReleaseDayGreaterThanEqual(date: Date): List<Jump>
}