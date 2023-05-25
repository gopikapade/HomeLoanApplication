package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidIdClassException;
import com.homeloan.main.repository.EmiDetailsRepositry;
import com.homeloan.main.retalitionalmodel.EMIDetails;
import com.homeloan.main.service.CustomerEMIDetailsService;


@Service
public class CustomerEMIDetailsServiceImpl implements CustomerEMIDetailsService {

	@Autowired
	EmiDetailsRepositry emirepo;
	
	@Override
	public EMIDetails updateEmi(Integer id, EMIDetails emidata) {
		
		Optional<EMIDetails> optional=emirepo.findById(id);
		
		if (optional.isPresent()) {
			emidata.setEmiID(optional.get().getEmiID());
			EMIDetails save = emirepo.save(emidata);
			
			return save;		
			
		}
		
		else {
			
			throw new InvalidIdClassException("Id Not Found");
			
			
		}
		
	}

	@Override
	public Iterable<EMIDetails> getallemi() {
		
		return emirepo.findAll();
	}

}
