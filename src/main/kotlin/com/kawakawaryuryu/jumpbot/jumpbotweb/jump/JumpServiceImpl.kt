package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import com.kawakawaryuryu.jumpbot.jumpbotweb.exception.SystemException
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.LocalDate

@Service
class JumpServiceImpl(
        val jumpRepository: JumpRepository
) : JumpService {

    override fun getNextJump(): Jump {
        val jumps = jumpRepository.findByReleaseDayGreaterThanEqual(Date.valueOf(LocalDate.now()))
        if (jumps.isEmpty()) {
            throw SystemException("not register next jump information")
        }
        return jumps.sortedBy { it.releaseDay }.first()
    }
}