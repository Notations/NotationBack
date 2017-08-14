package com.notation.back.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.notation.back.repository.raw", entityManagerFactoryRef = "rawdatabaseEntityManagerFactory", transactionManagerRef = "rawTransactionManager")
public class RawDataBaseConfigration {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(RawDataBaseConfigration.class);


	/** The rawdatabase driver. */
	@Value("${rawdatabase.driver}")
	private String rawdatabaseDriver;

	/** The rawdatabase url. */
	@Value("${rawdatabase.url}")
	private String rawdatabaseUrl;

	/** The rawdatabase username. */
	@Value("${rawdatabase.username}")
	private String rawdatabaseUsername;

	/** The rawdatabase password. */
	@Value("${rawdatabase.password}")
	private String rawdatabasePassword;

	/** The hibernate dialect. */
	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	/** The hibernate format sql. */
	@Value("${hibernate.format_sql}")
	private String hibernateFormatSql;

	/** The hibernate show sql. */
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;

	/** The hibernate hbm 2 ddl auto. */
	@Value("${rawdatabase.hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	/** The entitymanager packages scan. */
	@Value("${rawdatabase.entitymanager.packages.to.scan}")
	private String entitymanagerPackagesScan;

	/** The hibernate generate statistics. */
	@Value("${hibernate.generate_statistics}")
	private String hibernateGenerateStatistics;

	/**
	 * Configure data source.
	 *
	 * @return DataSource
	 */
	@Bean
	public DataSource rawdatabaseDataSource() {
		RawDataBaseConfigration.LOGGER.info("Setting rawdatabase connexion properties");
		final BoneCPDataSource rawdatabaseDataSource = new BoneCPDataSource();
		rawdatabaseDataSource.setDriverClass(this.rawdatabaseDriver);
		rawdatabaseDataSource.setJdbcUrl(this.rawdatabaseUrl);
		rawdatabaseDataSource.setUsername(this.rawdatabaseUsername);
		rawdatabaseDataSource.setPassword(this.rawdatabasePassword);
		return rawdatabaseDataSource;
	}

	/**
	 * Configure transaction manager.
	 *
	 * @param entityManagerFactory EntityManagerFactory
	 * @return JpaTransactionManager
	 */
	@Bean
	public JpaTransactionManager rawTransactionManager(final EntityManagerFactory rawdatabaseEntityManagerFactory) {
		return new JpaTransactionManager(rawdatabaseEntityManagerFactory);
	}

	/**
	 * Configure the JPA entity manager.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean rawdatabaseEntityManagerFactory() {
		RawDataBaseConfigration.LOGGER.info("Setting hibernate connexion properties for rawdatabase");
		final Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", this.hibernateDialect);
		jpaProperties.put("hibernate.show_sql", this.hibernateShowSql);
		jpaProperties.put("hibernate.format_sql", this.hibernateFormatSql);
		jpaProperties.put("hibernate.hbm2ddl.auto", this.hibernateHbm2ddlAuto);
		jpaProperties.put("hibernate.generate_statistics", this.hibernateGenerateStatistics);

		// Create entity manager
		final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(this.rawdatabaseDataSource());
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		localContainerEntityManagerFactoryBean.setPackagesToScan(this.entitymanagerPackagesScan);
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return localContainerEntityManagerFactoryBean;
	}

}
