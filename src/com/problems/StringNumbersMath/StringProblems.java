package com.problems.StringNumbersMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringProblems {
	
	/**
	 * 1. COUNT DUPLICATE CHARS
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
	 * 2. FIND FIRST NON-REPEATING CHAR
	 * */
	
	// single traversal
	
	private static final int EXTENDED_ASCII_CODES = 256;
	
	public static char firstNonRepeatedChar(String str) {
		int[] arr = new int[EXTENDED_ASCII_CODES];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = -1;
		}
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(arr[c] == -1) {
				arr[c] = i;
			}
			else {
				arr[c] = -2;
			}
		}
		int position = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 0) {
				position = Math.min(position, arr[i]);
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
	 * 3. COUNT OCCURANCE OF CERTAIN CHARACTER
	 * */
	public static int findOccurance(String str, char c) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for(char ch : str.toCharArray()) {
			map.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getKey() == c) {
				count = entry.getValue();
			}
		}
		return count;
	}
	
	
	/**
	 * 3. REVERSE A STRING
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
	 * 4. STRING CONTAINS ONLY DIGITS
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
	 * 5. COUNT VOWELS AND CONSONANTS
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
	
	/**
	 * 6. REMOVE WHITESPACE
	 * */
	public static String removeWhites(String str) {
		return str.replaceAll("\\s", "");
	}
	
	/**
	 * 7. JOINING MULTIPLE STRINGS WITH A DELIMETER
	 * */
	public static String joinWithDelimeter(char deleimeter, String str) {
		String[] arr = str.split(" ");
		return Arrays.stream(arr)
				.collect(Collectors.joining(String.valueOf(deleimeter)));
	}
	
	
	/**
	 * 8. GENERATING ALL PERMUTATIONS
	 * 
	 * 					ABC
	 * 		ABC			BAC			CBA
	 * 	ABC 	ACB	BAC		BCA	CBA		CAB
	 * 
	 * */
