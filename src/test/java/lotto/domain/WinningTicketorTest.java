package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTicketorTest {
	private WinningTicketor winningTicketor=new WinningTicketor("1,2,3,4,5,6");

	
	@DisplayName("6�� �ƴ� ���� �Է½� ���� �׽�Ʈ")
	@Test
	void testWinningTicketor() {
		  assertThatIllegalArgumentException().isThrownBy(()->{
	            WinningTicketor winningTicketor1 = new WinningTicketor("1,2,3,4,5,6,7");
	        });
	    }
	@DisplayName("��÷ ��ȣ�� ���� �Ǵ� �� �׽�Ʈ")
	@Test
	void testGetWinningNumbers() {
		 assertThat(winningTicketor.getWinningNumbers().size()).isEqualTo(6);
	}
	
	 @DisplayName("ī��Ʈ�� ���� ������ ��� ã���� �׽�Ʈ")
	    @Test
	    
	    void categorizeWinningTicketByPrizeTest() {
		 winningTicketor.categorizeWinningTicketByPrize(3);
		 assertThat(winningTicketor.getWinningTicketCategoriesByPrize().get(5000)).isEqualTo(1);
	 }
	 
		 	
	 
}

