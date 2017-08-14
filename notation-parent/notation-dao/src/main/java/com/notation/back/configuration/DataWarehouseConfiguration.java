package com.notation.back.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * The Class DataWarehouseConfiguration.
 */
@Configuration
@EnableJpaRepositories(basePackages="com.notation.back.repository.datawarehouse", entityManagerFactoryRef = "dataWarehouseEntityManagerFactory", transactionManagerRef = "dwTransactionManager")
public class DataWarehouseConfiguration {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(DataWarehouseConfiguration.class);


	/** The datawarehouse driver. */
	@Value("${datawarehouse.driver}")
	private String datawarehouseDriver;

	/** The datawarehouse url. */
	@Value("${datawarehouse.url}")
	private String datawarehouseUrl;

	/** The datawarehouse username. */
	@Value("${datawarehouse.username}")
	private String datawarehouseUsername;

	/** The datawarehouse password. */
	@Value("${datawarehouse.password}")
	private String datawarehousePassword;

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
	@Value("${datawarehouse.hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	/** The entitymanager packages scan. */
	@Value("${datawarehouse.entitymanager.packages.to.scan}")
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
	@Primary
	public DataSource dataWarehouseDataSource() {
		DataWarehouseConfiguration.LOGGER.info("Setting datawarehouse connexion properties");
		final BoneCPDataSource dataWarehouseDataSource = new BoneCPDataSource();
		dataWarehouseDataSource.setDriverClass(this.datawarehouseDriver);
		dataWarehouseDataSource.setJdbcUrl(this.datawarehouseUrl);
		dataWarehouseDataSource.setUsername(this.datawarehouseUsername);
		dataWarehouseDataSource.setPassword(this.datawarehousePassword);
		return dataWarehouseDataSource;
	}

	/**
	 * Configure transaction manager.
	 *
	 * @param entityManagerFactory EntityManagerFactory
	 * @return JpaTransactionManager
	 */
	@Bean
	@Primary
	public JpaTransactionManager dwTransactionManager(final EntityManagerFactory dataWarehouseEntityManagerFactory) {
		return new JpaTransactionManager(dataWarehouseEntityManagerFactory);
	}

	/**
	 * Configure the JPA entity manager.
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean dataWarehouseEntityManagerFactory() {
		DataWarehouseConfiguration.LOGGER.info("Setting hibernate connexion properties for datawarehouse");
		final Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", this.hibernateDialect);
		jpaProperties.put("hibernate.show_sql", this.hibernateShowSql);
		jpaProperties.put("hibernate.format_sql", this.hibernateFormatSql);
		jpaProperties.put("hibernate.hbm2ddl.auto", this.hibernateHbm2ddlAuto);
		jpaProperties.put("hibernate.generate_statistics", this.hibernateGenerateStatistics);

		// Create entity manager
		final LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(this.dataWarehouseDataSource());
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		localContainerEntityManagerFactoryBean.setPackagesToScan(this.entitymanagerPackagesScan);
		localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return localContainerEntityManagerFactoryBean;
	}
}
