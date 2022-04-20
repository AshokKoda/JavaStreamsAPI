package com.bridgelabz.javastreams;

import java.util.function.Consumer;
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
}
