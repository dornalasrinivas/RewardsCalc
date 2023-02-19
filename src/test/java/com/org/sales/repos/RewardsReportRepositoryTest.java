package com.org.sales.repos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RewardsReportRepositoryTest {

    @Autowired
    private RewardsReportRepository rewardsReportRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private EntityManager entityManager;

    
    @Test
    public void testInjectedComponentsAreNotNull(){

    	assertThat(jdbcTemplate).isNotNull();
    	assertThat(entityManager).isNotNull();
    	assertThat(rewardsReportRepository).isNotNull();

    }

}
