package com.heraizen.candidate_evaluation;

import java.util.Arrays;
import java.util.Scanner;

public class MedianCalculator {
	private static float median(int[] a) {
		 int n = a.length;

	     if (n % 2 == 1) {
	       
	         return a[n / 2];
	     } else {
	        
	         int middle1 = a[n / 2 - 1];
	         int middle2 = a[n / 2];
	         return  (float) ((middle1 + middle2) / 2.0);
	     }
	}

	  public static void main(String[] args) {
		  int[] arr = {1,6,2,7,9};
		  System.out.println(median(arr));
	  }
}

	



