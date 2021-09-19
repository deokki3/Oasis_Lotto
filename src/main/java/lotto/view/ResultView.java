package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lotto.domain.LottoNumber;
import lotto.util.Material;

public class ResultView {

    public void showLottoTickets(List<LottoNumber> lottoTickets) {
        System.out.println(lottoTickets.size() + Material.BOUGHT_LOTTO_TICKETS);
        lottoTickets.forEach(e -> System.out.println(e.getNumbers()));
        System.out.println("");
    }

    public void startStatistics(){
        System.out.println("");
        System.out.println(Material.WINNING_STATISTICS);
        System.out.println(Material.WINNING_STATISTICS_DIVISION);
    }

    public void showStatistics(Map<Integer, Integer> winningTicketCategories){
        int index = 3;
        for(Map.Entry<Integer, Integer> entry : winningTicketCategories.entrySet()){
            showCountAndPrize(entry, index);
            index++;
        }
    }

    public void showProfit(double profit){
        System.out.print(Material.PROFIT_RATIO + Math.floor(profit*100)/100.0);
        if(profit<1) {
        System.out.println(Material.BLANK + Material.LASTMESSAGE);
        }
    }

    private void showCountAndPrize(Map.Entry<Integer, Integer> entry, int index){
        System.out.print(index + Material.UNIT_COUNT + Material.BLANK + Material.SAME + Material.BLANK + Material.PRIZE_WRAPPER(entry.getKey() + Material.UNIT_PRIZE));
        System.out.println(Material.DASH + Material.BLANK + entry.getValue() + Material.UNIT_COUNT);
    }
}
