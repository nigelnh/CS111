
package cs1.RecDrawApp;

import  cs1.app.*;

public class RecDrawApp
{
    void printTable( int[][] table )
    {        
        for ( int r = 0; r < table.length; r++ )
        {
            for ( int c = 0; c < table[r].length; c++ )
            {
                int curValue = table[ r ][ c ];
                System.out.print( curValue + ", " );
            }
            
            System.out.println();
        }
    }
    
    void drawMickey(double faceX, double faceY, double radius, int depth)
    {
        if ( depth > 0 )
        {
            double faceX1 = faceX - radius;
            double faceY1 = faceY - radius;
            
            double faceX2 = faceX + radius;
            double faceY2 = faceY - radius;
            
            canvas.drawCircle( faceX, faceY, radius, "black(white)|2");
            
            drawMickey( faceX1, faceY1, radius/2, depth - 1);
            
            drawMickey( faceX2, faceY2, radius/2, depth - 1);
        }
    }
    
    void drawStackedLines(double x1, double x2, double y, double vertSpace, int depth)
    {
        if ( depth > 0 )
        {
            double x3 = x1 + ( x2 - x1 )/3;
            
            double x4 = ( x2 + x3 )/2;
            
            canvas.drawLine( x1, y, x2, y, "black" );
            
            drawStackedLines( x1, x3, y + vertSpace, vertSpace, depth - 1 );
            
            drawStackedLines( x4, x2, y + vertSpace, vertSpace, depth - 1 );
        }
    }
    
    void fillRegion( int[][] image, int r, int c, int color )
    {
        if ( ( ( r >= 0 ) && ( r < image.length ) ) && ( ( c >=0 && c < image[0].length ) ) )
        {
            if ( image[ r ][ c ] != 0 && image[ r ][ c ] != color )
            {
                image[ r ][ c ] = color; 
                
                fillRegion( image, r-1, c, color );              
                fillRegion( image, r+1, c, color );
                fillRegion( image, r, c-1, color );
                fillRegion( image, r, c+1, color );
            }
        }       
    }

    void fillAllRegions( int[][] image )
    {
        int[] palette = { 0x00FF0000, 0x0000FF00, 0x000000FF, 0x00FFFF00, 0x00FF00FF, 0x0000FFFF };
        
        int colorIndex = 0; 
        
        for ( int r = 1; r < image.length-1; r++ )
        {
            for ( int c = 1; c < image[0].length-1; c++ )
            {
                if ( image[ r ][ c ] == 0x00FFFFFF && image[ r ][ c-1 ] == 0 )
                {
                    fillRegion( image, r, c, palette[ colorIndex ] );
                    
                    colorIndex = (colorIndex + 1) % palette.length;  // select new color after region filled
                }
            }
        }
    }
    
    public void run()
    {
        drawMickey( 150, 400, 80, 8);
//        drawStackedLines(10, 300, 20, 35, 4); 
        
//        int[][] image = { { 0, 0, 0, 0, 0, 0, 477, 477, 0, 0}, { 0, 255, 255, 255, 0, 0, 0, 477, 0, 0 }, { 255, 255, 255, 255, 0, 477, 477, 477, 0, 321 }, { 0, 255, 255, 255, 0, 0, 477, 0, 321, 321 }, { 0, 0, 0, 0, 0, 0, 477, 0, 321, 0 } };

// test one at a time (comment out the rest)

//        fillRegion( image, 2, 2, 125 );
//        printTable( image );            // 255s replaced by 125s
//
//        fillRegion( image, 1, 1, 326 );
//        printTable( image );            // 255s replaced by 326s

//        fillRegion( image, 3, 2, 137 );
//        printTable( image );            // 255s replaced by 137s

//        fillRegion( image, 2, 5, 512 );
//        printTable( image );            // 477s replaced by 512s
//
//        fillRegion( image, 1, 7, 831 );
//        printTable( image );            // 477s replaced by 831s
//
//        fillRegion( image, 2, 7, 165 );
//        printTable( image );            // 477s replaced by 165s

//        fillRegion( image, 4, 8, 123 );
//        printTable( image );            // 321s replaced by 123s
//        
//        int[][] scene = canvas.readImage( "scene1.png" );
//        fillRegion( scene, 250, 90, 0x00FF0000 );
//        canvas.drawImage( 180, 316, scene );    // flower is red
        
//        int[][] scene = canvas.readImage( "scene1.png" );
//        fillRegion( scene, 280, 40, 0x0000FF00 );
//        canvas.drawImage( 180, 316, scene );    // flower is green
//        
//        int[][] scene = canvas.readImage( "scene1.png" );
//        fillRegion( scene, 290, 200, 0x00FFFF00 );
//        canvas.drawImage( 180, 316, scene );     // smiley is yellow
        
//        int[][] letterA = canvas.readImage( "a.png" );
//        fillRegion( letterA, 5, 10, 0x00FF00FF );
//        canvas.drawImage( 180, 316, letterA ); // A is magenta
        
//        int white = 0x00FFFFFF;
//        int[][] image = { { 0, 0, 0, 0, 0, 0, 0 },{ 0, white, white, 0, 0, 0, 0 }, { 0, white, white, 0, white, white, 0 }, { 0, 0, 0, 0, white, white, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
//          
//        fillAllRegions( image );
//        printTable( image );   // displays 16711680 (RED) in top-left
                                   // 65280 (GRN) in bot-right
        
//        int[][] scene = canvas.readImage( "scene1.png" );
//        fillAllRegions( scene );
//        canvas.drawImage( 180, 316, scene );
        
//        int[][] scene = canvas.readImage( "scene2.png" );
//        fillAllRegions( scene );
//        canvas.drawImage( 180, 316, scene );
//        
//        int[][] letterQ = canvas.readImage( "q.png" );
//        fillAllRegions( letterQ );
//        canvas.drawImage( 180, 316, letterQ );  // leterQ is now red
    }
}                   