//	public static void permuteAndPrint(String str) {
//		permuteAndPrint("", str);
//	}
//	
//	private static void permuteAndPrint(String prefix, String str) {
//		int n = str.length();
//		if() {}
//	}
	
	
	/**
	 * 11. IF A STRING IS PALINDROME
	 * */
	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length()-1;
		while(right > left) {
			if(str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	
	/**
	 * 12. REMOVING DUPLICATE CHARACTERS
	 * */
	
	// indexOf - returns the index within the given string the first occurrence of specified string 
	/**
	 * loop over the given string and append the chars one at a time in a StringBuilder if the 
	 * indexOf of the character returns -1
	 * */
	public static String removeDuplicates(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(sb.indexOf(String.valueOf(ch)) == -1) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * using HashSet and StringBuilder :
	 * HashSet removes duplicates and StringBuilder stores the resulting string.
	 * If HashSet.add() returns true, then we append the char in string-builder
	 * */
	public static String removeDuplicatesUsingHashSet(String str) {
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		char[] charArray = str.toCharArray();
		for(char ch : charArray) {
			if(set.add(String.valueOf(ch)) == true) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	/**
	 * using streams
	 * */
	public static String removeDuplicatesWithStreams(String str) {
		return Arrays.asList(str.split(""))
				.stream()
				.distinct()
				.collect(Collectors.joining());
	}
	
	
	/**
	 * 13: REMOVING A GIVEN CHAR
	 * */
	public static String removeCharUsingRegEx(String str, char ch) {
		return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
	}
	
	// without regular expressions
	public static String removeChar(String str, char c) {
		StringBuilder sb = new StringBuilder();
		char[] charArray = str.toCharArray();
		for(char ch : charArray) {
			if(ch != c) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	// using Java8 streams
	public static String removeCharsWithStreams(String str, char ch) {
		return str.chars()
				.filter(c -> c != ch)
				.mapToObj(c -> String.valueOf((char)c))
				.collect(Collectors.joining());
	}
	
	/**
	 * 13. FINDING CHARACTER WITH MOST APPEARANCES
	 * 
	 * -> if there are multiple characters with max appearance
	 * 	  should i return any one of the results or i need to 
	 *    return a key-pair of all the max occurring chars
	 * 
	 * */
	public static Map<Character, Integer> maxOccuranceCharacter(String str){
		Map<Character, Integer> counter = new HashMap<>();
		char[] chStr = str.toCharArray();
		for(int i=0; i<chStr.length; i++) {
			char currentCh = chStr[i];
			if(!Character.isWhitespace(currentCh)) { // ignore spaces
				Integer chCount = counter.get(currentCh);
				if(chCount == null) {
					counter.put(currentCh, 1);
				}
				else {
					counter.put(currentCh, ++chCount);
				}
			}
		}
		int maxOccurances = Collections.max(counter.values());
		char maxCharacter = Character.MIN_VALUE;
		for(Map.Entry<Character, Integer> entry : counter.entrySet()) {
			if(entry.getValue() == maxOccurances) {
				maxCharacter = entry.getKey();
			}
		}
		Map<Character, Integer> result = new HashMap<>();
		result.put(maxCharacter, maxOccurances);
		return result;
	}
	
	
	// solution using ASCII codes
	public static Map<Character, Integer> maxOccuranceUsingASCII(String str){
		int maxOccurance = -1;
		char maxChar = Character.MIN_VALUE;
		char[] chStr = str.toCharArray();
		int[] asciiCodes = new int[EXTENDED_ASCII_CODES];
		
		for(int i=0; i<chStr.length; i++) {
			char currentCh = chStr[i];
			if(!Character.isWhitespace(currentCh)) {
				int code = (int)currentCh;
				asciiCodes[code]++;
				if(asciiCodes[code] > maxOccurance) {
					maxOccurance = asciiCodes[code];
					maxChar = currentCh;
				}
			}
		}
		Map<Character, Integer> result = new HashMap<>();
		result.put(maxChar, maxOccurance);
		return result;
	}
	
	// solution using streams api
//	public static Map<Character, Integer> maxOccuranceUsingStreams(String str){
//		Map<Character, Integer> result = new HashMap<>();
//		return str.chars() 
//				.filter(c -> Character.isWhitespace(c) == false)
//				.mapToObj(c -> (char)c)
//				.collect(groupingBy(c -> c, counting()))
//				.entrySet()
//				.stream()
//				.max(comparingByValues())
//				.map(p -> result.put(p.getKey(), p.getValue()))
//				.orElse(result.put(Character.MIN_VALUE, -1));
//	}
	
	/**
	 * 14. SORTING AN ARRAY OF STRING BY LENGTH
	 * 
	 * */
	
	/**
	 * -The first thing that comes to mind is using a comparator.
	 * -Arrays.sort() takes the array and a comparator object as second arg
	 * -In this case Comparator<String> should do the job
	 * -Comparator needs to override the compareTo() method, but using a compareTo may lead to overflow
	 * -from Java7, Integer.compare() is the way to go
	 * */
	public static String[] sortArrayByLength(String[] strs, Sort direction) {
		if(direction.equals(Sort.ASC)) {
			Arrays.sort(strs, (String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
		}
		else {
			Arrays.sort(strs, (String s1, String s2) -> (-1) * Integer.compare(s1.length(), s2.length()));
		}
		return strs;
	}
	
	
	// using comparator
	public static void sortArrayByLengthByComparator(String[] strs, Sort direction) {
		if(direction.equals(Sort.ASC)) {
			Arrays.sort(strs, Comparator.comparingInt(String::length));
		}
		else {
			Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
		}
	}
	
	
	// using Comparator.comparingInt()
	public static String[] sortArrayByLengthUsingComparator(String[] strs, Sort direction) {
		if(direction.equals(Sort.ASC)) {
			Arrays.sort(strs, Comparator.comparingInt(String::length));
		}else {
			Arrays.sort(strs, Comparator.comparingInt(String::length).reversed());
		}
		return strs;
	}
	
	// using streams
	public static String[] sortArrayByLengthUsingStreams(String[] strs, Sort direction) {
		if(direction.equals(Sort.ASC)) {
			return Arrays.stream(strs)
					.sorted(Comparator.comparingInt(String::length))
					.toArray(String[]::new);
			
		}
		else {
			return Arrays.stream(strs)
					.sorted(Comparator.comparingInt(String::length).reversed())
					.toArray(String[]::new);
		}
	}
	
	
	/**
	 * 15. CHECKING THAT A STRING CONTAINS A SUBSTRING
	 * */
	public static boolean containsSubString(String str, String substring) {
		return str.contains(substring);
	}
	
	public static boolean containsSub(String str, String sub) {
		return str.indexOf(sub) != -1;
	}
	
	
	/**
	 * 16. COUNTING SUBSTRING OCCURANCES IN A STRING
	 * */
	
	// using String.indexOf(String str, int fromIndex), which returns -1 if the string is not found at a index
	public static int subStringCount(String str, String sub) {
		int position = 0;
		int count = 0;
		while((position =str.indexOf(sub, position)) != -1) {
			position = position + sub.length();
			count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(reverseWord("hello programmer"));
		
		/**
		 * Notes
		 * */
		
	
		// problem 13
//		String s1 = "ss*as/ada";
//		String p = Pattern.quote(s1);
//		System.out.println(p);
//		
//		Map<String, Integer> map = new HashMap<>();
//		map.put("a", 1);
//		map.put("b", 3);
//		map.put("c", 4);
//		System.out.println(map.values());
//		Integer max = Collections.max(map.values());
//		System.out.println(max);
		
		// problem 3
//		Pattern p = Pattern.compile("-");
//		String schedule = "MUMBAI-17:50";
//		Stream<String> str = p.splitAsStream(schedule);
//		str.forEach(System.out::println);
//		
		
		
		// problem 1
//		Map<Character, Integer> map1 = new HashMap<>();
//		char key = 'a';
//		int value = 1;
//		
		// using map.compute()
//		map1.compute(key, (k, v) -> (v == null) ? value : v + value);
//		
//		// using map.contains()
//		if(map.containsKey(key)) {
//			map1.put(key, map.get(key) + value);
//		}
//		else {
//			map1.put(key, 1);
//		}
		
		// string.chars()
//		String s = "Hello";
//		IntStream charStream = s.chars();
//		charStream.forEach(System.out::println);
//		List<Character> charList = charStream.mapToObj(c -> (char)c).collect(Collectors.toList()); // IllegalStateException
//		System.out.println(charList);
	}
	

}

enum Sort{
	ASC, DSC
}
