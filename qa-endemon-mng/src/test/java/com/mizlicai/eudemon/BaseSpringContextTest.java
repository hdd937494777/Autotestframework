package com.mizlicai.eudemon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/config.xml" })
@ActiveProfiles("development")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class BaseSpringContextTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Before
	public void setUp() throws Exception {
		System.out.println("测试开始");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("测试结束");
	}

	@Test
	public void empty() {

	}

	@BeforeTransaction
	public void beforeTransaction() {
		System.out.println("事务开始");
	}

	@AfterTransaction
	public void afterTransaction() {
		System.out.println("事务结束");
	}
}
