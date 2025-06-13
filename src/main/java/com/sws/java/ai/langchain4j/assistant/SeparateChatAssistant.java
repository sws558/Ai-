package com.sws.java.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider",
        chatModel = "openAiChatModel",
        tools="calculatorTools"
)
public interface SeparateChatAssistant {
    /**
     * 分离聊天记录
     * @param memoryId 聊天id
     * @param userMessage 用户消息
     * @return
     */
    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

}
