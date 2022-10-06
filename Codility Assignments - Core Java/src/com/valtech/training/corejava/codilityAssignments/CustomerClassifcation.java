package com.valtech.training.corejava.codilityAssignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;




public class CustomerClassifcation implements Comparable<CustomerClassifcation> {

	String name;
	int type;
	double moneyspent;
	String date;

	public CustomerClassifcation(String name,int type,String date, double moneyspent) {
		this.name=name;
		this.type=type;
		this.date=date;
		this.moneyspent=moneyspent;

	}

	public int money_compare(double money1, double money2) {
		if(money1>money2) return +1;
		if(money1<money2) return -1;
		return 0;
	}
	public int date_Compare(String d1, String d2)   {
		LocalDate currdt1= LocalDate.parse(d1);
		int mon1= currdt1.getMonthValue();
		int yr1=currdt1.getYear();
		LocalDate currdt2= LocalDate.parse(d2);
		int mon2= currdt2.getMonthValue();
		int yr2=currdt2.getYear();
		if(yr1==yr2) {
			if(mon1>mon2) return +1;
			if(mon1<mon2) return -1;
			return 0;	  
		}

		if(yr1>yr2) return +1;
		return -1;
	}
	@Override
	public int compareTo(CustomerClassifcation c) {
		int compdate;
		int compmoney;
		if(type==c.type) {

			compdate = date_Compare(date, c.date);

			if(compdate==0) {
				compmoney = money_compare(moneyspent,c.moneyspent);
				if(compmoney==0) return 0;
				if(compmoney==+1) return -1;
				return +1;
			}
			if(compdate==+1) return +1;


			return -1;
		}
		if(type<c.type) {
			return +1;
		}

		return -1;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", type=" + type + ", moneyspent=" + moneyspent + ", date="
				+ date + "]";
	}
}
