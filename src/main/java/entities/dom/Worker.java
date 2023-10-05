package entities.dom;

import java.util.ArrayList;
import java.util.Calendar;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private double baseSalary;

	// Composição e associação
	private Department department;
	private ArrayList<HourContract> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(int month, int year) {
		double sum = baseSalary;

		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_month = cal.get(Calendar.MONTH);
			int c_year = cal.get(Calendar.YEAR);
			if (month == c_month && year == c_year) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

	public String getName() {	
		return name;
	}

	public Department getDepartment() {
		return department;
	}
}
