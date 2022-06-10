package com.example.demo

import com.netflix.graphql.dgs.DgsQueryExecutor
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders

// @SpringBootTest(classes = [DgsAutoConfiguration::class])
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    lateinit var dgsQueryExecutor: DgsQueryExecutor

    @Test
    fun doMath() {
        val headers = HttpHeaders()
        headers.set("customHeader", "12345")
        val query = "query DoSomeMath { math(numbers: [1,2,3,4,5]) { number doubled halved incremented decremented} }"
        dgsQueryExecutor.executeAndGetDocumentContext(query, mapOf(), headers)
    }

}
