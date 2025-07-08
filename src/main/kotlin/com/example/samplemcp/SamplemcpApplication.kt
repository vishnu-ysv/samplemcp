package com.example.samplemcp

import com.example.samplemcp.service.SampleMCPService
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallback
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SamplemcpApplication

fun main(args: Array<String>) {
	runApplication<SamplemcpApplication>(*args)
}

@Bean
fun sampleMCPService(sampleMCPService: SampleMCPService) : ToolCallbackProvider {
    return MethodToolCallbackProvider.builder().toolObjects(sampleMCPService).build()
}