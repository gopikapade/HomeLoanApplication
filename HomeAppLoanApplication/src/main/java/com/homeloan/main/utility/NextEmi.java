package com.homeloan.main.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.homeloan.main.retalitionalmodel.EMIDetails;

public class NextEmi {
	public static EMIDetails calculateNextEmi(EMIDetails emi) {
	    if (emi != null) {
	        String nextEmiDueDate = emi.getNextEmiDueDate();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	        try {
	            Date date = dateFormat.parse(nextEmiDueDate);

	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(date);
	            calendar.add(Calendar.MONTH, 1);

	            Date newDate = calendar.getTime();

	            EMIDetails emiDetails = new EMIDetails();
	            emiDetails.setNextEmiDueDate(dateFormat.format(newDate)); // Set the updated due date
	            emiDetails.setEmiAmountMonthly(emi.getEmiAmountMonthly());
	            emiDetails.setPreviousEmiStatus(emi.getPreviousEmiStatus());
                
	            return emiDetails;
	        } catch (ParseException e) {
	            System.out.println("Failed to parse the date: " + nextEmiDueDate);
	            e.printStackTrace();
	        }
	    }
	    
	    return null;
	}
}
