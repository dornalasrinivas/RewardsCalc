package com.org.sales.utils;

public class RewardsCalculator {
	
    public Integer calculateRewards(Double amount){
    	
    	int value = amount.intValue();

        int reward1 = 1;
        int reward2 = 2;
        
        int rewards = 0;
        
        if(value > 50 && value <= 100) {
        	rewards = (value-50)*reward1;
        }else if(value > 100) {
        	rewards = 50 + ((value-100)*reward2);
        }else {
        	rewards = 0;
        }
        
        return rewards;
    }

}
