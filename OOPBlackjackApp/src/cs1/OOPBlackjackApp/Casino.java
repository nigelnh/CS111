
package cs1.OOPBlackjackApp;

import  cs1.app.*;
import java.util.ArrayList;

public class Casino
{
    private ArrayList<Player> players;
    
    public Casino( )
    {
        players = new ArrayList<Player>();
    }
    
    public void add( Player player )
    {
        players.add( player );
    }
    
    public boolean hasActive( ) 
    {
        for ( int i = 0; i < players.size(); i++ )
        {
            Player player = players.get( i );
  
            if ( player.isActive( ) == true )
            {
                return true;
            }          
        }
        
        return false;
    }
    
    public void drawPlayers( )
    {
        double x = canvas.getWidth() / ( players.size() + 1 );
                                        
        for ( int i = 0; i < players.size(); i++ )
        {
            Player player = players.get( i );
            
            player.draw( x, 96/2 );
            
            x = x + canvas.getWidth() / ( players.size() + 1 );
        }
    }
    
    public void playBlackjack( )
    {
        Deck deck = new Deck();

        deck.shuffle( );
        
        int curPlayer = 0; 
        
        while ( hasActive( ) == true )
        {
            canvas.clear();
            
            deck.draw( canvas.getHeight()/2 );
            drawPlayers( );
                      
            Player player = players.get( curPlayer );
                
            if ( player.isActive( ) == true )
            {
                Touch touch = canvas.waitForTouch(); 
                double touchX = touch.getX(); 
                double touchY = touch.getY(); 
                int numTaps = touch.getTaps();
                
                if ( numTaps == 1 )
                {
                    player.collectCard( deck.deal( ) );
                }
                else if ( numTaps == 2 )
                {
                    player.stopPlaying( );
                }
            }
            
            curPlayer = ( curPlayer + 1 ) % players.size(); 
        }
        
        canvas.clear();
        drawPlayers( );
        canvas.drawText( canvas.getWidth() / 2, canvas.getHeight() / 2, " No one left ", "green" ); 
    }
    
    public static void main(String[] args)
    {   
    }  
}