package com.example.demo

import com.example.demo.types.MathResponse
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import org.springframework.web.bind.annotation.RequestHeader

@DgsComponent
class GraphQLServer {
    @DgsQuery
    fun math(
        @InputArgument(name = "numbers") numbers: List<Int>,
        @RequestHeader(value = "customHeader", required = false) customHeader: String,
        dfe: DgsDataFetchingEnvironment
    ): List<MathResponse> {
        println("Custom header made it! $customHeader")
        return numbers.map {
            MathResponse(
                number = it,
                doubled = it * 2,
                halved = it / 2,
                incremented = it + 1,
                decremented = it - 1
            )
        }
    }
}
