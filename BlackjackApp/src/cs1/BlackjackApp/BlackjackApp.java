                        
package cs1.BlackjackApp; 
                        
import  cs1.app.*;      
                        
public class BlackjackApp
{
    void printArray( int[] numbers )
    {
        for ( int index = 0; index < numbers.length; index = index + 1 )
        {
            int curNum = numbers[ index ];
            
            System.out.print( curNum + ", " );
        }
        
        System.out.println();
    }
    
    int[] generateDeck()
    {
        int[] deck = new int[ 52 ];
        int block = 1;
        
        for ( int i = 0; i < deck.length && block <= 13; i = i + 4 )
        {
            deck[ i ] = (block*10) + 1;
            deck[ i + 1 ] = (block*10) + 2;
            deck[ i + 2 ] = (block*10) + 3;
            deck[ i + 3 ] = (block*10) + 4;
            
            block = block + 1;
        }
         
        return deck;
    }
    
    void drawCard( double x, double y, int card )
    {
        canvas.drawImage( x, y, "card" + card + ".png" );
    }
    
    void drawDeck( int[] deck, double y, int lastIndex )
    {
        double x = canvas.getWidth() / 15;
        
        for ( int i = 0; i < lastIndex + 1; i = i + 1)
        {
            canvas.drawImage( x, y, "card" + deck[ i ] + ".png" );
            x = x + 10;
        }
    }
    
    void drawPlayers( int[] cards, int[] points, boolean[] isInactive )
    {
        double playerX = canvas.getWidth() / ( cards.length + 1 );
        double playerY = canvas.getHeight() / 6;
        
        for ( int i = 0; i < cards.length; i = i + 1 )
        {
            canvas.drawImage( playerX, playerY, "card" + cards[ i ] + ".png" );
            
            if ( isInactive[ i ] == false )
            {
                canvas.drawSquare( playerX, playerY, 20, "white(black)|2" );
                canvas.drawText( playerX, playerY, points[ i ], "blue" );
            }
            else 
            {
                canvas.drawSquare( playerX, playerY, 20, "white(black)|2" );
                canvas.drawText( playerX, playerY, points[ i ], "red" );
            }
            
            playerX = playerX + canvas.getWidth() / ( cards.length + 1 );
        }
    }
    
    boolean hasFalse( boolean[] values )
    {
        for ( int i = 0; i < values.length; i = i + 1 )
        {
            if ( values[ i ] == false )
            {
                return true;
            }
        }
        
        return false;
    }
    
    int computeCardValue ( int card )
    {
        int cardValue = card / 10;
        
        if ( card > 100 )
        {
            return 10;
        }
        
        return cardValue;
    }
    
    void shuffle( int[] deck )
    {    
        for ( int i = 0; i < deck.length; i = i + 2 )
        {
            int firstInt = canvas.getRandomInt( 0, deck.length - 1 );
            int secondInt = canvas.getRandomInt( 0, deck.length - 1 );
            int[] indices = new int[]{ firstInt, secondInt };
              
            int index1 = indices[ 0 ];
            int index2 = indices[ 1 ];
                
            int oldValue = deck[ index1 ];
            deck[ index1 ] = deck[ index2 ];
            deck[ index2 ] = oldValue;            
        }
    }
    
    void reverse( int[] numbers )
    {        
        int lastIndex = numbers.length - 1;
        
        for ( int firstIndex = 0 ; firstIndex < numbers.length / 2; firstIndex = firstIndex + 1 )
        {
            int oldValue = numbers[ firstIndex ];
            numbers[ firstIndex ] = numbers[ lastIndex ];
            numbers[ lastIndex ] = oldValue;
            
            lastIndex = lastIndex - 1;
        }
    }
    
    int[] split( int[] numbers )
    {
        int[] result = new int[ numbers.length / 2 ];
        int j = 0;

        for ( int i = 0; i < numbers.length; i = i + 2)
        {
            result[ j ] = numbers[ i ];
            
            j = j + 1;
        }
        
        return result;
    }
    
