package com.valtech.training.corejava.codilityAssignments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MobileNumberChecker {
	 public static int mobileNum(int size,List<Long> number) {
	      
	      int num=numOfUniqueDigits( size, number);
	      return num;
	  }

	  public static int numOfUniqueDigits(int size,List<Long> number) {
	      Set<Long> d = new HashSet<Long>();
	      long cn=0;
	      int y=0;
	      	for(int x=0;x<size;x++) {
	      		long cnt=0,e=0;
	      		Long elem=number.get(x);
	      		while(elem > 0) {	
			         if(d.add(elem % 10)) { 
			        	 e=elem%10;
			        	 cnt=cnt+1;
			         }
			         else {
			        	 long num=elem%10;
			        	 if(e==num) {
			        		 cnt=cnt+2;
			        	 }
			        	 else if(e==(num+1)) {
			        		 cnt=cnt+2;
			        	 }
			        	 else if(e==(num-1)) {
			        		 cnt=cnt+2;
			        	 }
			        	 
			         }
			         elem /= 10;
			         }
	      		if(cn<cnt) {
	      			cn=cnt;
	      			y=x;
	      		}
	      		
	      	}
	      	return y;
	  }

}
