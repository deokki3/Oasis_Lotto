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

    public WinningTicketor(String inputWinningNumbers){
        Arrays.stream(inputWinningNumbers.split(Material.WINNING_NUMBER_SEPERATOR)).forEach(e -> winningNumbers.add(Integer.parseInt(e)));
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FOURTH, Material.ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_THIRD, Material.ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_SECOND, Material.ZERO);
        winningTicketCategoriesByPrize.put(Material.LOTTO_PRIZE_FIRST, Material.ZERO);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Map<Integer, Integer> getWinningTicketCategoriesByPrize() {
        return winningTicketCategoriesByPrize;
    }

    public void findWinningTicket(List<LottoTicket> tickets){

        for(LottoTicket ticket : tickets){
            categorizeWinningTicketByPrize(checkWinningNumberCount(ticket));
        }

    }

    public int checkWinningNumberCount(LottoTicket ticket){
        int count = 0;
        for(int number : ticket.getNumbers()){
            count = checkSameNumber(count, number);
        }
        return count;
    }

    private void categorizeWinningTicketByPrize(int count){
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

    private int checkSameNumber(int count, int number){
        return winningNumbers.contains(number) ? count + Material.COUNT_ONE : count;
    }

}