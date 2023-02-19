package com.org.sales.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.sales.model.RewardsReport;

public interface RewardsReportRepository extends JpaRepository<RewardsReport, Long> {

	@Query(value = "select c.customer_id as customerid, c.first_name as fname, count(st.customerid_fk) AS totaltransactions, sum(st.amount) as totalamount, sum(sr.rewards) as totalrewards from Customers c join SALES_TRANSACTIONS st on c.customer_id=st.customerid_fk join SALES_REWARDS sr on st.sales_id=sr.salesid_fk group by customerid_fk order by customer_id asc", nativeQuery = true)
	public List<RewardsReport> getAllRewards();
	
	@Query(value = "select c.customer_id as customerid, c.first_name as fname, count(st.customerid_fk) AS totaltransactions, sum(st.amount) as totalamount, sum(sr.rewards) as totalrewards from Customers c join SALES_TRANSACTIONS st on c.customer_id=st.customerid_fk join SALES_REWARDS sr on st.sales_id=sr.salesid_fk where st.TRANSACTION_DATE>=:startDate group by customerid_fk order by customer_id asc", nativeQuery = true)
	public List<RewardsReport> getAllRewardsInQuarter(@Param("startDate")LocalDate startDate);
	
	@Query(value = "select c.customer_id as customerid, c.first_name as fname, count(st.customerid_fk) AS totaltransactions, sum(st.amount) as totalamount, sum(sr.rewards) as totalrewards from Customers c join SALES_TRANSACTIONS st on c.customer_id=st.customerid_fk join SALES_REWARDS sr on st.sales_id=sr.salesid_fk where st.TRANSACTION_DATE>=:startDate and c.customer_id=:customerid group by customerid_fk order by customer_id asc", nativeQuery = true)
	public List<RewardsReport> getRewardsInQuarterById(@Param("customerid")Integer customerid,
													@Param("startDate")LocalDate startDate);
}
