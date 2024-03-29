package com.problems.StringNumbersMath;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
	
	//first non-repeating char
	public static Character findFirstNonRepeating(String str) {
		Map<Character, Integer> chars = new LinkedHashMap<>();
		for(char ch : str.toCharArray()) {
			chars.compute(ch, (k,v) -> (v == null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return Character.MIN_VALUE;
	}
	
	public static Character findFirstNonRepeatingCharacter(String str) {
		Map<Character, Integer> chars = new LinkedHashMap<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			chars.compute(ch, (k, v) -> v == null ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return Character.MIN_VALUE;
	}
	
	// count occurrence of a character
	public static int countOccurence(String str, char ch) {
		Map<Character, Integer> chars = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char character = str.charAt(i);
			chars.compute(character, (k, v) -> (v == null) ? 1 : ++v);
		}
		int count = 0;
		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if(entry.getKey() == ch) {
				count = entry.getValue();
			}
		}
		return count;
	}
	
	// reverse a string
	private static final String WHITESPACE = " ";
	public static String reverseString(String str) {
		String[] words = str.split(WHITESPACE);
		StringBuilder reverseString = new StringBuilder();
		for(String word : words) {
			StringBuilder reverseWord = new StringBuilder();
			for(int i= word.length()-1; i>=0; i--) {
				reverseWord.append(word.charAt(i));
			}
			reverseString.append(reverseWord).append(WHITESPACE);
		}
		return reverseString.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverseString("i am a computer programmer"));
	}
}
