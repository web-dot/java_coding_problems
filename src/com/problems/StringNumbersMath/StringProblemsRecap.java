package com.problems.StringNumbersMath;

import java.util.HashMap;
import java.util.Map;

public class StringProblemsRecap {
	
	// count duplicate character in a string
	public static int countDuplicates(String str) {
		char[] carr = str.toCharArray();
		int count = 0;
		Map<Character, Integer> cmap = new HashMap<>();
		for(int i=0; i<carr.length; i++) {
			char ch = carr[i];
			cmap.compute(ch, (k,v) -> (v==null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : cmap.entrySet()) {
			if(entry.getValue() > 1) {
				count++;
			}
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(countDuplicates("programming"));
	}
}
