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

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }

	@Test
    public void add_json() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // My tests are below
    // Test the add function with 2 zeros
    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add").param("operand1","0").param("operand2","0"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Test the add function with 2 zeros (JSON)
    @Test
    public void add_json2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","0").param("operand2","0"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    // Test the add function with empty operands
    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1","").param("operand2",""))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    // Test the add function with empty operands (JSON)
    @Test
    public void add_json3() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","").param("operand2",""))//.andDo(print())
            .andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /**
    * Test The or function with two test nums, with the first being shorter
    */
    @Test
    public void or_test() throws Exception {
        this.mvc.perform(get("/or").param("operand1","101110").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1111110"));
    }

    /**
    * Test The or function with two test nums, with the first being shorter (JSON)
    */
    @Test
    public void or_test_json() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","101110").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    /**
    * Test The or function with two test nums, with the second being shorter
    */
    @Test
    public void or_test2() throws Exception {
        this.mvc.perform(get("/or").param("operand1","11001010").param("operand2","101000"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("11101010"));
    }

    /**
    * Test The or function with two test nums, with the second being shorter (JSON)
    */
    @Test
    public void or_test_json2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","11001010").param("operand2","101000"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11001010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(11101010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    /**
    * Test The or function with two test nums, with the first being zero
    */
    @Test
    public void or_test3() throws Exception {
        this.mvc.perform(get("/or").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1010010"));
    }

    /**
    * Test The or function with two test nums, with the first being zero (JSON)
    */
    @Test
    public void or_test_json3() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    /**
    * Test The and function with two test nums, with the first being shorter
    */
    @Test
    public void and_test() throws Exception {
        this.mvc.perform(get("/and").param("operand1","101110").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10"));
    }

    /**
    * Test The and function with two test nums, with the first being shorter (JSON)
    */
    @Test
    public void and_test_json() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","101110").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /**
    * Test The and function with two test nums, with the second being shorter
    */
    @Test
    public void and_test2() throws Exception {
        this.mvc.perform(get("/and").param("operand1","11001010").param("operand2","101000"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1000"));
    }

    /**
    * Test The and function with two test nums, with the second being shorter (JSON)
    */
    @Test
    public void and_test_json2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","11001010").param("operand2","101000"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(11001010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /**
    * Test The and function with two test nums, with the first being zero
    */
    @Test
    public void and_test3() throws Exception {
        this.mvc.perform(get("/and").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    /**
    * Test The and function with two test nums, with the first being zero (JSON)
    */
    @Test
    public void and_test_json3() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /**
    * Test The multiply function with two test nums, with the first being shorter
    */
    @Test
    public void multiply_test() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","101").param("operand2","1011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("110111"));
    }

    /**
    * Test The multiply function with two test nums, with the first being shorter (JSON)
    */
    @Test
    public void multiply_test_json() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","101").param("operand2","1011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1011))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(110111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    /**
    * Test The multiply function with two test nums, with the second being shorter
    */
    @Test
    public void multiply_test2() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","1100").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("111100"));
    }

    /**
    * Test The multiply function with two test nums, with the second being shorter (JSON)
    */
    @Test
    public void multiply_test_json2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","1100").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111100))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    /**
    * Test The multiply function with two test nums, with the first being zero
    */
    @Test
    public void multiply_test3() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    /**
    * Test The multiply function with two test nums, with the first being zero (JSON)
    */
    @Test
    public void multiply_test_json3() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","0").param("operand2","1010010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
}