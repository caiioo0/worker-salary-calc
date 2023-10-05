package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.dom.Department;
import entities.dom.HourContract;
import entities.dom.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double workerSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary,
				new Department(departmentName));
		
		System.out.print("How many contracts to this worker ?");
		int numberOfContracts = sc.nextInt();
		
		for(int i=1; i<=numberOfContracts; i++) {
			System.out.println("Enter contract " + i + "# data:");
			System.out.print("Date (DD/MM/YY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.err.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYer = sc.next();
		int month = Integer.parseInt(monthAndYer.substring(0,2));
		int year = Integer.parseInt(monthAndYer.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for : " + monthAndYer + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
