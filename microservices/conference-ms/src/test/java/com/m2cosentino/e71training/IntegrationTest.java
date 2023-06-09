package com.m2cosentino.e71training;

import com.m2cosentino.e71training.JhipsterApp;
import com.m2cosentino.e71training.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { JhipsterApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
