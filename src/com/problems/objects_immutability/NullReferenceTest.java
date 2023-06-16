package com.problems.objects_immutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class NullReferenceTest {

	
	/**
	 * 1. Checking null reference in functional style and imperative code
	 * */
	public static List<Integer> evenIntegers(List<Integer> integers){
		
		if(Objects.nonNull(integers)) {
			return Collections.EMPTY_LIST;
		}
		List<Integer> evens = new ArrayList<>();
		for(Integer i : integers) {
			if(Objects.nonNull(i) & i % 2 == 0) {
				evens.add(i);
			}
		}
		return evens;
	}
	
	// the above null checks can be refactored as
	public static int sumIntegers(List<Integer> integers){
		if(Objects.isNull(integers)) {
			throw new IllegalArgumentException();
		}

		return integers.stream()
				.filter(Objects::nonNull)
				.mapToInt(Integer::intValue)
				.sum();
	}
	
	public static boolean arrContainsNulls(List<Integer> integers) {
		if(Objects.isNull(integers)) {
			return false;
		}
		return integers.stream()
				.anyMatch(Objects::isNull);
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
	}
}
