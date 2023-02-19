package com.org.sales.data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;

import com.org.sales.model.Customers;
import com.org.sales.model.RewardsReport;
import com.org.sales.model.SalesRewards;
import com.org.sales.model.SalesTransactions;

@MockBean
public class DataObj {

	public List<Customers> getCustomers() {
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
		st.setTransactionDate(new Date(2023, 01, 21));
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

	public List<RewardsReport> getRewardsReport() {
		List<RewardsReport> rps = new ArrayList<RewardsReport>();
		RewardsReport rp = new RewardsReport();
		rp.setCustomerid(1L);
		rp.setFname("aaaa");
		rp.setTotalamount(250L);
		rp.setTotalrewards(150L);
		rps.add(rp);

		return rps;
	}

}
