package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addAPI() throws Exception {
        mvc.perform(get("/add")
                        .param("operand1","111")
                        .param("operand2","1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void multiplyAPI() throws Exception {
        mvc.perform(get("/multiply")
                        .param("operand1","10")
                        .param("operand2","11"))
                .andExpect(status().isOk())
                .andExpect(content().string("110"));
    }

    @Test
    public void andAPI() throws Exception {
        mvc.perform(get("/and")
                        .param("operand1","1010")
                        .param("operand2","1100"))
                .andExpect(status().isOk())
                .andExpect(content().string("1000"));
    }

    @Test
    public void orAPI() throws Exception {
        mvc.perform(get("/or")
                        .param("operand1","1010")
                        .param("operand2","0101"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
}
