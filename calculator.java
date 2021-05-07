package test;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char operator;
		Double number1,number2,result;
		// create an object of Scanner class
		Scanner sa = new Scanner(System.in);
		System.out.println("Let's Caluclate");
		System.out.println("Enter 1st Number:");
		number1=sa.nextDouble();
		System.out.println("Enter 2st Number:");
		number2=sa.nextDouble();
		System.out.println("\nEnter an operator(+, -, *, /)");
		operator=sa.next().charAt(0);
		switch (operator) {
		case '+':
			result=number1+number2;
			System.out.println("Addition:" +result);
			break;
		case'-' :
			result=number1-number2;
			System.out.println(result);
			break;
		case'*' :
			result=number1*number2;
			System.out.println(result);
			break;
		case'/' :
			result=number1/number2;
			System.out.println(result);
			break;

		default:
			System.out.println("Calculation Not Possible");
			break;
		}
sa.close(); //Resource leak: 'sa' is closed. Line 12
	}

}
