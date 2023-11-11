package com.problems.StringNumbersMath;

import java.util.Collections;
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
	
	// return the index of the first non repeating character
	public static int firstUniqueChar(String s) {
		if(s.length() == 1) {
			return 0;
		}
		if(s.isEmpty()) {
			return -1;
		}
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			countMap.compute(s.indexOf(ch), (k, v) -> (v == null) ? 1 : ++v);
		}
		for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}
	
	// count occurrence of certain character
	public static int countOccurenceOfChar(String s, char c) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == c) {
				count++;
			}
		}
		return count;
	}
	
	// remove duplicate characters from a string
	public static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(sb.indexOf(String.valueOf(ch)) == -1) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	// remove a given character from string
	public static String removeGivenChar(String s, char c) {
		StringBuilder sb = new StringBuilder();
		for(char ch : s.toCharArray()) {
			if(ch != c) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	// find character with most appearances
	public static char maxOccuringChar(String s) {
		Map<Character, Integer> counter = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(!Character.isWhitespace(ch)) {
				counter.compute(ch, (k, v) -> (v == null) ? 1 : v + 1);
			}
		}
		int maxOccurance = Collections.max(counter.values());
		char maxChar = Character.MIN_VALUE;
		for(Map.Entry<Character, Integer> entry : counter.entrySet()) {
			if(entry.getValue() == maxOccurance) {
				maxChar = entry.getKey();
			}
		}
		return maxChar;
	}
	
	// reverse a string in place with O(1) memory
	public static String reverseInPlace(char[] s) {
		int p1 = 0;
		int p2 = s.length-1;
		while(p1 < p2) {
			char temp = ' ';
			temp = s[p1];
			s[p1] = s[p2];
			s[p2] = temp;
			
			p1++;
			p2--;
		}
		return String.valueOf(s);
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverseInPlace(new char[] {'c', 'o', 'd', 'e'}));
//		System.out.println(maxOccuringChar("programmingg"));
//		System.out.println(removeGivenChar("madam", 'm'));
//		System.out.println(removeDuplicates("mm"));
//		System.out.println(countOccurenceOfChar("program", 'g'));
//		System.out.println(firstUniqueChar("madam"));
//		System.out.println(findFirstNonReapeatingChar("madamca"));
	}
}
