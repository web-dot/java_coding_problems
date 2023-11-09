package com.problems.StringNumbersMath;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringBasicProblems {
	
	// count duplicate characters
	public static int countDuplicates(String str) {
		Map<Character, Integer> result = new HashMap<>();
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : result.entrySet()) {
			if(entry.getValue() > 1) {
				count++;
			}
		}
		return count;
	}
	
	// find first non repeating character
	public static char findFirstNonReapeatingChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(char c : str.toCharArray()) {
			map.compute(c, (k, v) -> (v==null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return Character.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		
	}
}
