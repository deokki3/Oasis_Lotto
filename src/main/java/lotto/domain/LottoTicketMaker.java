package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lotto.util.Material;

public class LottoTicketMaker {
	
    private List<Integer> lottoNumbers = new ArrayList<>();
    private List<LottoNumber> lottoTickets = new ArrayList<>();

    public LottoTicketMaker(){
        createLottoNumbers();
    }
    //로또 번호 리스트
    public List<Integer> getLottoNumbers(){
    	
        return lottoNumbers;
    }
    //로또 티켓 리스트
    public List<LottoNumber> getLottoTickets() {
        return lottoTickets;
    }
    
    //한장당 가격 1000원
    public int calculateAvailableCount(int amount){
    	
        return amount/1000;
    } 
    
    //로또 생성 
    public LottoNumber buySingleLottoTicket(){
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(lottoNumbers);
        for(int i = 0; i < Material.LOTTO_PICK_COUNT; i++){
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        
        return new LottoNumber(numbers);
    }
    //장당 로또 티켓
    public void buyAvailableLottoTickets(int ticketCount){
        for(int i = 0; i < ticketCount; i++){
            lottoTickets.add(buySingleLottoTicket());
        }

    }

    public void createLottoNumbers(){
    	
        IntStream.rangeClosed(Material.LOTTO_START_NUMBER, Material.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
        
    }

}