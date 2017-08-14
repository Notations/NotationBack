package com.notation.back.configuration;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import com.notation.back.exceptions.ConfigurationFileNotFoundException;
import com.notation.back.exceptions.ErrorCode;

/**
 * The Class PropertySourcesPlaceholderConfiguration.
 */
@Configuration
@Description(value = "The property placeholder that gets configuration properties from properties files and inject them to the spring context")
public class PropertySourcesPlaceholderConfiguration {

	private static final Logger LOGGER = Logger.getLogger(PropertySourcesPlaceholderConfiguration.class);

	private static final String GLOBAL_CONFIG_FILE_NAME = "global-config.properties";

	private static final String GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME = "NOTATION_HOME";

	private Resource globalConfigResource;

	@Bean
	@Description("Property sources placeholder")
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws ConfigurationFileNotFoundException{

		final PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

		final String globalConfigFileDirectory = System
				.getenv(PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME);

		PropertySourcesPlaceholderConfiguration.LOGGER.debug("globalConfigFileDirectory : " + globalConfigFileDirectory);

		this.globalConfigResource = new ClassPathResource(PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_NAME);

		if (StringUtils.isNotEmpty(globalConfigFileDirectory)) {
			final String globalConfigFileCompletePath = globalConfigFileDirectory + "/" + PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_NAME;
			PropertySourcesPlaceholderConfiguration.LOGGER.debug("globalConfigFileCompletePath : " + globalConfigFileCompletePath);

			this.globalConfigResource = new PathResource(globalConfigFileCompletePath);
		} else {
			PropertySourcesPlaceholderConfiguration.LOGGER.info("Environment variable '"
					+ PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME + "' not set. Using the file '"
					+ PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_NAME + "' found in the classpath");
		}
		if (!this.globalConfigResource.exists()) {
			PropertySourcesPlaceholderConfiguration.LOGGER.error("Global configuration not found in " + PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME + " environment variable nor in the classpath. Please redeploy the configuration package and the WebApi or set the environment variable. " + PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME);
			throw new ConfigurationFileNotFoundException(ErrorCode.CONFIGURATION_FILE_NOT_FOUND,"Global configuration not found in " + PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME + " environment variable nor in the classpath. Please redeploy the configuration package and the WebApi or set the environment variable. " + PropertySourcesPlaceholderConfiguration.GLOBAL_CONFIG_FILE_DIRECTORY_ENVIRONMENT_VARIABLE_NAME);
		} else {
			PropertySourcesPlaceholderConfiguration.LOGGER.info("Loading global configuration file at the following location : "
					+ this.globalConfigResource);

			final Resource[] resourceLocations = new Resource[] { this.globalConfigResource };

			propertySourcesPlaceholderConfigurer.setLocations(resourceLocations);
		}
		return propertySourcesPlaceholderConfigurer;
	}

	public Resource getGlobalConfigResource() {
		return this.globalConfigResource;
	}

}
