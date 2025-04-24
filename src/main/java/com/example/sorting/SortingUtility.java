package com.example.sorting;

public class SortingUtility {

    //copilot instruction: Implement Gnome Sort
    public static <T extends Comparable<T>> void gnomeSort(T[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int pos = 0;

        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }

    //copilot instruction: Implement Cocktail Shaker Sort
    public static <T extends Comparable<T>> void cocktailShakerSort(T[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        boolean swapped;
        int start = 0;
        int end = A.length - 1;

        do {
            swapped = false;

            // Forward pass
            for (int i = start; i < end; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
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
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1);
                    swapped = true;
                }
            }

            start++;
        } while (swapped);
    }

    //copilot instruction: Implement Shell Sort
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        if (a == null || a.length == 0) {
            return;
        }

        int n = a.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Perform a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for a[i] is found
                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }

                // Put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





