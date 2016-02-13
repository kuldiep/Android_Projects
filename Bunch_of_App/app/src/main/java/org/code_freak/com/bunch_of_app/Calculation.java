package org.code_freak.com.bunch_of_app;

/**
 * Created by Kuldiep on 2/12/2016.
 */
public class Calculation {
    public static int div(int num1, int num2) throws ArithmeticException {
        return num1 / num2;
    }


    public static void bubbleSort(int array[]) {
        int n = array.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1; if (array[i] > array[k]) {
                    swapNumbers(i, k, array);
                }
            }
        }
    }
    public static int[] doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    private static void swapNumbers(int i, int j, int[] array) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] generateRandomArray(int howMany){
        int[] array = new int[howMany];
        for(int i=0; i<array.length; i++){
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    public static int[] generateEvenNumbers(int from, int to){
        int[] array = new int[((to-from)/2)+1];
        int index = 0;

        for(int i=from; i<=to; i++){
            if(i%2== 0){
                array[index] = i;
                index++;
            }
        }
        return array;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static int[] generateNaturalArray(int howMany){
        int[] array = new int[howMany];
        int index = 0;
        for(int i=0; i<array.length; i++){
            array[index++] = i + 1;
        }
        return array;
    }


    public static int add(int num1, int num2){
        int sum = num1 + num2;
        return sum;
    }

    public static boolean isEven(int num){
        if(num%2 == 0)
            return true;
        else
            return false;
    }
}
