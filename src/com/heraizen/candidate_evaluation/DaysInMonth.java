package com.heraizen.candidate_evaluation;

import java.util.Scanner;

class DaysInMonth {
	 public static int daysInMonth(int month,int year)
	 {
		 if(((year%100==0)&&(year%400==0) || (year%100!=0 && year%4==0)) && month==2)
		 {
			 return 29;
		 }
        else if(month==1 || month ==3 || month==5 || month==7 || month==8 || month==10 || month==12)
        {
		 return 31;
        }
        else if(month==4 || month ==6 || month==9 || month==11)
        {
       	 return 30;
        }
        else
       	 return 28;
	 }
   public static void main(String[] args) {

Scanner s = new Scanner(System.in) ;
System.out.println("Enter ar Year  : ");
int year = s.nextInt();

      if (year % 4 == 0) {
        if (year % 100 == 0) 
         {
              if(year % 400 == 0) 
                {
                   System.out.println("Leap Year");
                 }
               else 
                {
                       System.out.println("Not a Leap Year");
                }
         }
         else 
         {
                 System.out.println("Leap Year");    
         }
     }
     else 
    {
          System.out.println("Not a Leap Year");  
    }
  }
	}


