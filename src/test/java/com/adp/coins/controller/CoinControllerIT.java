package com.adp.coins.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CoinControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testController() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/coin/change?amount=11"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(responseJson));
    }
    private static final String responseJson = "[\n" +
                                                "  {\n" +
                                                "    \"coin\": 25,\n" +
                                                "    \"number\": 4\n" +
                                                "  }\n" +
                                                "]";

}
