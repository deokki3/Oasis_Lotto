package lotto.domain;

import java.util.Map;

public class PrizeCalculator {
	
	//¼öÀÍ·ü °è»ê
    public double calculateProfitRatio(Map<Integer, Integer> winningTicketCategories, int amount){
    	
        double totalPrize = 0;
        for(Map.Entry<Integer, Integer> entry : winningTicketCategories.entrySet()){
            totalPrize = sumPrize(totalPrize, entry);
        }
       
        return amount == 0 ? 0 : totalPrize/amount;
    }
    //´çÃ·°³¼ö¸¸Å­ +µÈ ÃÑ ´çÃ·±Ý
    public double sumPrize(double totalPrize, Map.Entry<Integer, Integer> entry){
    	
        totalPrize = totalPrize + entry.getKey() * entry.getValue();
        
        return totalPrize;
    }

}
