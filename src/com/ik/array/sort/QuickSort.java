package com.ik.array.sort;

public class QuickSort {
    private int partition(int[] arr, int start, int end, int pindex){
        int pivot = arr[pindex];
        int i=start;
        int j=end;
        while(i<=j){
            while(arr[i] < pivot && i<=end){
                i++;
            }
            while(arr[j] > pivot && j>start){
                j--;
            }
            if(i <= j){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right, left);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public void sort(int[] arr, int start, int end){
        if(start>=end) return;
        int pivotPos = partition(arr, start, end, start);
        sort(arr, start, pivotPos - 1);
        sort(arr, pivotPos, end);
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]){
        QuickSort qs = new QuickSort();
        int[] arr = {12, 4, 5, 72, 8, 44, 2, 3,4, 67,8,37, 65, 93, 55, 3, 44};
        qs.printArray(arr);
        qs.quickSort(arr, 0, arr.length-1);
        qs.printArray(arr);

        System.out.println();

        int[] arr1 = {12, 4, 5, 72, 8, 44, 2, 3,4, 67,8,37, 65, 93, 55, 3, 44};
        qs.printArray(arr1);
        qs.sort(arr1, 0, arr1.length-1);
        qs.printArray(arr1);

    }


    private void printArray(int[] arr){
        System.out.println();
        System.out.print("{");
        for(int a: arr){
            System.out.print(a +",");
        }
        System.out.print("}");
    }

}

