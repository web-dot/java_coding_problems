package com.problems.StringNumbersMath;

public class ArrayProblems {
	
	/**
	 * Find max(X1, ... , Xn)
	 * */
	public static double findMaxNew(double[] nums) {
		int n = nums.length-1;
		double m = nums[n];
		int k = n-1;
		
		while(k!=0) {
			if(nums[k] > m) {
				m = nums[k];
			}
			else
				k--;
		}
		return m;
	}
	
	public static double findMaxOld(double[] nums) {
		double m = nums[0];
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > m) {
				m = nums[i];
			}
		}
		return m;
	}
	
	public static void main(String[] args) {
		
		double[] a = new double[] {2.30, 7.1, 4.0, 5.9};
		System.out.println(findMaxNew(a));
		System.out.println(findMaxOld(a));
	}
}
