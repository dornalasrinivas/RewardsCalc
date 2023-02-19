package com.org.sales.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.sales.model.Customers;
import com.org.sales.model.RewardsReport;
import com.org.sales.service.SalesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/sales")
@Slf4j
public class SalesRewardsController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private SalesService salesService;
    
    @PostMapping("/addTransactions")
    public Customers loadCustomer(@RequestBody Customers request) {
    	return salesService.addTransactions(request);
    }
    
//    @GetMapping("/getAllSales")
//    public Iterable<Customers> getAllSales(){
//        return salesService.getAllTransactions();
//    }
    
    @GetMapping("/getAllSales")
    public ResponseEntity<List<Customers>> getAllSales(){
    	List<Customers> customers = this.salesService.getAllTransactions();
    	return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
    }
    
    @GetMapping("/getbycustid")
    public ResponseEntity<Customers> getTransactionsbyCustId(@RequestParam Long id ) {
    	Customers customers = salesService.getTransactionById(id);
    	return new ResponseEntity<Customers>(customers, HttpStatus.OK);
    }
    
    @GetMapping("/getAllRewards")
    public List<RewardsReport> getAllRewards() {
    	return salesService.getAllRewards();
    }
    
    @GetMapping("/getAllRewardsInQuarter")
    public List<RewardsReport> getAllRewardsInQuarter() {
    	return salesService.getAllRewardsInQuarter();
    }
    
    @GetMapping("/getRewardsById")
    public List<RewardsReport> getRewardsInQuarterById(@RequestParam Integer cid ) {
    	return salesService.getRewardsInQuarterById(cid);
    }
    
}
