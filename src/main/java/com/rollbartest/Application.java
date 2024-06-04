package com.shipwell.rollbartest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import com.rollbar.spring.webmvc.RollbarSpringConfigBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	@ComponentScan("com.rollbar")
	static class RollbarConfig { }

	@Bean
	public Rollbar rollbar(@Value("${rollbar.access-token:not-a-token}") String accessToken) {
		Config config = RollbarSpringConfigBuilder.withAccessToken(accessToken)
				.environment("dev")
				.appPackages(Arrays.asList("com.shipwell"))
				.handleUncaughtErrors(true).build();
		return new Rollbar(config);
	}

}
