package com.example.demo

import com.dutra.remind.me.query.RemindMeQueryApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(RemindMeQueryApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RemindMeQueryApplicationTests {

    @Test
    fun contextLoads() {
    }

}
