package com.example.demo

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

  private val log by logger()

  @Bean
  @ConditionalOnProperty(name = ["dev.overrides.local"], havingValue = "true")
  fun testClassDev(): String {
    log.info("This should not be seen, this means dev overrides local")
    return "dev"
  }

  @Bean
  @ConditionalOnProperty(name = ["dev.overrides.local"], havingValue = "false")
  fun testClassLocal(): String {
    log.info("This should be seen, because the properties in the active profile should override the properties in the included profile")
    return "local"
  }
}
