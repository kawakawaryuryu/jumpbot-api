package com.kawakawaryuryu.jumpbot.jumpbotweb.jump

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kawakawaryuryu.jumpbot.jumpbotweb.controller.ErrorResponseResource
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDate

@SpringBootTest
@RunWith(SpringRunner::class)
class JumpControllerTest {

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    private lateinit var mockMvc: MockMvc

    private val mapper = jacksonObjectMapper()

    @Before
    fun setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()

        mockkStatic(LocalDate::class)
        // mockkでstaticメソッドのモック化がうまくいかずひとまずコメントアウト
        //every { LocalDate.now() } returns LocalDate.of(2017, 10, 29)
    }

    @Test
    @Ignore
    fun testGetJump() {
        val result = mockMvc.perform(get("/jumps/next"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()

        val response = mapper.readValue<JumpResource>(result.response.contentAsString, JumpResource::class.java)

        assertThat(response.releaseDay).isEqualTo("2017-10-30")
        assertThat(response.price).isEqualTo(260)
        assertThat(response.combinedIssue).isEqualTo(false)
    }

    @Test
    fun testGetJump_NotFound() {
        val result = mockMvc.perform(get("/jumps/next"))
                .andExpect(status().isInternalServerError)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()

        val response = mapper.readValue<ErrorResponseResource>(result.response.contentAsString, ErrorResponseResource::class.java)

        assertThat(response.code).isEqualTo("500")
        assertThat(response.message).isEqualTo("not register next jump information")
    }
}