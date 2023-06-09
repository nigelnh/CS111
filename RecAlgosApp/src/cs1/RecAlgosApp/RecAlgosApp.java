
package cs1.RecAlgosApp;

import  cs1.app.*;

public class RecAlgosApp
{
    int sequence( int n )
    {
        if ( n == 1 )
        {
            return 3;
        }
        else if ( n == 2 )
        {
            return 2;
        }
        else if ( n == 3 )
        {
            return 1;
        }
        else 
        {
            return 2*sequence( n - 3 ) - sequence( n - 1 );
        }
    }
    
    int gcd( int a, int b )
    {
        if ( b == 0 )
        {
            return a;
        }
        else 
        {
            int r = a%b;
            a = b;
            b = r;
            
            return gcd( a, b );
        }
    }
    
    int gcdLoop( int a, int b )
    {
        while ( b != 0 )
        {
            int r = a%b;
            a = b;
            b = r;
        }
        
        return a;
    }
    
    boolean binarySearch( double[] numbers, double value, int i, int j )
    {
        if ( i > j )
        {
            return false;
        }
        else
        {
            int midIndex = ( i + j )/2;
            
            if ( numbers[ midIndex ] == value )
            {
                return true;
            }
            else if ( numbers[ midIndex ] < value )
            {
                i = midIndex + 1;
            }
            else if ( numbers[ midIndex ] > value )
            {
                j = midIndex - 1;
            }
            
            return binarySearch( numbers, value, i, j );
        }
    }
    
    boolean binarySearch(double[] numbers, double value)
    {
        binarySearch( numbers, value, 0, numbers.length-1 );

        return binarySearch(numbers, value, 0, numbers.length-1);
    }
        
    boolean binarySearchLoop( double[] numbers, double value )
    {
        int i = 0;
        int j = numbers.length - 1;
        int midIndex = ( i + j )/2;
        
        while ( i < j && numbers[ midIndex ] != value )
        {
            if ( numbers[ midIndex ] < value )
            {
                i = midIndex + 1;
            }
            else if ( numbers[ midIndex ] > value )
            {
                j = midIndex - 1;
            }

            midIndex = ( i + j )/2;
        }
        
        if ( numbers[ midIndex ] == value )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void run()
    {
//        System.out.println("the 6-th number is: " + sequence( 6 ));      // displays: ... is 3
//        System.out.println("the 8-th number is: " + sequence( 8 ));      //           ... is -9
//        System.out.println("gcd(24, 18) = " + gcd(24, 18));    // displays:   gcd(24, 18) = 6
//        System.out.println("gcd(24, 12) = " + gcd(24, 12));    //             gcd(24, 12) = 12
//        System.out.println("gcd(12, 16) = " + gcd(12, 16));    //             gcd(12, 16) = 4
//        System.out.println("gcd(13, 8) = " + gcd(13, 8));      //             gcd(13, 8) = 1
//        System.out.println("gcdLoop(24, 18) = " + gcdLoop(24, 18));    // displays:   gcdLoop(24, 18) = 6
//        System.out.println("gcdLoop(24, 12) = " + gcdLoop(24, 12));    //             gcdLoop(24, 12) = 12
//        System.out.println("gcdLoop(12, 16) = " + gcdLoop(12, 16));    //             gcd(12, 16) = 4
//        System.out.println("gcdLoop(13, 8) = " + gcdLoop(13, 8));      //             gcdLoop(13, 8) = 1
        
        //                  0  1  2  3  4   5   6   7   8     the page numbers    
//        double[] numbers = {1, 4, 5, 8, 9, 10, 23, 35, 47};

//        System.out.println("Is 5 between pages 0..8? " + binarySearch(numbers, 5, 0, 8));         // displays: ...? true     
//        System.out.println("Is 5 between pages 1..6? " + binarySearch(numbers, 5, 1, 6));         //           ...? true
//        System.out.println("Is 5 between pages 2..6? " + binarySearch(numbers, 5, 2, 6));         //           ...? true
//        System.out.println("Is 5 between pages 3..7? " + binarySearch(numbers, 5, 3, 7));         //           ...? false     
//
//        System.out.println("Is -2 in the array? " + binarySearch(numbers, -2, 0, 8));             //           ...? false     
//        System.out.println("Is 61 in the array? " + binarySearch(numbers, 61, 0, 8));             //           ...? false     
//        System.out.println("Is 20 in the array? " + binarySearch(numbers, 20, 0, 8));             //           ...? false 
        
//        double[] numbers = {1, 5, 7, 8, 9, 10, 23, 35, 47};
//
//        System.out.println( binarySearch(numbers, 8) );       // returns true
//        System.out.println( binarySearch(numbers, 12) );      // returns false
        
        int a = 3;
        int b = --a;
        System.out.println( b );
        System.out.println( b );
      
        //                  0  1  2  3  4   5   6   7   8     the page numbers    
//        double[] numbers = {1, 4, 5, 8, 9, 10, 23, 35, 47};
//
//        System.out.println("Is 5 in the array? " + binarySearchLoop(numbers, 5));         // displays: ...? true     
//        System.out.println("Is 35 in the array? " + binarySearchLoop(numbers, 35));         //           ...? true
//        System.out.println("Is -2 in the array? " + binarySearchLoop(numbers, -2));             //           ...? false
//        System.out.println("Is 61 in the array? " + binarySearchLoop(numbers, 61));             //           ...? false
//        System.out.println("Is 20 in the array? " + binarySearchLoop(numbers, 20));             //           ...? false
    }
}