    int[] merge( int[] numbers1, int[] numbers2 )
    {
        int[] result = new int[ numbers1.length*2 ];
        int j = 0;
        
        for ( int i = 0; j < numbers1.length; i = i + 2 )
        {
            result[ i ] = numbers1[ j ];
            result[ i + 1 ] = numbers2[ j ];
            
            j = j + 1;
        }
        
        return result;
    }
    
    boolean hasElement( int[] numbers, int value )
    {
        for (int index = 0 ; index < numbers.length ; index = index + 1)
        {
            int curValue = numbers[ index ];
      
            if (curValue == value)
            {
                return true;
            }
        }

        return false;
    }
    
    int[] remove( int[] numbers, int[] discard )
    {
        int[] result = new int[ numbers.length - discard.length ];
        int j = 0;
        
        for (int i = 0 ; i < numbers.length; i = i + 1)
        {
            if ( hasElement( discard, numbers[ i ] ) == false )
            {
                result[ j ] = numbers[ i ];
                j = j + 1;
            }
        }
        
        return result; 
    }
    
    void drawDeck( int[] deck, double y )
    {
        double x = canvas.getWidth() / 15;
        
        for ( int i = 0; i < deck.length; i = i + 1)
        {
            canvas.drawImage( x, y, "card" + deck[ i ] + ".png" );
            canvas.sleep(0.05);
            x = x + 10;
        }
    }
    
    void showSkills()
    {
        double height = canvas.getHeight();

        // draw initial deck
        int[] deck = generateDeck();
        drawDeck( deck, height/2 );

        // split the deck and draw each half
        canvas.waitForTouch();
        canvas.clear();
        int[] topHalf = split( deck );
        int[] botHalf = remove( deck, topHalf );
        drawDeck( topHalf, (height - 96)/2 );
        drawDeck( botHalf, (height + 96)/2 );

        //reverse each half and draw it
        canvas.waitForTouch();
        canvas.clear();
        reverse( topHalf );
        reverse( botHalf );
        drawDeck( topHalf, (height - 96)/2 );
        drawDeck( botHalf, (height + 96)/2 );

        //merge the two halves into a single deck
        canvas.waitForTouch();
        canvas.clear();
        deck = merge( topHalf, botHalf );
        drawDeck( deck, height/2 );
    }
       
    void playBlackjack( int n )
    {       
        int[] deck = generateDeck();
        int length = deck.length - 1;
        shuffle( deck );
  
        boolean[] isInactive = new boolean[n];
        int[] points = new int[n];   
        int[] lastCard = new int[n];
        
        int curPlayer = 0;
        int dealCardIndex = deck.length - 1;
        
        while ( hasFalse( isInactive ) == true )
        {
            canvas.clear();
            
            drawDeck( deck, canvas.getHeight() / 2, length);
            drawPlayers( lastCard, points, isInactive );
        
            if ( isInactive[ curPlayer ] == false )
            {
                Touch touch = canvas.waitForTouch();
                double touchX = touch.getX();
                double touchY = touch.getY();
                int numTaps = touch.getTaps();
                
                if ( numTaps == 1 )
                {
                    lastCard[ curPlayer ] = deck[ dealCardIndex ];
                    points[ curPlayer] = points[ curPlayer ] + computeCardValue( deck[ dealCardIndex ] );
                
                    dealCardIndex = dealCardIndex - 1;
                    length = length - 1;
                    
                    if ( points[ curPlayer ] >= 21 )
                    {
                        isInactive[ curPlayer ] = true;
                    }
                }
                else if ( numTaps == 2 )
                {
                    isInactive[ curPlayer ] = true; 
                }    
            }
            
            curPlayer = ( curPlayer + 1 )%n;
        }
        
        canvas.clear();
        
        drawPlayers( lastCard, points, isInactive );
        canvas.drawText( canvas.getWidth() / 2, canvas.getHeight() / 2, " No one left ", "green" );
    }
    
