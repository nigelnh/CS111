
package cs1.OOPBlackjackApp;

import  cs1.app.*;

public class Player 
{
    // data members
    private String name;
    private int points;
    private boolean active;
    private Card lastCard;
    
    // constructors
    public Player( String initName )
    {
        name = initName;
        points = 0;
        active = true;
        lastCard = new Card( 0 );
    }
    
    // methods
    public String getName( )
    {
        return name;
    }
    
    public int getPoints( )
    {
        return points;
    }
    
    public boolean isActive( )
    {
        return active;
    }
    
    public void stopPlaying( )
    {
        active = false;
    }
    
    public void collectCard( Card card )
    {
        lastCard = card;
        if ( active == true )
        {
            points = points + lastCard.getPoints( );
            
            if ( points >= 21 )
            {
                stopPlaying();
            }
        }
    }
    
    public void draw( double x, double y )
    {
        lastCard.draw( x, y );
        if ( active == true )
        {
            canvas.drawSquare( x, y, 20, "white(black)|2" ); 
            canvas.drawText( x, y, points, "blue" );
        }
        else 
        {
            canvas.drawSquare( x, y, 20, "white(black)|2" ); 
            canvas.drawText( x, y, points, "red" );
        }
        
        canvas.drawText( x, y + 96/2, name, "orange" );
    }
    
    public static void main(String[] args)
    {    
        Player mickey = new Player( "Mickey" );
        
        System.out.println("player name: " + mickey.getName());      // Mickey
        System.out.println("player points: " + mickey.getPoints());  // 0
        System.out.println("player active: " + mickey.isActive());   // true
        
        Card card1 = new Card( 64 );

        mickey.collectCard( card1 );
//
//        // display player's detail again to see if points changed
//
//        // create a few more cards give them to the player and display the player's detail
// 
//        // deactivate the player (tell player to stop) and display player's details to make sure not active
//
//        // create another player, give some of the previous cards to new player and display the player's detail as above
    }  
}