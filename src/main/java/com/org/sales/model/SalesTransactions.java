package com.org.sales.model;

import java.sql.Date;
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
@Table(name = "SalesTransactions")
public class SalesTransactions{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesId ;
    private Double amount;
    private String productDesc;
    private Long quantity;
    private Date transactionDate;
    
    @OneToMany(targetEntity = SalesRewards.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "salesid_fk", referencedColumnName = "salesId")
    private List<SalesRewards> salesRewards;

}
