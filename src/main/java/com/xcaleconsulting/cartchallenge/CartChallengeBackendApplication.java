package com.xcaleconsulting.cartchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CartChallengeBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(CartChallengeBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		String urlAllow = "https://cart-challenge-frontend.vercel.app/";

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins(urlAllow).allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}


