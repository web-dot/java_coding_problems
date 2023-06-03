package com.problems.StringNumbersMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
	
	
	/**
	 * 3. Reversing a string
	 * */
	private static final String WHITESPACE = " ";
	public static String reverseWord(String str) {
		String[] words = str.split(WHITESPACE);
		StringBuilder reverseString = new StringBuilder();
		for(String word: words) {
			StringBuilder reverseWord = new StringBuilder();
			for(int i=word.length()-1; i>=0; i--) {
				reverseWord.append(word.charAt(i));
			}
			reverseString.append(reverseWord).append(WHITESPACE);
		}
		return reverseString.toString();
	}
	
	
	// obtaining same result in functional style
	
	/**
	 * uses regular expressions and stream to split the input string into 
	 * substrings, then reverse each substring using StringBuilder, and
	 * then joining the reversed substrings back together with spaces in between
	 * */
	private static final Pattern PATTERN = Pattern.compile(" +");
	private static String reverseStringInFunctional(String str) {
		return PATTERN.splitAsStream(str)
				.map(w -> new StringBuilder(w).reverse())
				.collect(Collectors.joining(" "));
	}
	
	/**
	 * 4. checking whether a string contains only digits
	 * 
	 * */
	public static boolean containsOnlyDigits(String str) {
		for(int i=0; i<str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	
	// using streams
	public static boolean stringIsDigits(String str) {
		return str.chars().anyMatch(n -> !Character.isDigit(n));
	}
	
	// using stream.matches()
	public static boolean stringIsDigitsMatches(String str) {
		return str.matches("[0-9]+");
	}
	
	
	/**
	 * 5. Counting vowels and consonants
	 * */
	private static final Set<Character> allVowels = new HashSet(Arrays.asList('a','e','i','o','u'));
	public static List<Integer> countVowelsAndConsonants(String str){
		List<Integer> list = new ArrayList<>();
		str = str.toLowerCase();
		int vowels = 0;
		int consonants = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(allVowels.contains(ch)) {
				vowels++;
			}
			else if(ch >= 'a' && ch <= 'z') {
				consonants++;
			}
		}
		list.add(vowels);
		list.add(consonants);
		return list;
	}
	
	// using streams
	public static List<Long> countVandC(String str){
		List<Long> list = new ArrayList<>();
		str = str.toLowerCase();
		long vowels = str.chars()
		.filter(c -> allVowels.contains((char)c))
		.count();
		long consonants = str.chars()
				.filter(c -> !allVowels.contains((char)c))
				.count();
		list.add(vowels);
		list.add(consonants);
		return list;
	}
			
	public static void main(String[] args) {
		System.out.println(countVandC("hello"));
		
		/**
		 * Notes
		 * */
		
		// problem 3
		Pattern p = Pattern.compile("-");
		String schedule = "MUMBAI-17:50";
		Stream<String> str = p.splitAsStream(schedule);
		str.forEach(System.out::println);
		
		
		
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
