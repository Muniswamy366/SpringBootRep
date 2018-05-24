package com.techprimers.jpa.springdatajpahibernateexample;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringDataJpaHibernateExampleApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class SpringDataJpaHibernateExampleApplicationITTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {

       mockMvc.perform(
                MockMvcRequestBuilders.get("/getAll/")
                        .accept(MediaType.APPLICATION_JSON)
        //).andReturn();
        ).andExpect(MockMvcResultMatchers.status().isOk())
       .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("muni")))
       .andExpect(MockMvcResultMatchers.jsonPath("$[0].salary", Matchers.is(100)))
       .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));

        //System.out.println(mvcResult.getResponse());

    }

}
