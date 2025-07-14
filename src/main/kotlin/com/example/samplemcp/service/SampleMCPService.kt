package com.example.samplemcp.service

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.ai.tool.annotation.Tool
import org.springframework.ai.tool.annotation.ToolParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class SampleMCPService {

    @Autowired
    private lateinit var objectMapper: ObjectMapper
    private val weatherHttpClient : RestClient

    init {
        weatherHttpClient = RestClient.builder()
            .baseUrl("https://api.weather.gov")
            .defaultHeader("Accept", "application/geo+json")
            .defaultHeader("User-Agent", "WeatherApiClient/1.0 (your@email.com)")
            .build();
    }


    @Tool(description = "Get weather forecast by location")
    public fun getWeatherForecastByLocation(latitude: Double, longitude: Double): String {
        return objectMapper.writeValueAsString(mapOf("data" to "some weather forecast"))
    }


    @Tool(description = "Get weather forecast by zip code")
    public fun getWeatherForecastByZipCode(@ToolParam(description =  "indian zip code") zipCode: String): String {
        return objectMapper.writeValueAsString(mapOf("data" to "some weather forecast"))
    }

}