package com.stockmanager.userstockservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.stockmanager.userstockservice.model.Stock;
import com.stockmanager.userstockservice.model.UserStock;
import com.stockmanager.userstockservice.model.UserStockDetail;
import com.stockmanager.userstockservice.repo.StockDetailRepository;

import rx.Observable;
import rx.schedulers.Schedulers;

@Service
@SuppressWarnings("deprecation")
public class StockDetailService {

	@Autowired
	StockDetailRepository stockRepo;

	@Autowired
	StockPriceService stockPriceService;

	public Observable<Stock> getStockPrice(String stock) {
		return stockPriceService.getStockPrice(stock);
	}

	public UserStock save(UserStock sd) {
		return stockRepo.save(sd);
	}

	public UserStock findByUserNameAndStockName(String user, String stock) {
		return stockRepo.findByUserNameAndStockName(user,stock);
	}

	public Observable<UserStockDetail> getUserStockDetail(String userName) {
		return Observable.<UserStockDetail>create(s->{
			UserStockDetail usd = new UserStockDetail();
			usd.setUser(userName);
			List<UserStock> list = stockRepo.findByUserName(userName);
			list.stream().map(stock ->{ 

				Stock temp = stockPriceService.getStockPrice(stock.getStockName()).toBlocking().first();
				if(temp!=null)
					usd.getStock().add(new UserStockDetail.StockDetail(stock.getStockName(),stock.getStockPrice(),
							temp.getPrice()));

				return usd;
			}).collect(Collectors.toList());
			s.onNext(usd);
			s.onCompleted();
		}).subscribeOn(Schedulers.newThread());
	}

}

