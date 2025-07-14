package com.example.samplemcp

import com.example.samplemcp.service.SampleMCPService
import org.springframework.ai.tool.ToolCallbackProvider
import org.springframework.ai.tool.method.MethodToolCallbackProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class McpToolConfiguration {

    @Bean
    fun weatherToolCallbackProvider(sampleMCPService: SampleMCPService): ToolCallbackProvider {
        return MethodToolCallbackProvider.builder()
            .toolObjects(sampleMCPService)
            .build()
    }
}