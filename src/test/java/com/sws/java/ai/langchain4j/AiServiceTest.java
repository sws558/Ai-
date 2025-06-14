package com.sws.java.ai.langchain4j;
import com.sws.java.ai.langchain4j.assistant.Assistant;
import com.sws.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.sws.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AiServiceTest {
    @Autowired
    private QwenChatModel   qwenChatModel;
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, openAiChatModel);
        String answer = assistant.chat("Hello");
        System.out.println(answer);
    }
    @Autowired
    private Assistant assistant;
    @Test
    public void testChat2() {
        String answer = assistant.chat("介绍你自己");
        System.out.println(answer);
    }
    @Autowired
    private MemoryChatAssistant memoryChatAssistant;
    @Test
    public void testChatMemory4() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁");
        System.out.println(answer2);
    }
    @Autowired
    private SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory5() {
        String answer1 = separateChatAssistant.chat(1,"我是环环");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁");

        System.out.println(answer2);
        String answer4 = separateChatAssistant.chat(1,"说出我的名字");
        System.out.println(answer4);
        String answer3 = separateChatAssistant.chat(2,"我是谁");
        System.out.println(answer3);
    }
}