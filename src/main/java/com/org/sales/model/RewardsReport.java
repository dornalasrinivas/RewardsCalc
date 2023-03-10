package com.org.sales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RewardsReport {

	@Id
	private Long customerid;
	private String fname;
	private Long totaltransactions;
	private Long totalamount;
	private Long totalrewards ;
	
}
