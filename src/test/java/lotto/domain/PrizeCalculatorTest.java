package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {
	WinningTicketor winningTicketor =new WinningTicketor("1,2,3,4,5,6");
	PrizeCalculator prizeCalculator=new PrizeCalculator();
	private double totalPrize=0;
	
	@DisplayName("��÷��ȣ�� ���� ���ͷ� �׽�Ʈ")
	@Test
	void testCalculateProfitRatio() {
		
		winningTicketor.getWinningTicketCategoriesByPrize().put(5000, 1);
		winningTicketor.getWinningTicketCategoriesByPrize().put(50000, 0);
		winningTicketor.getWinningTicketCategoriesByPrize().put(1500000, 0);
		winningTicketor.getWinningTicketCategoriesByPrize().put(2000000000, 0);
		
		
		assertEquals(0.35, Math.floor(prizeCalculator.calculateProfitRatio(winningTicketor.getWinningTicketCategoriesByPrize(), 14000)*100)/100);
		
	}
	@DisplayName("��÷ Ƽ���� ������ŭ ����� ���� �Ǵ��� �׽�Ʈ")
	@Test
	void testSumPrize() {
		
		winningTicketor.getWinningTicketCategoriesByPrize().put(5000, 2);
		winningTicketor.getWinningTicketCategoriesByPrize().put(50000, 1);
		winningTicketor.getWinningTicketCategoriesByPrize().put(1500000, 0);
		winningTicketor.getWinningTicketCategoriesByPrize().put(2000000000, 0);
		 for(Map.Entry<Integer, Integer> entry : winningTicketor.getWinningTicketCategoriesByPrize().entrySet()){
	            totalPrize = prizeCalculator.sumPrize(totalPrize, entry);
		 }
		assertEquals(60000.0,totalPrize);
		
	}

	
}

