package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacentDigits {
	public static void main(String args[]) {
		System.out.println(solutions(623315));
	}

	public static int solutions(int X) {
		int numberX = X;
		int MAX = 0;
		int tempX = 0;
		
		ArrayList<Integer> arrayOfX = new ArrayList<Integer>();
		
		do {
			arrayOfX.add(numberX % 10);
			numberX /= 10;
		} while (numberX > 0);

		
		Collections.reverse(arrayOfX);
//		System.out.println(arrayOfX + "\n------------------------- \n");
				
		for (int i = 0; i < arrayOfX.size()-1; i++) {
//			System.out.println("Index "+arrayOfX.get(i)+ " + "+ arrayOfX.get(i+1) + " = " + ((arrayOfX.get(i)+arrayOfX.get(i+1))/2.0));
			tempX =  (int) Math.ceil((arrayOfX.get(i) + arrayOfX.get(i + 1)) / 2.0);
//			System.out.println(tempX);
			
			
			ArrayList<Integer> tempArrayOfX = new ArrayList<Integer>(arrayOfX);
			tempArrayOfX.set(i, tempX);
			tempArrayOfX.remove(i + 1);
			
//			System.out.println(tempArrayOfX);
			
			
			int a=0;
			for(int k=0;k<tempArrayOfX.size();k++){ 
				a*=10;
				a+=tempArrayOfX.get(k); 
			}
			
			if(a>MAX){
				MAX=a;
			}
//			System.out.println(" A =  "+ a + "  \t  || \t MAX =  "+MAX);
//			System.out.println("\n---------------------------\n");

		}
		return MAX;
	}
}
