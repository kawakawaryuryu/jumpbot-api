package jp.co.kawakawaryuryu.jumpbot.jumpbotweb.jump

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class JumpControllerTest {

    @InjectMocks
    private lateinit var jumpController: JumpController

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testGetJump() {
        val resource = jumpController.getJump("20180724")
        assertThat(resource.releaseDay, `is`("20180724"))
        assertThat(resource.price, `is`(100))
        assertThat(resource.combinedIssue, `is`(false))
    }
}