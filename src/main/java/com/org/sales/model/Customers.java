package com.org.sales.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customers")
public class Customers{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String firstName;
	private String lastName;
	
    @OneToMany(targetEntity = SalesTransactions.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerid_fk", referencedColumnName = "customerId")
    private List<SalesTransactions> salesTransactions;
    
    
}
