package com.valtech.training.corejava.codilityAssignments;

import java.util.Comparator;
import java.util.TreeSet;

public class PasswordChecker {
	
	public int computeScore(String password) {
		int scoreLower=0;
		int scoreUpper=0;
		int scoreNum=0;
		int scoreSpl=0;
		
		int totalScore=0;
			
		PasswordChecker pck = new PasswordChecker();
		if(password.length()<8) {
			totalScore=password.length();
		}
		else if(password.length()>=8) {
			scoreLower=pck.checkLowerCase(password);
			scoreUpper=pck.checkUpperCase(password);
			scoreNum=pck.checkNumber(password);
			scoreSpl=pck.checkSpecialChar(password);
			totalScore=scoreLower+scoreUpper+scoreNum+scoreSpl;
		}
		
		return totalScore;
	}
	
	public String checkPasswordStrength(String password) {
		
		int score = computeScore(password);
		
		String msg ="";
		
		if(score>25) {
			msg="Strong Password";
		}
		else if(score<=25 && score>20) {
			msg="Moderate Password";
		}
		else if(score<=20 && score>=8) {
			msg="Weak Password";
		}
		else if(password.length()<8){
			msg="Password must greater than 8 characters";
		}
		
		return msg;

	}

	public int checkLowerCase(String password) {
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (c >= 'a' && c <= 'z') {
				return 5;
			}
		}
		return 0;
	}

	public int checkUpperCase(String password) {
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (c >= 'A' && c <= 'Z')
				return 5;
		}

		return 0;
	}

	public int checkNumber(String password) {
		String str = "0123456789";
		int score = 0;
		int count=0;
		for (int i = 0; i < password.length(); i++) {
			if (str.contains("" +password.charAt(i))){
				count++;
				if(count>1)
				{
				score+=1;
				}
			}
		}
		score = CountScoreForNumAndSpl(score, count);
		return score;
	}

	public int checkSpecialChar(String password) {

		String str = "@#!$%^&*()+-/<>.,?:";
		int score = 0;
		int count=0;
		for (int i = 0; i < password.length(); i++) {
			if (str.contains("" +password.charAt(i))){
				count++;
				if(count>1)
				{
				score+=2;
				}
			}
		}
		score = CountScoreForNumAndSpl(score, count);
		return score;
	}

	private int CountScoreForNumAndSpl(int score, int count) {
		if(count==0) {
			score=0;
		}
		else if (count==1){
			score=5;
		}
		else {
			score+=5;
		}
		return score;
	}
}
