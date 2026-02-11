package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // --- MULTIPLY TESTS ---

    @Test
    public void multiply() throws Exception {
        // Test 10 * 11 = 110 (2 * 3 = 6)
        this.mvc.perform(get("/multiply").param("operand1","10").param("operand2","11"))
                .andExpect(status().isOk())
                .andExpect(content().string("110"));
    }

    @Test
    public void multiplyByZero() throws Exception {
        // Edge case: Multiplying by zero (101 * 0 = 0)
        this.mvc.perform(get("/multiply").param("operand1","101").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    // --- AND TESTS ---

    @Test
    public void andJson() throws Exception {
        // Test 1010 & 1100 = 1000
        this.mvc.perform(get("/and_json").param("operand1","1010").param("operand2","1100"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void andDifferentLengths() throws Exception {
        // Edge case: Different bit lengths (1111 & 1 = 0001)
        this.mvc.perform(get("/and_json").param("operand1","1111").param("operand2","1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1"));
    }

    // --- OR TESTS ---

    @Test
    public void orJson() throws Exception {
        // Test 1010 | 0101 = 1111
        this.mvc.perform(get("/or_json").param("operand1","1010").param("operand2","0101"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1111"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    @Test
    public void orWithZero() throws Exception {
        // Edge case: OR with zero (1010 | 0 = 1010)
        this.mvc.perform(get("/or_json").param("operand1","1010").param("operand2","0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("1010"));
    }
}
