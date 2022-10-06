package com.valtech.training.corejava.codilityAssignments;

import static org.junit.Assert.*;

import org.junit.Test;

	public class PasswordCheckerTest {
		
		PasswordChecker p=new PasswordChecker();

		@Test
		public void testPasswordStrength() {
			String pw ="Vf5GhHr6";
			assertEquals("Weak Password", p.checkPasswordStrength(pw));
			String pswd="VFhh#@125";
			assertEquals("Moderate Password", p.checkPasswordStrength(pswd));
			String password="VF$hh#!@125";
			assertEquals("Strong Password", p.checkPasswordStrength(password));
		}
		
		
		@Test
		public void testPasswordScore() {
			String pw ="Vf5GhHr6";
			assertEquals(16,p.computeScore(pw));
			String pswd="VFhh#@125";
			assertEquals(24,p.computeScore(pswd));
			String password="VF$hh#!@125";
			assertEquals(28,p.computeScore(password));
		}
		
		@Test
		public void testInvalidPassword() {
			String pswd="VFhh#12";
			assertEquals(7,p.computeScore(pswd));
		}
		
}
