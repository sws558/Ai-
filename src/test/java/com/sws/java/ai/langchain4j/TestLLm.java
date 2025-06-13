package com.sws.java.ai.langchain4j;

//
//import dev.langchain4j.community.model.dashscope.QwenChatModel;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLLm {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Autowired
    private OllamaChatModel ollamaChatModel;
//    @Autowired
//    private QwenChatModel qwenChatModel;
    @Test
    public void testLLm() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String msg = model.chat("hello");
        System.out.println(msg);
    }

    @Test
    public void testLLm2() {
        String msg = openAiChatModel.chat("介绍你自己");
        System.out.println(msg);

    }
    @Test
    public void testLLm3() {



    }
}
