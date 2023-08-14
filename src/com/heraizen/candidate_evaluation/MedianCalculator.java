package com.heraizen.candidate_evaluation;

import java.util.Arrays;
import java.util.Scanner;

public class MedianCalculator {
	public static int[] sorting(int Arr[])
	{
		for(int i=0;i<Arr.length-1;i++)
		{
           for (int j = i+1; j < Arr.length; j++) 
           {
   			if(Arr[i]>Arr[j])
   			{
   				int temp=Arr[j];
   				 Arr[j]=Arr[i];
   				  Arr[i]=temp;
   			}
		   }
		}
		return Arr;
	}
	  public static float median(int Arr[],int len)
	  {
		  float res=0;
		  int Arr1[]=sorting(Arr);
		  if(len%2==0)
		  {
			  res=(float)Arr1[(len/2)-1]+((float)Arr1[len/2]-(float)Arr1[(len/2)-1])/2;
		  }
		  else
		  {
			  res=(float)Arr1[len/2];
		  }
		  return res;
	  }
	  
	  public static void main(String[] args) {
		  int[] arr = {2,5,7,1};
		  System.out.println(median(arr, arr.length));
	  }
}

	



