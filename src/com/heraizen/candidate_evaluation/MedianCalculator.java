package com.heraizen.candidate_evaluation;

import java.util.Arrays;
import java.util.Scanner;

public class MedianCalculator {
	public static int[] sort(int arr[]){
		for(int i=0;i<arr.length-1;i++){
		for(int j=i+1;j<arr.length;j++){
		if(arr[i]>arr[j]){
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
		}
		}
		}
		return arr;
		}
		public static float median(int arr[],int l){
		float res =0;
		int arr1[]=sort(arr);
		System.out.println(Arrays.toString(arr1));
		if(l%2==0){
		res=(float)arr1[(l/2)-1]+((float)arr1[l/2]-(float)arr1[(l/2)-1])/2;
		}else{
		res=(float)arr1[l/2];
		}return res;
		}
		

	  public static void main(String[] args) {
		  int[] arr = {1,3,7,9};
		  System.out.println(median(arr, 5));
	  }
}

	



