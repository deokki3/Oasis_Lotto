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
	
	
	
	@DisplayName("�ζ� ������ 1 ���� 45���� �̷������ �� �׽�Ʈ")
	@Test
	void testLottoTicketMaker() {
		IntStream.rangeClosed(Material.LOTTO_START_NUMBER, Material.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
		assertEquals(45,lottoNumbers.size());
		
	}
	@DisplayName("1��� 1000�� �׽�Ʈ")
	@Test
	void testCalculateAvailableCount() {
		assertEquals(14, lottoTicketMaker.calculateAvailableCount(14000));
	}
	@DisplayName("1��� �ζ� ��ȣ 6�� �׽�Ʈ")
	@Test
	void testBuySingleLottoTicket() {
		
		assertThat(lottoTicketMaker.buySingleLottoTicket().getNumbers().size()).isEqualTo(6);
		
	}
	@DisplayName("�Է��� ���ݸ�ŭ �ζ� Ƽ�� ���� �׽�Ʈ")
	@Test
	void testBuyAvailableLottoTickets() {
		lottoTicketMaker.buyAvailableLottoTickets(lottoTicketMaker.calculateAvailableCount(14000));
		assertThat(lottoTicketMaker.getLottoTickets().size()).isEqualTo(14);
		
	}

}
