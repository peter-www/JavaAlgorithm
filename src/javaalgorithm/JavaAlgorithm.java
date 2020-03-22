/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithm;

import java.util.Scanner;
/**
 *
 * @author peter
 */
public class JavaAlgorithm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[5];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
           System.out.print(arr[i] + " ");
        }
        System.out.println(';');
        //quickSort(arr, 1, n-1);
        //BubbleSort(arr, n);
        //selectionSort(arr, 0);
        mergeSort(arr);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    
    private static void heapSort(int[] arr){
        
    }
    private static void adjustHeap(int[] arr){
        
    }
    private static void swap(int[] arr){
        
    }
    
    //  start mergeSort
    private static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        split(arr, 0, arr.length -1, temp);
    }
    
    private static void split(int[] arr, int low, int high, int[] temp){
        if (low < high){
            int mid = (low+high)/2;
            split(arr, low, mid, temp);
            split(arr, mid+1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }

    private static void merge(int[] arr,int low,int mid,int high,int[] temp){

        int p = 0;
        int i = low, j = mid+1;
        
        while(i <= mid && j<=high){
            if(arr[i] < arr[j]) {
                temp[p] = arr[i];
                p++;
                i++;
            }
            else{
                temp[p] = arr[j];
                p++;
                j++;
            }
        }
        
        while(i<=mid){
            temp[p] = arr[i];
            p++;
            i++;
        }
        
        while(j<=high){
            temp[p] = arr[j];
            p++;
            j++;
        }
        
        for (int k=0; k<p; k++){
            arr[low+k] = temp[k];
        }
    }
    //end mergeSort
    
    private static void insertionSort(int[] arr){
        for (int i=1; i<arr.length; i++){
            int temp = arr[i];
            int j;
            for (j= i-1; j>0;){
                if (arr[j] < temp) break;
                j--;
            }
            arr[j] = temp;
        }
    }
    
    private static void selectionSort(int[] arr, int start){
        
        if (arr !=  null && start < arr.length -1){
            
            int min = arr[start];
            int min_index = start;
            for (int i = start+1; i<arr.length; i++){
                if (min > arr[i]){
                    min = arr[i];
                    min_index = i;
                }
            }
            arr[min_index] = arr[start];
            arr[start] =min;
            selectionSort(arr, start+1);
        }
    }
    
    private static void BubbleSort(int[] arr, int end){
        if (end > 1){
            for (int i=0; i<end-1; i++){
                if (arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            BubbleSort(arr, end-1);
        } 
        
    }
    
    private static void quickSort(int[] arr, int left, int right){
        
      
        if (right > left){
            int start = left;
            int end = right;
            int i = arr[left];
            
            while(right > left){
                while (left < right && arr[right]>=arr[i]){
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left]<=arr[i]){
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = i;
            quickSort(arr, start, left-1);
            quickSort(arr, left+1, end);
        }

    }
}
