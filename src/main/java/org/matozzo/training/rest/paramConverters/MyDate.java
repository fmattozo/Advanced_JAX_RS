package org.matozzo.training.rest.paramConverters;


// Simple POJO para ser usado para conversao de tipos
// including just the toString override
public class MyDate {

	
	private int day;
	private int month;
	private int year;
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return "Mydate [date= " + day + ", month= " + month + ", year= " + year + "]";
	}
	
	
}
