package com.prodapt.project.agecalcultor;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		NumberSeries.printSeries(n);
		sc.close();
	}
}
