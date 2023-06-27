package com.problems.objects_immutability;

import java.awt.Color;
import java.awt.Point;
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
	
	
	/**
	 * 2. checking null references and throwing customized NullPointer
	 * 	exception
	 * */
	class Car{
		private final String name;
		private final Color color;
		
//		public Car(String name, Color color) {
//			if(name == null) {
//				throw new NullPointerException("Car name can not be null");
//			}
//			if(color == null) {
//				throw new NullPointerException("Car color can not be null");
//			}
//			this.name = name;
//			this.color = color;
//		}
		
		// JDK 1.7
		public Car(String name, Color color) {
			this.name = Objects.requireNonNull(name, "Car name can not be null");
			this.color = Objects.requireNonNull(color, "Car color can not be null");
		}
		
		
		
//		public void assignDriver(String licence, Point location) {
//			if(licence == null) {
//				throw new NullPointerException("Licence can not be null");
//			}
//			if(location == null) {
//				throw new NullPointerException("Location can not be null");
//			}
//			
//		}
		
		
		// if the specified reference is null, Objects.requireNonNull will throw a NullPointerException
		// with the message provided. Otherwise it returns the checked reference.
		public void assignDriver(String licence, Point location) {
			Objects.requireNonNull(licence, "licence can not be null");
			Objects.requireNonNull(location, "location can not be null");
		}
		
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);
	}
}
