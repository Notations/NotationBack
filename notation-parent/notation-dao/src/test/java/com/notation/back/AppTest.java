package com.notation.back;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.notation.back.configuration.DataWarehouseConfiguration;
import com.notation.back.configuration.PropertySourcesPlaceholderConfiguration;
import com.notation.back.configuration.RawDataBaseConfigration;
import com.notation.back.model.datawarehouse.Indicators;
import com.notation.back.model.raw.Parameters;
import com.notation.back.repository.datawarehouse.IndicatorsRepository;
import com.notation.back.repository.raw.ParametersRepository;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PropertySourcesPlaceholderConfiguration.class, DataWarehouseConfiguration.class, RawDataBaseConfigration.class })
public class AppTest extends TestCase{

	@Autowired
	private IndicatorsRepository indicatorsRepository;

	@Autowired
	private ParametersRepository parametersRepository;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */

	/**
	 * Before test.
	 */
	@Before
	public void beforeTest() {
		System.out.println("init");
	}

	@Test
	public void testAddingNewIndicator(){
		this.indicatorsRepository.save(new Indicators(3));
		Assert.assertTrue(true);
	}

	@Test
	public void testAddingNewParameter(){
		this.parametersRepository.save(new Parameters(1));
		Assert.assertTrue(true);
	}


}
