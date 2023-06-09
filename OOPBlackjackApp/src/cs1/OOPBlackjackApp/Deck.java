
package cs1.OOPBlackjackApp;

import  cs1.app.*;
import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;
    
    public Deck( )
    {
        cards = new ArrayList<Card>();
        
        for ( int a = 1; a <= 13; a++ )
        {
            for ( int b = 1; b < 5; b++ )
            {
                Card card = new Card( 10*a + b );
                cards.add( card ); 
            }
        }
    }
    
    public Card deal( )
    {   
        Card card = cards.remove( cards.size() - 1 );
        return card;
    }
    
    public void shuffle( ) 
    {
        for ( int i = 0; i < cards.size(); i = i + 2 )
        {
            int firstInt = canvas.getRandomInt( 0, cards.size() - 1 );
            int secondInt = canvas.getRandomInt( 0, cards.size() - 1 );
            int[] indices = new int[]{ firstInt, secondInt };
              
            int index1 = indices[ 0 ];
            int index2 = indices[ 1 ];
                
            Card oldValue = cards.get( index1 );
            cards.set( index1, cards.get( index2 ) );
            cards.set( index2, oldValue );            
        }
    }
    
    public void draw( double y )
    {
        double x = 71/2;
               
        for ( int i = 0; i < cards.size(); i = i + 1)
        {
            Card card = cards.get( i );
            card.draw( x, y );
            x = x + 10;
        }
    }
    
    public static void main(String[] args)
    {    
        Deck deck = new Deck();
        
        Card card = deck.deal();
        
        System.out.println( card.getPoints( ) );
        System.out.println( card.getName( ) );
        
        card = deck.deal();
        
        System.out.println( card.getPoints( ) );
        System.out.println( card.getName( ) );
        
        card = deck.deal();
        
        System.out.println( card.getPoints( ) );
        System.out.println( card.getName( ) );
        
        card = deck.deal();
        
        System.out.println( card.getPoints( ) );
        System.out.println( card.getName( ) );
        
        card = deck.deal();
        
        System.out.println( card.getPoints( ) );
        System.out.println( card.getName( ) );
        
        // display card details (number values, points) -- should be 134, 10 (King of Spades)

        // deal three more cards and display their details -- should be the other Kings

        // deal one more card and display its details -- should be the Queen of ClubsDeck deck = new Deck();
    }  
}