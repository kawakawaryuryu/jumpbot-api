package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.springframework.stereotype.Service
import java.sql.Date
import java.time.LocalDate

@Service
class JumpServiceImpl(
        val jumpRepository: JumpRepository
) : JumpService {

    override fun getNextJump(): Jump {
        val jump = jumpRepository.findByReleaseDayGreaterThanEqual(Date.valueOf(LocalDate.now()))
        return jump.sortedBy { it.releaseDay }.first()
    }
}