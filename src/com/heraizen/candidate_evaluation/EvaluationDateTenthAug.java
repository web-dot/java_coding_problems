package com.heraizen.candidate_evaluation;

import java.util.Scanner;
import java.util.Arrays;

public class EvaluationDateTenthAug {

	// Nagarjun T S

	public static String fizzBuzz(int number) {
		if (number % 3 == 0 && number % 5 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0) {
			return "Fizz";
		} else if (number % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(number);
		}
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public static int getDaysInMonth(int year, int month) {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Invalid month. Month must be between 1 and 12.");
		}

		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 2 && isLeapYear(year)) {
			return 29;
		} else {
			return daysInMonth[month - 1];
		}
	}

	public static double calculateMedian(int[] array) {
		Arrays.sort(array);

		int n = array.length;
		if (n % 2 == 0) {
			int middle1 = array[n / 2 - 1];
			int middle2 = array[n / 2];
			return (middle1 + middle2) / 2.0;
		} else {
			return array[n / 2];
		}
	}
	
	public static float Median(int A[], int B[], int n, int m) {
		int i = 0;
		int j = 0;
		int count;
		int m1 = -1, m2 = -1;

		if ((m + n) % 2 == 1) {
			for (count = 0; count <= (n + m) / 2; count++) {
				if (i != n && j != m) {
					m1 = (A[i] > B[j]) ? B[j++] : A[i++];
				} else if (i < n) {
					m1 = A[i++];
				} else {
					m1 = B[j++];
				}
			}
			return m1;
		} else {
			for (count = 0; count <= (n + m) / 2; count++) {
				m2 = m1;
				if (i != n && j != m) {
					m1 = (A[i] > B[j]) ? B[j++] : A[i++];
				} else if (i < n) {
					m1 = A[i++];
				} else {
					m1 = B[j++];
				}
			}
			return (m1 + m2) / 2;
		}
	}



	

		static double calculateMedian1(int[] input1) {
			 
			        Arrays.sort(input1);
			        int length = input1.length;
			        
			        if (length % 2 == 0) {
			            int middleIndex1 = length / 2 - 1;
			            int middleIndex2 = length / 2;
			            return (input1[middleIndex1] + input1[middleIndex2]) / 2.0;
			        } else {
			            int middleIndex = length / 2;
			            return input1[middleIndex];
			        }
			    }
			
		
	

	


	public static void main(String[] args) {
		  int[] input1 = {1, 3, 2, 5, 4};
          double median1 = calculateMedian1(input1);
          System.out.println("Median of input1: "+ median1);

          int[] input2 = {1, 3, 2, 5, 4, 6};
          double median2 = calculateMedian1(input2);
          System.out.println("Median of input2: " + median2);


		    }

		

	}

