package org.dvdprofilermvc;

import javax.servlet.MultipartConfigElement;

import org.dvdprofilermvc.io.IO;
import org.dvdprofilermvc.repository.api.DvdProfilerRepository;
import org.dvdprofilermvc.repository.impl.inmemory.InMemoryDvdProfilerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import oss.snafu.json.JsonInjectionMitigationHandlerInterceptor;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application extends WebMvcConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class.getName());

	public static void main(String[] args) {
		LOGGER.info("Starting DVDProfilerMVC....");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	MultipartConfigElement multipartConfigElement() {
		final MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("128MB");
		factory.setMaxRequestSize("128MB");
		return factory.createMultipartConfig();
	}

	@Bean
	IO createIO() {
		final IO io = new IO();
		return io;
	}

	@Bean
	DvdProfilerRepository createDvdProfilerRepository() {
		final InMemoryDvdProfilerRepository repo = new InMemoryDvdProfilerRepository();
		return repo;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JsonInjectionMitigationHandlerInterceptor()).addPathPatterns("/dvds", "/nope");
	}
}
