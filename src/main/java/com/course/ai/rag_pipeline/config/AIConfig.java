package com.course.ai.rag_pipeline.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AIConfig {

    @Bean("defaultRestClientBuilder")
    RestClient.Builder restClient(){
        return RestClient.builder();
    }

    @Bean("GeminiChatClient")
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
