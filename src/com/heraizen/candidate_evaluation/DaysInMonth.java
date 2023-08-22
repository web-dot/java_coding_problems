package com.heraizen.candidate_evaluation;

import java.util.Scanner;

class DaysInMonth {
	public static int daysInMonth(int month,int year)
	{
		if((month==2)&&((year%4==0)||((year%100==0) && (year%400==0)))){
			return 29;
		}
		else if (month==2) {
			return 28;
		}
		else if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
			return 31;
		}
		else {
			return 30;
		}
	}

	public static void main(String[] args) {
		System.out.println(daysInMonth(8, 2023));
	}
}
