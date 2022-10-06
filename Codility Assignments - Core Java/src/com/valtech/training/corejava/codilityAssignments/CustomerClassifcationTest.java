package com.valtech.training.corejava.codilityAssignments;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.valtech.training.corejava.day5.*;

public class CustomerClassifcationTest {

	int Diamond=4;
	int Platinum =3;
	int Gold=2;
	int Silver=1;
	@Test
	public void test() throws Exception {
		Set<CustomerClassifcation> customer= new TreeSet<CustomerClassifcation>();

		CustomerClassifcation c1= new CustomerClassifcation("Martin",Platinum,"1985-09-25",50000);
		CustomerClassifcation c2= new CustomerClassifcation("John",Gold,"1995-09-13",20000);
		CustomerClassifcation c3= new CustomerClassifcation("William",Diamond,"1999-08-25",45000);
		CustomerClassifcation c4= new CustomerClassifcation("George",Silver,"2000-09-10",5000);
		CustomerClassifcation c5= new CustomerClassifcation("Harry",Diamond,"1987-10-25",45000);
		CustomerClassifcation c6= new CustomerClassifcation("James",Gold,"1990-10-25",20000);
		CustomerClassifcation c7= new CustomerClassifcation("Joseph",Platinum,"1994-11-25",50000);

		customer.add(c1);
		customer.add(c2);
		customer.add(c3);
		customer.add(c4);
		customer.add(c5);
		customer.add(c6);
		customer.add(c7);
		
		System.out.println("Number of Customers : " + customer.size()+"\n");
		for(CustomerClassifcation c : customer) {
			System.out.println(c.toString());
		}

	}
	

	public String convert_to_string (int ct) {
		switch (ct) {
		case 1:
			return "Silver";

		case 2:
			return "Gold";

		case 3:
			return "Paltinum";

		case 4:
			return "Diamond";
		default:
			return "0";

		}
	}

}
