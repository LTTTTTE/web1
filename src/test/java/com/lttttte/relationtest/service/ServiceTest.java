package com.lttttte.relationtest.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class ServiceTest {

    @MockBean
    private CrawlingService crawlingService;

    @Test
    public void crawlingWorks() throws IOException {
        crawlingService.getHtmlSourceCode("https://www.naver.com");
    }
}
