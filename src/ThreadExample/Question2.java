package ThreadExample;

import java.util.Random;

public class Question2 {
    
    private static int [] randomArr(){
        int randomNums [] = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand=random.nextInt(100);
            randomNums[i]=rand;
        }
        return randomNums;
    }
    
    private static void printArr(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void main(String[] args) {
        int [] randomNumbersBubble = randomArr();
        // First state of array
        System.out.println("For bubble sortArray");
        printArr(randomNumbersBubble);
        long startTime = System.nanoTime();
        Context context = new Context(new BubbleSort());
        context.executeStrategy(randomNumbersBubble);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("After bubble sort");
        // Final state of array
        printArr(randomNumbersBubble);
        System.out.println("Execution time for bubble sort: " + timeElapsed + " ns");
        
        
        int [] randomNumbersQuick = randomArr();
        System.out.println("Array For Quick sort: ");
        printArr(randomNumbersQuick);
        startTime = System.nanoTime();
        context = new Context(new QuickSort());
        context.executeStrategy(randomNumbersQuick);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("After quick sort: ");
        printArr(randomNumbersQuick);
        System.out.println("Execution time for quick sort: " + timeElapsed + " ns");
        
        int [] randomNumbersInsertion = randomArr();
        System.out.println("Array For Insertion sort: ");
        printArr(randomNumbersInsertion);
        startTime = System.nanoTime();
        context = new Context(new InsertionSort());
        context.executeStrategy(randomNumbersInsertion);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.println("After Insertion sort: ");
        printArr(randomNumbersInsertion);
        System.out.println("Execution time for quick sort: " + timeElapsed + " ns");
    }
}
