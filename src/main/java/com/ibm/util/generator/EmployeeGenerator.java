package com.ibm.util.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ibm.domain.Employee;
import com.ibm.util.FileOutputUtil;

public class EmployeeGenerator {

	private static Set<String> nameSet = new HashSet<String>();
	private static Set<String> locationSet = new HashSet<String>();
	private static Set<String> roleSet = new HashSet<String>();
	private static Set<String> departmentSet = new HashSet<String>();
	private static Set<String> interestSet = new HashSet<String>();

	static {
		initializeNameSet();
		initializeLocationSet();
		initializeRoleSet();
		initializeDepartmentSet();
		initializeInterestsSet();
	}

	private static void initializeNameSet() {
		nameSet.add("Eddie");
		nameSet.add("John");
		nameSet.add("Jack");
		nameSet.add("Bob");
		nameSet.add("Ryan");
		nameSet.add("Iven");
		nameSet.add("Dan");
		nameSet.add("Rocky");
	}

	private static void initializeLocationSet() {
		locationSet.add("New York City");
		locationSet.add("Bronx");
		locationSet.add("White Plains");
		locationSet.add("Yorktown Heights");
		locationSet.add("Jersey City");
		locationSet.add("Long Island City");
		locationSet.add("Brookyln");
		locationSet.add("Flushing");
	}

	private static void initializeRoleSet() {
		roleSet.add("SDE");
		roleSet.add("Consultant");
		roleSet.add("Data Scientist");
		roleSet.add("Data Engineer");
		roleSet.add("Manager");
		roleSet.add("Product Manager");
		roleSet.add("Project Manager");
	}

	private static void initializeDepartmentSet() {
		departmentSet.add("IBM Research");
		departmentSet.add("GBS");
		departmentSet.add("GTS");
		departmentSet.add("Watson");
		departmentSet.add("Watson Health");
		departmentSet.add("IBM Cloud");
	}

	private static void initializeInterestsSet() {
		interestSet.add("AI");
		interestSet.add("machine learning");
		interestSet.add("robotics");
		interestSet.add("big data");
		interestSet.add("bioinformatics");
		interestSet.add("cyber security");
		interestSet.add("education");
		interestSet.add("deep learning");
	}

	private static String getRandomInterest() {
		Set<String> topics = new HashSet<String>();
		Random random = new Random();
		int size = random.nextInt(interestSet.size());
		for (int count = 0; count < size; count++) {
			topics.add(interestSet.stream().skip(new Random().nextInt(interestSet.size())).findFirst().orElse(null));
		}
		StringBuilder sb = new StringBuilder();
		for (String topic : topics) {
			sb.append(topic).append(",");
		}
		if (!sb.toString().isEmpty()) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	private static String getRandomName() {
		return nameSet.stream().skip(new Random().nextInt(nameSet.size())).findFirst().orElse(null);

	}

	private static String getRandomLocation() {
		return locationSet.stream().skip(new Random().nextInt(locationSet.size())).findFirst().orElse(null);
	}

	private static String getRandomRole() {
		return roleSet.stream().skip(new Random().nextInt(roleSet.size())).findFirst().orElse(null);
	}

	private static String getRandomDepartment() {
		return departmentSet.stream().skip(new Random().nextInt(departmentSet.size())).findFirst().orElse(null);
	}

	public static List<Employee> generateEmployeeList(int size) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (int counter = 1; counter <= size; counter++) {
			Employee employee = new Employee(counter + "", getRandomName(), getRandomLocation(), getRandomRole(),
					getRandomDepartment(), getRandomInterest());
			employeeList.add(employee);
		}
		return employeeList;
	}

	public static void main(String[] args) {
		int size = 10;
		List<Employee> employeeList = generateEmployeeList(size);
		String path = "src/main/resources/employeeList.txt";
		FileOutputUtil.output(employeeList, path);
	}
}
