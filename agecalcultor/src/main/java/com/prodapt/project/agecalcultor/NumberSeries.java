package com.prodapt.project.agecalcultor;

public class NumberSeries {
	public static void printSeries(int n) {
		int j=2 ;
		for(int i=1;i<=n;i++) {
			if(i==1) {
				System.out.println(j+"");
				
			}else if(i%2 !=0) {
				j=2 *j-1;
				System.out.println(j+"");
			}else {
				j=2*j+1;
				System.out.println(j+"");
			}  
			}
		}
	}


