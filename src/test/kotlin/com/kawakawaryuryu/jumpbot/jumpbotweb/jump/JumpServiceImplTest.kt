package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import com.kawakawaryuryu.jumpbot.jumpbotweb.exception.SystemException
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.sql.Date

class JumpServiceImplTest {

    @InjectMockKs
    private lateinit var jumpService: JumpServiceImpl

    @MockK
    private lateinit var jumpRepository: JumpRepository

    @Rule
    @JvmField
    val thrown: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testGetNextJump_normal() {
        val jumps = listOf(
                Jump(1, Date.valueOf("2018-12-20"), 250, true),
                Jump(2, Date.valueOf("2018-12-13"), 260, false)
        )
        every { jumpRepository.findByReleaseDayGreaterThanEqual(any()) } returns jumps

        val jump = jumpService.getNextJump()

        assertThat(jump.id).isEqualTo(2)
        assertThat(jump.releaseDay).isEqualTo(Date.valueOf("2018-12-13"))
        assertThat(jump.price).isEqualTo(260)
        assertThat(jump.combinedIssue).isEqualTo(false)
    }

    @Test
    fun testGetNextJump_emptyJumps() {
        every { jumpRepository.findByReleaseDayGreaterThanEqual(any()) } returns emptyList()

        thrown.expect(SystemException::class.java)
        thrown.expectMessage("not register next jump information")

        jumpService.getNextJump()
    }
}