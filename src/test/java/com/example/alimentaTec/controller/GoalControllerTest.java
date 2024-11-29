package com.example.alimentaTec.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class GoalControllerTest {
    
     @Autowired
    private MockMvc mvc;

    @Autowired
    private GoalController controller;


    @Test 
    void contextLoads () throws Exception{
        assertThat(controller).isNotNull();
    }

    @Test
    @WithMockUser(username = "maria_garcia", roles = {"PACIENTE"})
    public void getAllPaginatedTest() throws Exception {
        mvc.perform(get("/goals/pagination")
                .param("page", "0")
                .param("size", "10")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(greaterThan(0))));
    }
 
    @Test
    @WithMockUser(username = "maria_garcia", roles = {"PACIENTE"})
    public void getByIdTest() throws Exception {
        mvc.perform(get("/goals/2").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idGoal", is(2)));
    }

    @Test
    @WithMockUser(username = "maria_garcia", roles = {"PACIENTE"})
    public void getByIdNotFoundTest() throws Exception {
        mvc.perform(get("/goals/0").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("The requested item is not registered")));
    }
}
