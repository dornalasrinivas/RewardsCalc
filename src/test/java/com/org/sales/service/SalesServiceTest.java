package com.org.sales.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.org.sales.data.DataObj;
import com.org.sales.model.Customers;
import com.org.sales.model.RewardsReport;
import com.org.sales.repos.CustomersRepository;
import com.org.sales.repos.RewardsReportRepository;

@ExtendWith(MockitoExtension.class)
class SalesServiceTest {

	@InjectMocks
	private SalesService salesService;
	
	@Mock 
	private CustomersRepository customersRepository;
	
	@Mock 
	private RewardsReportRepository rewardsReportRepository;
	
	DataObj dataObj = new DataObj();
	
	@Test
	void testGetAllTransactions() {
		List<Customers> customers = dataObj.getCustomers(); 
		when(customersRepository.findAll()).thenReturn(customers);
		List<Customers> transactions = salesService.getAllTransactions();
		assertEquals(1, transactions.size());
	}

	@Test
	void testGetTransactionById() {
		Optional<Customers> customers = Optional.of(dataObj.getCustomers().get(0));
		when(customersRepository.findById(1L)).thenReturn(customers);
		Customers transactions = salesService.getTransactionById(1L);
		assertEquals("aaaa", transactions.getFirstName());
		assertEquals("aaaa", transactions.getLastName());
	}

	@Test
	void testGetAllRewards() {
		List<RewardsReport> rewards = dataObj.getRewardsReport(); 
		when(rewardsReportRepository.getAllRewards()).thenReturn(rewards);
		List<RewardsReport> rewardsReport = salesService.getAllRewards();
		assertEquals(1, rewardsReport.size());
	}

	@Test
	void testGetAllRewardsInQuarter() {
		LocalDate startDate = LocalDate.now().minusMonths(3);
		List<RewardsReport> rewards = dataObj.getRewardsReport(); 
		when(rewardsReportRepository.getAllRewardsInQuarter(startDate)).thenReturn(rewards);
		List<RewardsReport> rewardsReport = salesService.getAllRewardsInQuarter();
		assertEquals(1, rewardsReport.size());
		
	}

	@Test
	void testGetRewardsInQuarterById() {
		LocalDate startDate = LocalDate.now().minusMonths(3);
		List<RewardsReport> rewards = dataObj.getRewardsReport(); 
		when(rewardsReportRepository.getRewardsInQuarterById(1,startDate)).thenReturn(rewards);
		List<RewardsReport> rewardsReport = salesService.getRewardsInQuarterById(1);
		assertEquals(1, rewardsReport.size());
	}

}
