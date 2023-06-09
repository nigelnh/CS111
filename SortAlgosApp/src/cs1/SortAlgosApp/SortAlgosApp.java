                        
package cs1.SortAlgosApp; 
    
import  cs1.app.*;     

import java.util.Random;
import java.util.Date;
                        
public class SortAlgosApp
{ 
    void printArray( double[] numbers )
    {
        for ( int i = 0; i < numbers.length; i = i + 1 )
        {
            double curNum = numbers[ i ];
            
            System.out.print( curNum + ", " );
        }
        
        System.out.println();
    }
    
    boolean bubbleRun( double[] numbers, int numPairs )
    {   
        boolean swap = false;
        
        for( int i = 0; i < numPairs; i = i + 1)
        {
            if ( numbers[ i ] > numbers[ i + 1 ] )
            {
                double oldValue = numbers[ i ];
                numbers[ i ] = numbers[ i + 1 ];
                numbers[ i + 1 ] = oldValue;  
                
                swap = true;
            }
        }
        
        return swap;
    }
    
    void bubbleSort( double[] numbers )
    {
        int n = numbers.length - 1; 
        
        boolean swap = bubbleRun( numbers, n );
        
        while ( swap == true )
        {
            n = n - 1;
            swap = bubbleRun( numbers, n );
        }
    }
    
    int findIndexOfMinValue( double[] numbers, int indexFrom )
    {   
        int curSmall = indexFrom;
        
        for ( int i = indexFrom + 1; i < numbers.length; i = i + 1 )
        {
            if ( numbers[ curSmall ] > numbers[ i ] )
            {
                curSmall = i;  
            }         
        }
        
        return curSmall;
    }
    
    void selectionSort( double[] numbers )
    {
        for ( int i = 0; i < numbers.length - 1; i = i + 1 )
        {
            int curSmall = findIndexOfMinValue( numbers, i );
            
            if ( numbers[ i ] > numbers[ curSmall ] )
            {
                double oldValue = numbers[ i ];
                numbers[ i ] = numbers[ curSmall ];
                numbers[ curSmall ] = oldValue;
            }
        }
    }
        
    void pushLeft( double[] numbers, int index )
    {        
        double curNum = numbers[ index ];
        int j = index - 1; 
        
        while( j >= 0 && curNum < numbers[ j ] )
        {
            numbers[ j + 1 ] = numbers[ j ];   
            j = j - 1;
        }
        numbers[ j + 1 ] = curNum;        
    }
    
    
    void insertionSort( double[] numbers )
    {        
        for ( int i = 1; i < numbers.length; i = i + 1 )
        {
            pushLeft( numbers, i );
        }
    }
    
    double[] generateArray( int n, char order )
    {
        Random rand = new Random(n);
        double[] numbers = new double[n];
        for (int i = 0; i < n; ++i)
        {
            if (order == 'i')
            {
                numbers[i] = i+1;
            }
            else if (order == 'd')
            {
                numbers[i] = n-i;
            }
            else if (order == 'r')
            {
                numbers[i] = rand.nextInt();
            }
        }
        return numbers;
    }
    
    void testSortAlgorithms( int initSize, int finalSize, int sizeStep, char order )
    {
        System.out.println( "Configuration: " + order );
        System.out.println( "----------------" );
        System.out.printf( "%-5s %10s %10s %10s\n", "Size", "Bubble", "Select", "Insert" );
        
        for ( int n = initSize; n <= finalSize; n = n + sizeStep )
        {
            double[] size1 = generateArray( n, order );
            double[] size2 = generateArray( n, order );
            double[] size3 = generateArray( n, order );
            
            long start1 = new Date().getTime();
            bubbleSort(size1);
            long stop1 = new Date().getTime();
            long time1 = stop1 - start1;
            
            long start2 = new Date().getTime();
            selectionSort(size2);
            long stop2 = new Date().getTime();
            long time2 = stop2 - start2;
            
            long start3 = new Date().getTime();
            insertionSort(size3);
            long stop3 = new Date().getTime();
            long time3 = stop3 - start3;
            
//            System.out.println( n +"   "+ time1 + "   " + time2 +"   " + time3 );
            System.out.printf( "%-5d %10d %10d %10d\n", n, time1, time2, time3 );
        }    
    }
   
    public static void main(String[] args)
    {
        System.out.println( "Hello from regular Java" );
        
        SortAlgosApp app = new SortAlgosApp();
        
        app.testSortAlgorithms( 1000, 15000, 1000, 'i' );  // collect data for best case
        System.out.println();

        app.testSortAlgorithms( 1000, 15000, 1000, 'd' );  // collect data for worst case
        System.out.println();
        
        app.testSortAlgorithms( 1000, 15000, 1000, 'r' );  // collect data for average case
        System.out.println();
    }
        
//    public static void main(String[ ] args)
//    {
//        new SortAlgosApp().run();
//    }

