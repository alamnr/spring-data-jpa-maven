package com.spring.data.jpa.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.spring.data.jpa.repository.custom.CustomRepository;
import com.spring.data.jpa.util.BookUtil;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:PersistenceContext.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class/*,
    DbUnitTestExecutionListener.class*/ })
public class CustomRepositoryTest {

	@Autowired
	private CustomRepository customRepository;
	
	@Before
	public void setUp() {
		customRepository.saveAll(BookUtil.create(7));
	}
	
	@Test
	public void test_CustomRepository_save_and_log_book()
	{
		customRepository.saveAndLog(BookUtil.create());
		
		assertEquals(8, customRepository.findAll().size());
	}
}
