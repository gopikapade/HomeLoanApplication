package com.homeloan.main.utility;

public class EmiCalculator {
	
	public static double calculateEMI(double principleAmmount, double intrestrate, int tenure) {
        double monthlyInterestRate = ((intrestrate / 12 ) / 100); //R
        int monthlytenure=(tenure*12);
        double first = Math.pow((1 + monthlyInterestRate), monthlytenure);     
 //     double amount =  principleAmmount * monthlyInterestRate * (1 + monthlyInterestRate) * 120/(((1 + monthlyInterestRate) * 120) - 1);
      double Emi_amount =  Math.round(principleAmmount * monthlyInterestRate * ((first)/((first)-1)));
      
        return Emi_amount;
    }	
//	Formula: EMI = P x R x [{(1 + R)^N} / {1 – (1+R)^N}]
}

