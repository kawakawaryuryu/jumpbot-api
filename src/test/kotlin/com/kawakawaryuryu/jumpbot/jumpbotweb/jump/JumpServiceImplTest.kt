package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import com.kawakawaryuryu.jumpbot.jumpbotweb.exception.SystemException
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.sql.Date

class JumpServiceImplTest {

    @InjectMocks
    private lateinit var jumpService: JumpServiceImpl

    @Mock
    private lateinit var jumpRepository: JumpRepository

    @Rule
    @JvmField
    val thrown: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetNextJump_normal() {
        val jumps = listOf(
                Jump(1, Date.valueOf("2018-12-20"), 250, true),
                Jump(2, Date.valueOf("2018-12-13"), 260, false)
        )
        `when`(jumpRepository.findByReleaseDayGreaterThanEqual(any())).thenReturn(jumps)

        val jump = jumpService.getNextJump()

        assertThat(jump.id).isEqualTo(2)
        assertThat(jump.releaseDay).isEqualTo(Date.valueOf("2018-12-13"))
        assertThat(jump.price).isEqualTo(260)
        assertThat(jump.combinedIssue).isEqualTo(false)
    }

    @Test
    fun testGetNextJump_emptyJumps() {
        `when`(jumpRepository.findByReleaseDayGreaterThanEqual(any())).thenReturn(emptyList())

        thrown.expect(SystemException::class.java)
        thrown.expectMessage("not register next jump information")

        jumpService.getNextJump()
    }

    /**
     * non-nullなanyを作るためにラップしている
     */
    private fun <T> any(): T {
        return Mockito.any<T>()
    }
}