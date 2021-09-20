package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.util.Material;

public class WinningTicketor {

    private List<Integer> winningNumbers = new ArrayList<>();
    private Map<Integer, Integer> winningTicketCategoriesByPrize = new LinkedHashMap<>();
    //, ���� & �ʱ�ȭ
    public WinningTicketor(String inputWinningNumbers){
        Arrays.stream(inputWinningNumbers.split(Material.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        if(winningNumbers.size() != Material.COUNT_SIX){
            throw new IllegalArgumentException();
        }
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FOURTH, Material.COUNT_ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_THIRD, Material.COUNT_ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_SECOND, Material.COUNT_ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FIRST, Material.COUNT_ZERO);
    }

    public List<Integer> getWinningNumbers() {
    	
        return winningNumbers;
    }

    public Map<Integer, Integer> getWinningTicketCategoriesByPrize() {
    	
        return winningTicketCategoriesByPrize;
    }
    
    public void findWinningTicket(List<LottoNumber> tickets){
    	

        for(LottoNumber ticket : tickets){
            categorizeWinningTicketByPrize(checkWinningNumberCount(ticket));
        }

    }
    //��÷������ŭ ī��Ʈ
    public int checkWinningNumberCount(LottoNumber ticket){
        int count = 0;
        for(int number : ticket.getNumbers()){
            count = checkSameNumber(count, number);
        }
        return count;
    }
    //��÷��� �κ� 
    public void categorizeWinningTicketByPrize(int count){
        if(count == Material.COUNT_THREE){
        	
            winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FOURTH, winningTicketCategoriesByPrize.get(Material.LOTTO_PRIZE_FOURTH) + Material.COUNT_ONE);
        }

        if(count == Material.COUNT_FOUR){
            winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_THIRD, winningTicketCategoriesByPrize.get(Material.LOTTO_PRIZE_THIRD) + Material.COUNT_ONE);
        }

        if(count == Material.COUNT_FIVE){
            winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_SECOND, winningTicketCategoriesByPrize.get(Material.LOTTO_PRIZE_SECOND) + Material.COUNT_ONE);
        }

        if(count == Material.COUNT_SIX){
            winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FIRST, winningTicketCategoriesByPrize.get(Material.LOTTO_PRIZE_FIRST) + Material.COUNT_ONE);
        }
    }
    //���ٸ� + 1
    public int checkSameNumber(int count, int number){
    	
        return winningNumbers.contains(number) ? count + Material.COUNT_ONE : count;
    }

}