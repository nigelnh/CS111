
package cs1.OOPBlackjackApp;

import  cs1.app.*;

public class Card
{
    // data memebers
    private int number;
    private int points;
        
    // constructors
    public Card( int initNumber )
    {
        number = initNumber;
        points = number/10;
        
        if ( points > 10 )
        {
            points = 10;
        }
    }
    
    // methods
    public int getPoints( )
    {            
        return points;
    }
    
    public int getWidth( )
    {
        return 71;
    }
    
    public int getHeight( )
    {
        return 96;
    }
        
    public void draw( double x, double y )
    {
        canvas.drawImage( x, y, "card" + number + ".png" );
    }
    
    public String getRank( )
    {
        int i = number/10;
        String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        
        return ranks[ i-1 ];
    }
    
    public String getSuit( )
    {
        int remainder = number % 10;
        String result = "";
        
        switch ( remainder )
        {
            case 1:
            {
                result = "Club";
                break;
            }
            
            case 2:
            {
                result = "Diamonds";
                break;
            }
            
            case 3:
            {
                result = "Hearts";
                break;
            }
            
            case 4:
            {
                result = "Spades";
                break;
            }
        }
        
        return result;
    }
    
    public String getName( )
    {
        return getRank( ) + " of " + getSuit( );
    }
        
    public static void main(String[] args)
    {                
//        int x = 5;
//        
//        System.out.println(++x);
//        Card card1 = new Card(84);
//        
//        System.out.println("card rank : " + card1.getRank());      // Eight
//        System.out.println("card rank : " + card1.getSuit());      // Spades
//        System.out.println("card rank : " + card1.getName());      // Eight of Spades
//        System.out.println("card value: " + card1.getPoints());    // 8
//        System.out.println("card width : " + card1.getWidth());    // 71
//        System.out.println("card height: " + card1.getHeight());   // 96
        
//        Card card2 = new Card(12);
//        
//        System.out.println("card rank : " + card2.getRank());      
//        System.out.println("card rank : " + card2.getSuit());      
//        System.out.println("card rank : " + card2.getName());      
//        System.out.println("card value: " + card2.getPoints());    
//        System.out.println("card width : " + card2.getWidth());    
//        System.out.println("card height: " + card2.getHeight());
        
//        Card card3 = new Card(131);
//        
//        System.out.println("card rank : " + card3.getRank());      
//        System.out.println("card rank : " + card3.getSuit());      
//        System.out.println("card rank : " + card3.getName());      
//        System.out.println("card value: " + card3.getPoints());    
//        System.out.println("card width : " + card3.getWidth());    
//        System.out.println("card height: " + card3.getHeight());
    }  
}