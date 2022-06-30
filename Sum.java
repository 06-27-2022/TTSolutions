package com.revature.dsa;


public class Sum {
	
	int sum;
	
	int SumArray (int []array) {
	return sum + array[0];
}
	
public static void main(String[]args) {
	int[] array = {3,5,8,80, 70, 55, 87, 33, 52, 2};
	int sum =0;
	for (int i = 0; i < array.length -1; i++) 
		sum = sum + array[i];
	System.out.println(array[6]);
}
}