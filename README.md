# Google Interview Question

You are given an integer X. You must choose two adjacent digits and replace them with a single adigit that equals to the rounded up average of these two digits.

For example, from the integer X= 623315, you can obtain:

43315(by replacing 62with 4);

63315(byreplacing 23 with 3, since the average of 2 and3is 2.5 that is rounded up to 3);

62315(by replacing 31 with 2);

62333(by replacing 15 with 3)

You want to find the largest nmber that can be obtained from X by replacing two adjacent digits with the rounded- up average of the two. In the above example, the largest such number is 63315

Write a function:

class Solution{ public int solution( int X);}

that, given a positive integer X, returns the largest number that can be obtained from x by replacing two adjacent igits with the roundedup average of the two.

For example, given x = 623315, the function shoul dreturn 63315 as the explained above.

Assume that X is an integer withing the range of [10.. 1,000,000,000]




--------------------------------------------------------------------------------------------------------------------------------------


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
