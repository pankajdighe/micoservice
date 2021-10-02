package com.org.converter.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith( SpringJUnit4ClassRunner.class )
public class ConvertControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void test_query_shouldReturn200Ok() throws Exception {
        this.mockMvc.perform(get("/converter/v1/romannumeral?query=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"input\":\"1\",\"output\":\"I\"}")));
    }

    @Test
    public void test_range_shouldReturn200Ok() throws Exception {
        this.mockMvc.perform(get("/converter/v1/romannumeral?min=1&max=10")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"input\":\"1\",\"output\":\"I\"}")))
                .andExpect(content().string(containsString("{\"input\":\"10\",\"output\":\"X\"}")));
    }

    @Test
    public void test_query_shouldReturn400() throws Exception {
        this.mockMvc.perform(get("/converter/v1/romannumeral?query=4999")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void test_range_shouldReturn400() throws Exception {
        this.mockMvc.perform(get("/converter/v1/romannumeral?min=1&max=5999")).andDo(print()).andExpect(status().isBadRequest());

    }

}
