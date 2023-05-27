package com.homeloan.main.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.repository.CurrentEMiDetailsRepo;
import com.homeloan.main.retalitionalmodel.CurrentLoanDetails;
import com.homeloan.main.retalitionalmodel.EMIDetails;
import com.homeloan.main.service.EMIDetailsService;
import com.homeloan.main.utility.NextEmi;

@Service
public class EMIDetailsServiceIMPL  implements EMIDetailsService{

	@Autowired
	CurrentEMiDetailsRepo detailsRepo;
	
	
	@Override
	public CurrentLoanDetails updateEmis(CurrentLoanDetails cld) {
	    Optional<CurrentLoanDetails> findById = detailsRepo.findById(cld.getCurrentloanId());

	    if (findById.isPresent()) {
	        CurrentLoanDetails currentLoanDetails = findById.get();
	        List<EMIDetails> emiDetails = currentLoanDetails.getEmiDetails();
	        
	        Collections.sort(emiDetails, new Comparator<EMIDetails>() {
	            @Override
	            public int compare(EMIDetails e1, EMIDetails e2) {
	                return Integer.compare(e1.getEmiID(), e2.getEmiID());
	            }
	        });
	        

	        if (!emiDetails.isEmpty()) {
	            EMIDetails lastPaidEmi = emiDetails.get(emiDetails.size() - 1);
	            EMIDetails calculateNextEmi = NextEmi.calculateNextEmi(lastPaidEmi);
	            System.out.println(calculateNextEmi);
	            emiDetails.add(calculateNextEmi);
	            cld.setEmiDetails(emiDetails);
	        }

	        return detailsRepo.save(cld);
	    }

	    return null;
	}
}
