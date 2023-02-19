package com.org.sales.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.sales.data.DataObj;
import com.org.sales.model.Customers;
import com.org.sales.model.RewardsReport;
import com.org.sales.service.SalesService;

@WebMvcTest
class SalesRewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private SalesService salesService;
    
    private static ObjectMapper mapper = new ObjectMapper();
    
    DataObj dataObj = new DataObj();
    
/*    @Test
    public void loadCustomer() throws Exception {
    	
    	Customers customers = dataObj.getCustomers().get(0);     
        
        Mockito.when(salesService.addTransactions(customers)).thenReturn(customers);
        String json = mapper.writeValueAsString(customers);
        mockMvc
        .perform(post("/addTransactions")
		.contentType(MediaType.APPLICATION_JSON)
        .content(json)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    } */
    
	@Test
	void testGetAllSales() throws Exception {
		List<Customers> customers = dataObj.getCustomers();
		Mockito.when(salesService.getAllTransactions()).thenReturn(customers);
        mockMvc
        .perform(get("/sales/getAllSales"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].firstName", Matchers.equalTo("aaaa")));
	}

	@Test
	void testGetTransactionsbyCustId() throws Exception {
		Customers customers = dataObj.getCustomers().get(0);
		long id = 1L;
		Mockito.when(salesService.getTransactionById(id)).thenReturn(customers);
        mockMvc
        .perform(get("/sales/getbycustid?id=1"))
        .andExpect(status().isOk());
	} 

	@Test
	void testGetAllRewards() throws Exception {
		List<RewardsReport> rps = dataObj.getRewardsReport();
		Mockito.when(salesService.getAllRewards()).thenReturn(rps);
        mockMvc
        .perform(get("/sales/getAllRewards"))
        .andExpect(status().isOk());
	}

	@Test
	void testGetAllRewardsInQuarter() throws Exception {
		List<RewardsReport> rps = dataObj.getRewardsReport();
		Mockito.when(salesService.getAllRewards()).thenReturn(rps);
        mockMvc
        .perform(get("/sales/getAllRewardsInQuarter"))
        .andExpect(status().isOk());
	}

	@Test
	void testGetRewardsInQuarterById() throws Exception {
		List<RewardsReport> rp = dataObj.getRewardsReport();
		int cid = 1;
		Mockito.when(salesService.getRewardsInQuarterById(cid)).thenReturn(rp);
        mockMvc
        .perform(get("/sales/getRewardsById?cid=1"))
        .andExpect(status().isOk());
	}

/*	private static List<Customers> getCustomers() {
		
		List<Customers> customers = new ArrayList<Customers>();
		List<SalesTransactions> sts = new ArrayList<SalesTransactions>();
		List<SalesRewards> srs = new ArrayList<SalesRewards>();
		SalesRewards sr = new SalesRewards();
		sr.setRewardsId(1L);
		sr.setRewards(150L);
		srs.add(sr);
		SalesTransactions st = new SalesTransactions();
		st.setSalesId(1L);
		st.setAmount(300.00);
		st.setProductDesc("prodct1");
		st.setQuantity(1L);
		st.setTransactionDate(new Date(2023,01,21));
		st.setSalesRewards(srs);
		sts.add(st);
		Customers customer = new Customers();
		customer.setCustomerId(1L);
		customer.setFirstName("aaaa");
		customer.setLastName("aaaa");
		customer.setSalesTransactions(sts);
		customers.add(customer);
		
		return customers;
	}
	
	private List<RewardsReport> getRewardsReport() {
		List<RewardsReport> rps = new ArrayList<RewardsReport>();
		RewardsReport rp = new RewardsReport();
		rp.setCustomerid(1L);
		rp.setFname("aaaa");
		rp.setTotalamount(250L);
		rp.setTotalrewards(150L);
		rps.add(rp);
		
		return rps;
	} */
	
}
