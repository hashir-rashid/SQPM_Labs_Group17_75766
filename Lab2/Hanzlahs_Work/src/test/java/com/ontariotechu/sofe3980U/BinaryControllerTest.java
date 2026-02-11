package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addWeb() throws Exception {
        mvc.perform(post("/")
                        .param("operand1","101")
                        .param("operator","+")
                        .param("operand2","10"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result","111"));
    }

    @Test
    public void multiplyWeb() throws Exception {
        mvc.perform(post("/")
                        .param("operand1","10")
                        .param("operator","*")
                        .param("operand2","11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result","110"));
    }

    @Test
    public void andWeb() throws Exception {
        mvc.perform(post("/")
                        .param("operand1","1010")
                        .param("operator","&")
                        .param("operand2","1100"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result","1000"));
    }

    @Test
    public void orWeb() throws Exception {
        mvc.perform(post("/")
                        .param("operand1","1010")
                        .param("operator","|")
                        .param("operand2","0101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result","1111"));
    }
}
