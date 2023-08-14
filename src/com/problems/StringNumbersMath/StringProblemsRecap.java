package com.problems.StringNumbersMath;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
	
	
	// count duplicate characters
	public static Map<Character, Integer> countDuplicateChars(String str){
		char[] carr = str.toCharArray();
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<carr.length; i++) {
			char ch = carr[i];
			result.compute(ch, (k, v) -> (v==null) ? 1 : ++v);
		}
		return result;
	}
	
	// count duplicates using stream
	public static Map<Character, Long> countDuplicatesUsingStream(String str){
		return str.chars()
		.mapToObj(c -> (char)c)
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
	}
	
	
	public static void main(String[] args) {
		System.out.println(countDuplicatesUsingStream("programming"));
	}
}