    public void run()
    {
        canvas.setBackground( " black " );
        canvas.setLandscape();
        //printArray( generateDeck() );
        //drawCard(50, 80, 0);
        //drawCard(140, 170, 123);
        //drawCard(230, 260, 101);
        //drawCard(600, 300, 111);
        //drawCard(30, 100, 93);
        //drawCard( 30, 50, 0 );
        //drawDeck(new int[]{123, 101, 0, 93, 134, 11}, 55, 2);
        //drawDeck(new int[]{123, 101, 0, 93, 134, 11}, 155, 5);     
        //drawDeck(generateDeck(), 260, 51);
        //drawDeck(new int[]{}, 260, 51);
        //drawPlayers(new int[]{84, 121, 114, 11}, new int[]{10, 18, 12, 3}, new boolean[]{false, true, true, false});
        //drawPlayers(new int[]{84, 121}, new int[]{10, 18}, new boolean[]{false, true});
        //drawPlayers(new int[]{84, 121, 132}, new int[]{10, 20, 19}, new boolean[]{false, true, true});
        //drawPlayers(new int[]{}, new int[]{}, new boolean[]{false});
        //drawPlayers(new int[]{}, new int[]{10, 18}, new boolean[]{false, true});
        //drawPlayers(new int[]{84, 121, 114, 11, 111, 22}, new int[]{10, 18, 12, 3, 6, 8}, new boolean[]{false, true, true, false, false, false});
        //System.out.println( "has a false? " + hasFalse(new boolean[]{true, true, false, true, false}) );
        //System.out.println( "has a false? " + hasFalse(new boolean[]{true, true, true}) );
        //System.out.println( "has a false? " + hasFalse(new boolean[]{true, true, true, true, true, false}) );
        //System.out.println( "has a false? " + hasFalse(new boolean[]{false}) );
        //System.out.println( "has a false? " + hasFalse(new boolean[]{}) );
        //System.out.println( "8s are worth: " + computeCardValue(83) );       // 8s are worth 8
        //System.out.println( "aces are worth: " + computeCardValue(12) );     // aces are worth 1
        //System.out.println( "queens are worth: " + computeCardValue(124) );  // queens are worth 10 (not 12)
        //System.out.println( "kings are worth: " + computeCardValue(132) );   // kings are worth 10 (not 13 )
        //System.out.println( "tens are worth: " + computeCardValue(104) );
        //System.out.println( "nines are worth: " + computeCardValue(92) );
        //System.out.println( "aces are worth: " + computeCardValue(14) );
        
        //int[] deck1 = generateDeck();
        //printArray(deck1);
        //shuffle(deck1);
        //printArray(deck1);
        //drawDeck(deck1, 100, 51);
        
        //int[] deck2 = {11, 12, 13, 14, 131, 132, 133, 134};
        //printArray(deck2);
        //shuffle(deck2);
        //printArray(deck2);
        //drawDeck(deck2, 200, 7);
        
        //printArray(deck1);
        //shuffle(deck1);
        //printArray(deck1);
        //drawDeck(deck1, 200, 51);
        
        //int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        //reverse(values);
        //printArray(values);    // displays 8 7 6 5 4 3 2 1
        
        //int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //reverse(values);
        //printArray(values);

        //int[] deck = generateDeck();
        //reverse(deck);
        //drawDeck(deck, 150);   // draws the reversed deck
        
        //int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        //int[] result = split(values);
        //printArray(result);      // displays 1, 3, 5, 7
        
//        int[] values = {};
//        int[] result = split(values);
//        printArray(result);      

        //int[] deck = generateDeck();
        //int[] result = split(deck);
        //drawDeck(result, 150);   // draws half of the deck
        
        //int[] values1 = {1, 3, 5, 7};
        //int[] values2 = {2, 4, 6, 8};
        //int[] result = merge(values1, values2);
        //printArray(result);      // displays 1 2 3 4 5 6 7 8
        
//        printArray( remove(new int[]{8, 4, 7, 1, 5, 3, 6, 2}, new int[]{2, 7, 3}) );
//        printArray( remove(new int[]{8, 7, 1, 5, 3, 6, 2}, new int[]{2, 7, 3}) );
//        printArray( remove(new int[]{8, 4, 1, 5, 3, 6, 2}, new int[]{4, 2}) );
//        printArray( remove(new int[]{8, 4, 7, 1, 5, 3, 6, 2}, new int[]{}) );
//        printArray( remove(new int[]{}, new int[]{}) );
 
        showSkills();
        playBlackjack( 4 );
    }   
}