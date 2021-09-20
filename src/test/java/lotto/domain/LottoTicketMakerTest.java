package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.util.Material;

class LottoTicketMakerTest {
	LottoTicketMaker lottoTicketMaker=new LottoTicketMaker();
	List<Integer> lottoNumbers=new ArrayList<>();
	
	
	
	@DisplayName("로또 생성시 1 부터 45까지 이루어지는 지 테스트")
	@Test
	void testLottoTicketMaker() {
		IntStream.rangeClosed(Material.LOTTO_START_NUMBER, Material.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
		assertEquals(45,lottoNumbers.size());
		
	}
	@DisplayName("1장당 1000원 테스트")
	@Test
	void testCalculateAvailableCount() {
		assertEquals(14, lottoTicketMaker.calculateAvailableCount(14000));
	}
	@DisplayName("1장당 로또 번호 6개 테스트")
	@Test
	void testBuySingleLottoTicket() {
		
		assertThat(lottoTicketMaker.buySingleLottoTicket().getNumbers().size()).isEqualTo(6);
		
	}
	@DisplayName("입력한 가격만큼 로또 티켓 개수 테스트")
	@Test
	void testBuyAvailableLottoTickets() {
		lottoTicketMaker.buyAvailableLottoTickets(lottoTicketMaker.calculateAvailableCount(14000));
		assertThat(lottoTicketMaker.getLottoTickets().size()).isEqualTo(14);
		
	}

}
