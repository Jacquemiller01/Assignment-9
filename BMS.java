import java.util.Arrays;

public class BMS {

    public static void main(String[] args) {
        Integer[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);
        System.out.println("Bubble sorted array: " + Arrays.toString(arr));

        Integer[] arr2 = { 64, 34, 25, 12, 22, 11, 90 };
        mergeSort(arr2);
        System.out.println("Merge sorted array: " + Arrays.toString(arr2));
    }

    // Bubble Sort using Java Generics
    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
            if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Merge Sort using Java Generics
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            T[] leftArray = Arrays.copyOfRange(array, 0, mid);
            T[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            mergeSort(leftArray);
            mergeSort(rightArray);

            int i = 0;
            int j = 0;
            int k = 0;
            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i].compareTo(rightArray[j]) < 0) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                } 
                k++;
            }
            while (i < leftArray.length) {
                array[k] = leftArray[i];
                i++;
                k++;
            }
            while (j < rightArray.length) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

}