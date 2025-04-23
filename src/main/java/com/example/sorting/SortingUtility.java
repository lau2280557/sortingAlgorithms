package com.example.sorting;

public class SortingUtility {

    //copilot instruction: Implement Gnome Sort
    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        int index = 0;

        while (index < data.length) {
            if (index == 0 || data[index].compareTo(data[index - 1]) >= 0) {
                index++;
            } else {
                swap(data, index, index - 1);
                index--;
            }
        }
    }

    //copilot instruction: Implement Cocktail Shaker Sort
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        boolean swapped;
        int start = 0;
        int end = data.length - 1;

        do {
            swapped = false;

            // Forward pass
            for (int i = start; i < end; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            // Backward pass
            for (int i = end - 1; i >= start; i--) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    swap(data, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        } while (swapped);
    }

    //copilot instruction: Implement Shell Sort
    public static <T extends Comparable<T>> void shellSort(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        int n = data.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                T temp = data[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for data[i] is found
                for (j = i; j >= gap && data[j - gap].compareTo(temp) > 0; j -= gap) {
                    data[j] = data[j - gap];
                }

                // Put temp (the original data[i]) in its correct location
                data[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





