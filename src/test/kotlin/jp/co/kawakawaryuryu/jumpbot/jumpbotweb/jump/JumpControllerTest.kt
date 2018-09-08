package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.sql.Date

class JumpControllerTest {

    @InjectMocks
    private lateinit var jumpController: JumpController

    @Mock
    private lateinit var jumpService: JumpService;

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetJump() {
        `when`(jumpService.getNextJump()).thenReturn(Jump(1, Date.valueOf("2018-07-24"), 100, false))
        val resource = jumpController.getNextJump()
        assertThat(resource.releaseDay, `is`("2018-07-24"))
        assertThat(resource.price, `is`(100))
        assertThat(resource.combinedIssue, `is`(false))
    }
}