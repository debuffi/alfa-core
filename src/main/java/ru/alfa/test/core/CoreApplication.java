package ru.alfa.test.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.xml.bind.JAXBException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ru.alfa.test.core.service.AppStartProcessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class CoreApplication implements CommandLineRunner {

    private final AppStartProcessor appStartProcessor;

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(CoreApplication.class, args);
        log.info("Toggle logger DEBUG mode to inspect Spring Boot beans list");

        final String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (final String beanName : beanNames) {
            log.debug("BeanName {}", beanName);
        }

        log.info("**********************************");
        log.info("*    CoreApplication started     *");
        log.info("**********************************");
    }

    @Override
    public void run(String... args) throws IOException, URISyntaxException, JAXBException {
        appStartProcessor.process();
    }
}
