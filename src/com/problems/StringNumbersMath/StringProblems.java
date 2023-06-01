package com.problems.StringNumbersMath;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProblems {
	
	/**
	 * 1. counting duplicate characters
	 * */
	
	public static Map<Character, Integer> countDuplicatesChars(String str){
		Map<Character, Integer> result = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			result.compute(c,  (k, v) -> (v == null) ? 1 : ++v);
		}
		return result;
	}
	
	// using stream
	// Collectors.counting -> downstream collector
	public static Map<Character, Long> countDuplicateCharsUsingStream(String str){
		Map<Character, Long> result = str.chars()
		.mapToObj(c ->(char)c)
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return result;
					
	/**
	 * the mapToObj method calls the apply method of the IntFunction<R> functional interface,
	 *  providing the current int value from the stream as the argument to the lambda expression
	 * */
	/*
	str.chars()
	.mapToObj(new IntFunction<Character>() {
		@Override
		public Character apply(int value) {
			return (char)value;
		}
	});
	*/
		
	}
	
	/**
	 * 2. Finding the first non-reapeated character
	 * */
	
	// single traversal
	
	private static final int EXTENDED_ASCII_CODES = 256;
	
	public static char firstNonRepeatedChar(String str) {
		int[] flags = new int[EXTENDED_ASCII_CODES];
		for(int i = 0; i<flags.length; i++) {
			flags[i] = -1;
		}
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(flags[c] == -1) {
				flags[c] = i;
			}
			else {
				flags[c] = -2;
			}
		}
		int position = Integer.MAX_VALUE;
		for(int i=0; i<flags.length; i++) {
			if(flags[i] >= 0) {
				position = Math.min(position, flags[i]);
			}
		}
		return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
	}
	
	/**
	 * the second approach consists of looping through the string for each character,
	 * every second occurance(duplicate) will break the loop, jumps to the next character
	 * and repeats the algorithm
	 * */
	public static char findFirstNonRepeatingChar(String str) {
		Map<Character, Integer> chars = new LinkedHashMap<>();
		for(char ch : str.toCharArray()) {
			chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return Character.MIN_VALUE;
	}
		
			
	public static void main(String[] args) {
		System.out.println(findFirstNonRepeatingChar("assistance"));
		
		/**
		 * Notes
		 * */
		
		// problem 1
		Map<Character, Integer> map = new HashMap<>();
		char key = 'a';
		int value = 1;
		
		// using map.compute()
		map.compute(key, (k, v) -> (v == null) ? value : v + value);
		
		// using map.contains()
		if(map.containsKey(key)) {
			map.put(key, map.get(key) + value);
		}
		else {
			map.put(key, 1);
		}
		
		// string.chars()
		String s = "Hello";
		IntStream charStream = s.chars();
//		charStream.forEach(System.out::println);
//		List<Character> charList = charStream.mapToObj(c -> (char)c).collect(Collectors.toList()); // IllegalStateException
//		System.out.println(charList);
	}
	

}
