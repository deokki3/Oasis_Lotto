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
    //�ζ� ��ȣ ����Ʈ
    public List<Integer> getLottoNumbers(){
    	
        return lottoNumbers;
    }
    //�ζ� Ƽ�� ����Ʈ
    public List<LottoNumber> getLottoTickets() {
        return lottoTickets;
    }
    
    //����� ���� 1000��
    public int calculateAvailableCount(int amount){
    	
        return amount/1000;
    } 
    
    //�ζ� ���� 
    public LottoNumber buySingleLottoTicket(){
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(lottoNumbers);
        for(int i = 0; i < Material.LOTTO_PICK_COUNT; i++){
            numbers.add(lottoNumbers.get(i));
        }
        Collections.sort(numbers);
        
        return new LottoNumber(numbers);
    }
    //��� �ζ� Ƽ��
    public void buyAvailableLottoTickets(int ticketCount){
        for(int i = 0; i < ticketCount; i++){
            lottoTickets.add(buySingleLottoTicket());
        }

    }

    public void createLottoNumbers(){
    	
        IntStream.rangeClosed(Material.LOTTO_START_NUMBER, Material.LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
        
    }

}