    public void run()
    {
//        double[] testArray = { 5, 2, 1, 3, 4 };
//        boolean swapped = bubbleRun(testArray, 1);    // examines the first 1 pairs; returns true
//        printArray(testArray);                        // displays 2 5 1 3 4
//        System.out.println( "Did it swap: " + swapped );    // displays true
//
//        double[] testArray = { 5, 2, 1, 3, 4 };
//        boolean swapped = bubbleRun(testArray, 2);    // examines the first 2 pairs; returns true
//        printArray(testArray);                        // displays 2 1 5 3 4
//        System.out.println( "Did it swap: " + swapped );    // displays true
//
//        double[] testArray = { 5, 2, 1, 3, 4 };
//        boolean swapped = bubbleRun(testArray, 4);    // examines the first 4 pairs; returns true
//        printArray(testArray);                        // displays 2 1 3 4 5
//        System.out.println( "Did it swap: " + swapped );    // displays true
//
//        double[] testArray = { 1, 2, 3, 4, 5 };
//        boolean swapped = bubbleRun(testArray, 4);    // examines the first 4 pairs; returns false
//        printArray(testArray);                        // displays 1 2 3 4 5
//        System.out.println( "Did it swap: " + swapped );    // displays false
//        double[] testArray = {5, 2, 1, 3, 4};
//        bubbleSort(testArray);
//        printArray(testArray);                         // displays 1 2 3 4 5
        
//        double[] testArray = {8, 9, 5, 10, 7, 6, 11};
//        int index = findIndexOfMinValue(testArray, 3);    // find index of min value starting at index 3
//        System.out.println( index );                      // returns 5 (i.e. the index of the number 6)

//        double[] testArray = {8, 9, 5, 10, 7, 6, 11};
//        int index = findIndexOfMinValue(testArray, 0);    // find index of min value starting at index 0
//        System.out.println( index );                      // returns 2 (i.e. the index of the number 5)
//        
        
        //        double[] testArray = {3, 5, 9, 8, 1};
//        bubbleSort(testArray);
//        printArray(testArray);
//        double[] testArray = {3, 4, 9, 1, 6, 8, 2};
//        selectionSort(testArray);
//        printArray(testArray);            // displays 1 2 3 4 6 8 9
                
//        double[] testArray = {5, 7, 8, 9, 6};
//        pushLeft(testArray, 4);            // push item at index 4 (i.e. 6) to the left
//        printArray(testArray);              // displays 5 6 7 8 9

//        double[] testArray = {6, 7, 9, 5, 8};
//        pushLeft(testArray, 3);            // push item at index 3 (i.e. 5) to the left
//        printArray(testArray);              // displays 5 6 7 9 8   
                      
//        double[] testArray = {5, 7, 9, 6, 8};
//        insertionSort(testArray);
//        printArray(testArray);            // displays 5 6 7 8 9
        
//        double[] testArray = {6, 9, 7, 2, 1};
//        insertionSort(testArray);
//        printArray(testArray); 
                
//        testSortAlgorithms( 2000, 14000, 3000, 'i' );
//        testSortAlgorithms( 2000, 14000, 3000, 'r' );
//        testSortAlgorithms( 2000, 14000, 3000, 'd' );  
        
//        double[] testArray = {};
//        boolean swapped = bubbleRun(testArray, 4);    
//        printArray(testArray);                        
//        System.out.println( "Did it swap: " + swapped ); 
        
//        double[] testArray = {1};
//        boolean swapped = bubbleRun(testArray, 0);    
//        printArray(testArray);                        
//        System.out.println( "Did it swap: " + swapped ); 
        
//        double[] testArray = { 1, 2, 3, 4, 5 };
//        boolean swapped = bubbleRun(testArray, 4);    // examines the first 4 pairs; returns false
//        printArray(testArray);                        // displays 1 2 3 4 5
//        System.out.println( "Did it swap: " + swapped );    // displays false
//        
//        double[] testArray = { 5, 4, 3, 2, 1 };
//        boolean swapped = bubbleRun(testArray, 4);    
//        printArray(testArray);                        
//        System.out.println( "Did it swap: " + swapped ); 
        //        double[] testArray = {1};
//        bubbleSort(testArray);
//        printArray(testArray);
        
//        double[] testArray = {};
//        bubbleSort(testArray);
//        printArray(testArray);
        
//        double[] testArray = {5, 2, 1, 3, 4};
//        bubbleSort(testArray);
//        printArray(testArray);                         // displays 1 2 3 4 5 
                
//        double[] testArray = {1, 2, 4, 3, 5};
//        bubbleSort(testArray);
//        printArray(testArray);
        
        //        double[] testArray = {};
//        int index = findIndexOfMinValue(testArray, 0);
//        System.out.println( index );  
//        
//        double[] testArray = {1};
//        int index = findIndexOfMinValue(testArray, 0);
//        System.out.println( index ); 
        
//        double[] testArray = {};
//        int index = findIndexOfMinValue(testArray, 0);
//        System.out.println( index ); 
        
//        double[] testArray = {1,2,3,4,5,6};
//        int index = findIndexOfMinValue(testArray, 5);
//        System.out.println( index );
        
//        double[] testArray = {7,6,5,4,3,2,1,0};
//        int index = findIndexOfMinValue(testArray, 0);
//        System.out.println( index );
        
        //        double[] testArray = {1};
//        selectionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {};
//        selectionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {0,1,2,3,4,5,6};
//        selectionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {6,5,4,3,2,1,0};
//        selectionSort(testArray);
//        printArray(testArray);
                
        //        double[] testArray = {1};
//        pushLeft(testArray, 0);            
//        printArray(testArray); 
        
//        double[] testArray = {};
//        pushLeft(testArray, 0);            
//        printArray(testArray); 
        
//        double[] testArray = {1,2,3,4,5,6,7};
//        pushLeft(testArray, 0);            
//        printArray(testArray); 
        
//        double[] testArray = {6,5,4,3,2,1};
//        pushLeft(testArray, 5);            
//        printArray(testArray);  
        
        //        double[] testArray = {};
//        insertionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {1};
//        insertionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {2,3,4,5,6,7,8};
//        insertionSort(testArray);
//        printArray(testArray); 
        
//        double[] testArray = {8,6,5,4,3,1};
//        insertionSort(testArray);
//        printArray(testArray); 
    }
}