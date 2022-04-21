package com.bridgelabz.javastreams;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class EmployeeStreamTest {

	@Test
	public void streamForEach() {

		JavaStreamsAPI empData = new JavaStreamsAPI();

		Stream<Employee> empStream = empData.empList.stream();

		Consumer<Employee> empConsumer = e -> {
			System.out.println("--------------------------------");
			System.out.println("Employee name : " + e.getEmpName());
			System.out.println("Employee ID : " + e.getEmpId());
			System.out.println("Salary : $" + e.getSalary() + " USD per annum");
		};

		empStream.forEach(empConsumer);
	}

	@Test
	public void streamTransform() {

		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			intList.add(num);
		}

		Stream<Integer> intStream = intList.stream();

		Function<Integer, Double> doubleMap = n -> n.doubleValue();

		intStream.map(doubleMap).forEach(n -> System.out.println(n));
	}

	@Test
	public void streamCollect() {
		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			intList.add(num);
		}

		Stream<Integer> intStream = intList.stream();

		Function<Integer, Double> doubleMap = n -> n.doubleValue();

		List<Double> doubleList = new LinkedList<>();

		doubleList = intStream.map(doubleMap).collect(Collectors.toList());

		doubleList.forEach(System.out::println);
	}

	@Test
	public void streamFilter() {
		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			intList.add(num);
		}
		System.out.println(intList);
		Stream<Integer> intStream = intList.stream();

		Predicate<Integer> isEven = n -> n % 2 == 0;

		intStream.filter(isEven).forEach(System.out::println);
	}

	@Test
	public void streamFindFirst() {
		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			/*
			 * while (num % 2 == 0) { num = (int) (Math.random() * 90 + 10); }
			 */
			intList.add(num);
		}
		System.out.println(intList);

		Stream<Integer> stream = intList.stream();

		int a = stream.filter(n -> checkPrime(n)).findFirst().get();

		System.out.println("First prime number is : " + a);
	}

	@Test
	public void streamMinMax() {
		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			intList.add(num);
		}
		System.out.println(intList);

		int minNum = intList.stream().filter(n -> n % 2 == 0).min(Comparator.comparing(n -> n)).get();

		int maxNum = intList.stream().filter(n -> n % 2 == 0).max(Comparator.comparing(n -> n)).get();

		System.out.println("Minimum even is : " + minNum);
		System.out.println("Maximum even is : " + maxNum);

	}

	@Test
	public void streamReduce() {
		List<Integer> intList = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * 90 + 10);
			intList.add(num);
		}
		System.out.println(intList);

		int sum = intList.stream().reduce((n1, n2) -> n1 + n2).get();

		int count = (int) intList.stream().count();
		double avg = (double) sum / count;
		System.out.println(sum);
		System.out.println(avg);

	}

	public boolean checkPrime(int n) {
		boolean isPrime = true;

		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
