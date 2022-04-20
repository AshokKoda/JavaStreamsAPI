package com.bridgelabz.javastreams;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class JavaStreamsAPI {

	public List<Employee> empList;

	public JavaStreamsAPI() {
		DecimalFormat df = new DecimalFormat("##.##");
		empList = new LinkedList<>();
		String[] names = { "Jack", "Mike", "Nathaline", "Elena", "Stefan" };

		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee();
			int empId = (int) (Math.random() * 900 + 100);
			emp.setEmpId(empId);
			emp.setEmpName(names[i]);
			double salary = (Math.random() * 900000 + 100000);
			emp.setSalary(Double.parseDouble(df.format(salary)));

			empList.add(emp);
		}
	}

	public static void main(String[] args) {
		System.out.println("************ Welcome to Java Streams API ************");

		JavaStreamsAPI empStream = new JavaStreamsAPI();
		System.out.println(empStream.empList);

		empStream.empList.forEach(e -> {
			System.out.println("--------------------------------");
			System.out.println("Employee name : " + e.getEmpName());
			System.out.println("Employee ID : " + e.getEmpId());
			System.out.println("Salary : $" + e.getSalary() + " USD per annum");
		});

		Employee[] arraysOfEmp = new Employee[100];
		Stream<Employee> stream = empStream.empList.stream();
		Stream<Employee> stream2 = Arrays.stream(arraysOfEmp);
		Stream<Employee> stream3 = Stream.of(new Employee());

		Stream.Builder<Employee> builder = Stream.builder();
		String[] names = { "Jack", "Mike", "Nathaline", "Elena", "Stefan" };

		DecimalFormat df = new DecimalFormat("##.##");

		Employee emp1 = new Employee();
		int empId = (int) (Math.random() * 900 + 100);
		emp1.setEmpId(empId);
		emp1.setEmpName(names[0]);
		double salary = (Math.random() * 900000 + 100000);
		emp1.setSalary(Double.parseDouble(df.format(salary)));
		builder.accept(emp1);

		Employee emp2 = new Employee();
		empId = (int) (Math.random() * 900 + 100);
		emp2.setEmpId(empId);
		emp2.setEmpName(names[1]);
		salary = (Math.random() * 900000 + 100000);
		emp2.setSalary(Double.parseDouble(df.format(salary)));
		builder.accept(emp2);

		Employee emp3 = new Employee();
		empId = (int) (Math.random() * 900 + 100);
		emp3.setEmpId(empId);
		emp3.setEmpName(names[2]);
		salary = (Math.random() * 900000 + 100000);
		emp3.setSalary(Double.parseDouble(df.format(salary)));
		builder.accept(emp3);

	}

}
