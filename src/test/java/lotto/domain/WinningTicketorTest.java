package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTicketorTest {
	private WinningTicketor winningTicketor=new WinningTicketor("1,2,3,4,5,6");

	
	@DisplayName("6개 아닌 개수 입력시 오류 테스트")
	@Test
	void testWinningTicketor() {
		  assertThatIllegalArgumentException().isThrownBy(()->{
	            WinningTicketor winningTicketor1 = new WinningTicketor("1,2,3,4,5,6,7");
	        });
	    }
	@DisplayName("당첨 번호가 생성 되는 지 테스트")
	@Test
	void testGetWinningNumbers() {
		 assertThat(winningTicketor.getWinningNumbers().size()).isEqualTo(6);
	}
	
	 @DisplayName("카운트에 따라 적절한 상금 찾는지 테스트")
	    @Test
	    
	    void categorizeWinningTicketByPrizeTest() {
		 winningTicketor.categorizeWinningTicketByPrize(3);
		 assertThat(winningTicketor.getWinningTicketCategoriesByPrize().get(5000)).isEqualTo(1);
	 }
	 
		 	
	 
}

