package com.saurabh.springboot;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=8000"})
public class HelloControllerIT extends FluentTest {

    @Value("${local.server.port}")
    private int serverPort;

    private WebDriver driver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return driver;
    }

    private String getUrl() {
        return "http://localhost:" + serverPort;
    }

    @Test
    public void helloWorld() {
        goTo(getUrl());
        assertThat(find("#hellomsg").getText()).isEqualTo("Hello World!");
    }

}