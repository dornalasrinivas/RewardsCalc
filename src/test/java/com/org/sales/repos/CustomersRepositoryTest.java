package com.org.sales.repos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.org.sales.data.DataObj;
import com.org.sales.model.Customers;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomersRepositoryTest {

    @Autowired
    private CustomersRepository customersRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private EntityManager entityManager;

    @Test
    public void injectedComponentsAreNotNull(){
    	assertThat(jdbcTemplate).isNotNull();
    	assertThat(entityManager).isNotNull();
    	assertThat(customersRepository).isNotNull();
    }
    


}
