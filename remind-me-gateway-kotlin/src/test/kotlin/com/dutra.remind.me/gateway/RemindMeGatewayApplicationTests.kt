package com.example.demo

import com.dutra.remind.me.gateway.RemindMeGatewayApplication
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(RemindMeGatewayApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RemindMeGatewayApplicationTests {

    @Test
    fun contextLoads() {
    }

}
