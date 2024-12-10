package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] array) {
        int pos = 0;
        while (pos < array.length) {
            if (pos == 0 || array[pos].compareTo(array[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(array, pos, pos - 1);
                pos--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            for (int i = array.length - 2; i >= 0; i--) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }



    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        for (int gap : gaps) {
            for (int i = gap; i < array.length; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





