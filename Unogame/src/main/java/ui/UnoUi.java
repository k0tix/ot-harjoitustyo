package ui;

import domain.Deck;
import java.util.Scanner;

/**
 *
 * @author k0tix
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        System.out.println("UNOGAME");
        System.out.println("How many player will be playing (2-10)?");
        
        int playerAmount = 0;
        
        while (true) {
            String players = read.nextLine();
            
            try {
                int amount = Integer.parseInt(players);
                
                if (amount < 2 || amount > 10) {
                    System.out.println("There can only be 2-10 players!");
                } else {
                    playerAmount = amount;
                    break;
                }
                
            } catch (Exception e) {
                System.out.println("Only valid integers allowed as input!");
            }
        }
        
        System.out.println(String.format("##########\n%d players\n##########", playerAmount));
        
        Deck deck = new Deck();
        System.out.println(deck.isEmpty());
        deck.initializeCards();
        System.out.println(deck.isEmpty());
    }
    
}
