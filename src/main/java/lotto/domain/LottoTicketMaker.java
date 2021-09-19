package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lotto.util.Material;

public class LottoTicketMaker {
	
    private List<Integer> lottoNumbers = new ArrayList<>();
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTicketMaker(){
        createLottoNumbers();
    }

    public List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int calculateAvailableCount(int amount){
        return amount/1000;
    }

    public LottoTicket buySingleLottoTicket(){
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(lottoNumbers);
        for(int i = 0; i < Material.LOTTO_PICK_COUNT; i++){
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }

    public void buyAvailableLottoTickets(int ticketCount){

        for(int i = 0; i < ticketCount; i++){
            lottoTickets.add(buySingleLottoTicket());
        }

    }

    private void createLottoNumbers(){
        IntStream.rangeClosed(Material.LOTTO_START_NUMBER, Material.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
    }

}