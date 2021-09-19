package lotto.view;

import java.util.Scanner;

import lotto.util.Material;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int amount;
    private String winningNumbers;

    public void askAmount(){
        System.out.println(Material.AMOUNT_MESSAGE_QUESTION);
        amount = Integer.parseInt(scanner.nextLine());
    }

    public int getAmount(){
        return amount;
    }

    public void askWinningNumbers(){
        System.out.println(Material.WINNING_NUMBERS_QUESTION);
        winningNumbers = scanner.nextLine();
    }

    public String getWinningNumbers(){
        return winningNumbers;
    }

}