package com.org.sales.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sales.model.Customers;
import com.org.sales.model.RewardsReport;
import com.org.sales.repos.CustomersRepository;
import com.org.sales.repos.RewardsReportRepository;
import com.org.sales.utils.RewardsCalculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SalesService {
	

	@Autowired
	CustomersRepository customersRepository;
	
	@Autowired
	RewardsReportRepository rewardsReportRepository;
	
	
    public Customers addTransactions(Customers request) {
    	RewardsCalculator rc = new RewardsCalculator();
    	Double amt = request.getSalesTransactions().get(0).getAmount();
    	Long rewards = rc.calculateRewards(amt).longValue();
    	request.getSalesTransactions().get(0).getSalesRewards().get(0).setRewards(rewards);
    	return customersRepository.save(request);
    }
    
    public List<Customers> getAllTransactions(){
    	
    	Iterable<Customers> customers = this.customersRepository.findAll();
    	List<Customers> result = 
  			  StreamSupport.stream(customers.spliterator(), false)
  			    .collect(Collectors.toList());
    	
        return result;
    }
    
    public Customers getTransactionById(Long id) {
    	Optional<Customers> optCustomers = customersRepository.findById(id);
    	Customers customers = optCustomers.get();
    	return customers;
    }
    
    public List<RewardsReport> getAllRewards() {
    	return rewardsReportRepository.getAllRewards();
    }
    
    public List<RewardsReport> getAllRewardsInQuarter() {
    	LocalDate startDate = LocalDate.now().minusMonths(3);
    	return rewardsReportRepository.getAllRewardsInQuarter(startDate);
    }
    
    public List<RewardsReport> getRewardsInQuarterById(Integer customerid) {
    	LocalDate startDate = LocalDate.now().minusMonths(3);
    	return rewardsReportRepository.getRewardsInQuarterById(customerid, startDate);
    }
    


}
