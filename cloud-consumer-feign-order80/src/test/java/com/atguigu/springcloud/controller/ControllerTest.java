package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.OrderFeignApplication80;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static cn.hutool.http.ContentType.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderFeignApplication80.class)
@WebAppConfiguration
@ContextConfiguration
public class ControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void aha() throws Exception {
        System.out.println("===============================================");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/consumer/payment/get/1")).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String content = response.getContentAsString();
        System.out.println(content);
        Assert.hasText(content, "443");
        System.out.println("============================ exit.............");
    }

}
