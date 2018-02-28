package com.stockmanager.userstockservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.stockmanager.userstockservice.controller.StockDetailController;
import com.stockmanager.userstockservice.model.Stock;
import com.stockmanager.userstockservice.service.StockDetailService;

import rx.Observable;
import rx.observers.TestSubscriber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStockServiceApplicationTests {

	@MockBean
	StockDetailService sds;
	
	@Autowired
	StockDetailController sdc;
	
	
	@Test
	public void contextLoads() {
		Mockito.when(sds.getStockPrice("AAA")).thenReturn(Observable.just(new Stock(111,"AAA",222)));
		
		TestSubscriber<Stock> testSubscriber = new TestSubscriber<>();
		   sds.getStockPrice("AAA").subscribe(testSubscriber);
		   testSubscriber.assertNoErrors();
		   testSubscriber.assertValue(new Stock(111,"AAA",222));
	}

}
