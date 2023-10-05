package entities.dom;

import java.time.LocalDate;
import java.util.Date;

public class HourContract {

	private Date date;
	private double valuePerHour;
	private Integer hours;

	public HourContract(Date date, double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public HourContract() {
		super();
	}

	public double totalValue() {

		return valuePerHour * hours;

	}

	public Date getDate() {
		return date;
	}

	public double getValuePerHour() {
		return valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}


}
