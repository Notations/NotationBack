package com.notation.back.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebApiConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		final ByteArrayHttpMessageConverter byteArrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
		final List<MediaType> supportedApplicationTypes = new ArrayList<>();
		final MediaType pdfApplication = new MediaType("application", "pdf");
		final MediaType octetstreamApplication = new MediaType("application", "octet-stream");
		supportedApplicationTypes.add(pdfApplication);
		supportedApplicationTypes.add(octetstreamApplication);
		final List<HttpMessageConverter<?>> converters = new ArrayList<>();
		final MappingJackson2HttpMessageConverter jacksonHttpMessage = new MappingJackson2HttpMessageConverter();
		converters.add(byteArrayHttpMessageConverter);
		converters.add(jacksonHttpMessage);
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}

	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}

}
