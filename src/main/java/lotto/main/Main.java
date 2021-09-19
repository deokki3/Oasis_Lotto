package lotto.main;

import lotto.domain.LottoTicketMaker;
import lotto.domain.PrizeCalculator;
import lotto.domain.WinningTicketor;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
	public static void main(String[] args) {
		LottoTicketMaker LottoTicketMaker = new LottoTicketMaker();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askAmount();
        LottoTicketMaker.buyAvailableLottoTickets(LottoTicketMaker.calculateAvailableCount(inputView.getAmount()));
        resultView.showLottoTickets(LottoTicketMaker.getLottoTickets());

        inputView.askWinningNumbers();

        WinningTicketor winningTicketSelector = new WinningTicketor(inputView.getWinningNumbers());
        winningTicketSelector.findWinningTicket(LottoTicketMaker.getLottoTickets());
        resultView.startStatistics();
        resultView.showStatistics(winningTicketSelector.getWinningTicketCategoriesByPrize());
        resultView.showProfit(prizeCalculator.calculateProfitRatio(winningTicketSelector.getWinningTicketCategoriesByPrize(), inputView.getAmount()));

    }
}
