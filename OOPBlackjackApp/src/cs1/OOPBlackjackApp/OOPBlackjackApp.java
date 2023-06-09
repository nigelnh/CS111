
package cs1.OOPBlackjackApp;

import  cs1.app.*;
import java.util.ArrayList;

public class OOPBlackjackApp
{
    public void run()
    {
        canvas.setLandscape();
        canvas.setBackground( "black" );
        
//        Card card1 = new Card( 0 );
//        Card card2 = new Card( 123 );
//        Card card3 = new Card( 101 );
//                              
//        card1.draw( 50, 80 );
//        card2.draw( 140, 170 );
//        card3.draw( 230, 260 );
        
//        Card card1 = new Card(84, 10);
//        
//        card1.draw( 80, 100 );
        
//        mickey.draw(50, 70);      // assuming Mickey's last card was 8 of clubs and it increased his points to 10
//        minnie.draw(150, 200);    // assuming Minnie's last card was Queen of Spades and it increased her points to 24
//        tom.draw(300, 90);        // assuming Tom's last card was Ace of Spades and it increased his points to 21
//        jerry.draw(420, 140);     // assuming Jerry's last card was Ace of Spades and it increased his points to 21
        
        Player mickey = new Player("Mickey");
        Player minnie = new Player("Minnie");
        Player donald = new Player("Donald");
        Player nguyen = new Player("Nguyen");
        Player xuan = new Player("Xuan");
        Player nhan = new Player("Nhan");
        Player tom = new Player("Tom");
        Player jerry = new Player("Jerry");
        
//        mickey.draw( 80, 100 );

//        Card card1 = new Card( 113 );

//        mickey.collectCard( card1 );
//        minnie.collectCard( card1 );

//        mickey.draw( 200, 100 );
        
//        Card card2 = new Card( 84 );
//        
//        mickey.collectCard( card2 );
//        donald.collectCard( card2 );

//        mickey.draw( 300, 100 );
//        
//        mickey.collectCard( card1 );
//        nhan.collectCard( card2 );

//        mickey.draw( 400, 100 );
           
        // create another card so Mickey goes over 21 and redraw to see if inactive
        
//        Deck deck = new Deck();
//        
//        deck.draw( 50 );
//        
//        deck.deal( );
//        
//        deck.draw( 100 );
//        
//        deck.deal( );
//        
//        deck.draw( 150 );
//        
//        deck.deal( );
//        
//        deck.draw( 200 );
//        
//        deck.deal( );
//        
//        deck.draw( 250 );

        // deal four cards from the deck and redraw it somewhere below -- should be missing the Kings
        
        Casino casino = new Casino();
//        
        casino.add( mickey );
        casino.add( minnie );
        casino.add( donald );
        casino.add( nguyen );
        casino.add( xuan );
        casino.add( nhan );
        casino.add( tom );
        casino.add( jerry );
        
//        casino.drawPlayers( );
        
        // create an empty casino

        // create 4-5 players and add them to the casino
        
        // draw the players to see if method works correctly, then comment out

        // check if there are active players, then comment out

        // play the game (after the previous test cases pass)
        
        casino.playBlackjack( );
    }
}