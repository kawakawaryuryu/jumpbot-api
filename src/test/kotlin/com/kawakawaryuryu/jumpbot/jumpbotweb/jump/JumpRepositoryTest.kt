package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Date

@RunWith(SpringRunner::class)
@DataJpaTest
class JumpRepositoryTest {

    @Autowired
    private lateinit var jumpRepository: JumpRepository

    @Test
    fun testFindByReleaseDayGreaterThanEqual() {
        val jumps = jumpRepository.findByReleaseDayGreaterThanEqual(Date.valueOf("2017-10-30"))

        assertThat(jumps).hasSize(2)
        assertThat(jumps[0].id).isEqualTo(2)
        assertThat(jumps[0].releaseDay).isEqualTo("2017-10-30")
        assertThat(jumps[0].price).isEqualTo(260)
        assertThat(jumps[0].combinedIssue).isEqualTo(false)
        assertThat(jumps[1].id).isEqualTo(3)
        assertThat(jumps[1].releaseDay).isEqualTo("2017-11-06")
        assertThat(jumps[1].price).isEqualTo(260)
        assertThat(jumps[1].combinedIssue).isEqualTo(false)
    }
}