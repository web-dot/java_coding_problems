package com.heraizen.candidate_evaluation;

import java.util.Scanner;

public class FizzBuzz {
	static String toFizzBuzz(int num) {
		if ((num % 3 == 0) && (num % 5 == 0)) {
			return "Fizzbuzz";

		} else if (num % 3 == 0) {
			return "Fizz";
		} else if (num % 5 == 0) {
			return "Buzz";
		} else {
			return "" + num;
		}
		}



	
	public static void main(String[] args) {
		System.out.println(toFizzBuzz(150));
	}
}

