package com.loops;

public class ForLoopExample1 {

	public static void main(String[] args) {
		
		//for(initialization;condition;inc/dec )
		
		
		
		for(int i=1;i<=2;i++)
		{
			System.out.println(i+"webdriver");
		}
		
		for(int i=1;i<=2;i=i+1)
		{
			System.out.println(i+"webdriver");
		}
		
		System.out.println("*****************");
		System.out.println();
		
		for(int i=2;i<=6;i=i+2)
		{
			System.out.println(i+" Testing ");
		}

		System.out.println("*****************");
		System.out.println();
		
		for(int i=-2;i<=-5;i--)
		{
			System.out.println(i+" Tosca ");
		}
		System.out.println("*****************");
		System.out.println();

		for(int i=-2;i>=-8;i=i-3)
		{
			System.out.println(i+" LoadRunner ");
		}
		System.out.println("*****************");
		System.out.println();

		for(int i=-3;i>=-5;i=i-3)
		{
			System.out.println(i+" ETL Testing ");
		}
	}
}
