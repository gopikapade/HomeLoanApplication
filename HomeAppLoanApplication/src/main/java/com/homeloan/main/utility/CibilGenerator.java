package com.homeloan.main.utility;
import java.util.Random;
public class CibilGenerator {
	
	public static int cibilGenerator() {
        Random random = new Random();
        int cibilScore = random.nextInt(601) + 300; 
        System.out.println("Random CIBIL score: " + cibilScore);
		return cibilScore;
    }

}
