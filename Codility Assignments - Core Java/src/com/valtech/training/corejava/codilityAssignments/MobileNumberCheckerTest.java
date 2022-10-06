package com.valtech.training.corejava.codilityAssignments;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MobileNumberCheckerTest {
	MobileNumberChecker p= new MobileNumberChecker();
	List<Long> num = new ArrayList<>();
	
	@Test
	public void testA() {
		num.add(1234567890L);
		num.add(6469857236L);
		int size=num.size();
		assertEquals(0,MobileNumberChecker.mobileNum(size, num));
	}
	@Test
	public void testB() {
		num.add(5656565656L);
		num.add(7777777777L);
		num.add(8754969723L);
		int size=num.size();
		assertEquals(1,MobileNumberChecker.mobileNum(size, num));
	}
	@Test
	public void testC() {
		num.add(1234567890L);
		num.add(6354986547L);
		int size=num.size();
		assertEquals(0,MobileNumberChecker.mobileNum(size, num));
	}
	@Test
	public void testD() {
		num.add(7000066660L);
		num.add(7300422656L);
		int size=num.size();
		assertEquals(0,MobileNumberChecker.mobileNum(size, num));
	}
	@Test
	public void testE() {
		num.add(4545454545L);
		num.add(9875614539L);
		int size=num.size();
		assertEquals(0,MobileNumberChecker.mobileNum(size, num));
	}
	

}
