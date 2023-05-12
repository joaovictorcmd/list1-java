package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// READING DATA

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println();

		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			System.out.println();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = sc.nextInt();
		
		Integer pos = position(list, idSalary);
		
		if (pos == null) {
			System.out.println("This ID does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			
			list.get(pos).increaseSalary(percentage);
		}

		System.out.println();
		System.out.println("List of Employees:");

		for (Employee emp : list) {
			System.out.println(emp.toString());
		}

		sc.close();
	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;

	}

}
