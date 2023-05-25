package com.homeloan.main.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.model.EnquiryDetails;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.EnquiryServicei;
@CrossOrigin("*")
@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	
	@Autowired
	EnquiryServicei enqservice;
	
	
	@PostMapping("/addenquiry")
	public ResponseEntity<BaseResponse<EnquiryDetails>> addenquiry(@RequestBody EnquiryDetails enquiryDetails){
		EnquiryDetails details=enqservice.saveAddEnquiry(enquiryDetails);
		BaseResponse<EnquiryDetails> baseResponse=new BaseResponse<EnquiryDetails>(200, new Date(),"Data Is Added Sucessfully", details);
		return new ResponseEntity<BaseResponse<EnquiryDetails>>(baseResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getenquiry")
	public ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>> getenquiry(){
		
	   List<EnquiryDetails> iterable=enqservice.getalldata();
	     
	    List<EnquiryDetails> collect = iterable.stream().filter(enq->enq.getLoanApplication()==null).collect(Collectors.toList());
	   
		BaseResponse<Iterable<EnquiryDetails>> baseResponse=new BaseResponse<Iterable<EnquiryDetails>>
		(200, new Date(), "Data Is GEt Sucessfully", collect);
		return new ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>>(baseResponse, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/oeForward/{id}")
	public ResponseEntity<BaseResponse<EnquiryDetails>> oeForwardadded(@PathVariable Integer id, @RequestBody EnquiryDetails enquiry){
		
		EnquiryDetails enq   = enqservice.oeForword(id, enquiry);
		
		BaseResponse<EnquiryDetails> baseResponse = new BaseResponse<EnquiryDetails>(201, new Date(), "Forwword To oe", enq);
		
		return new ResponseEntity<BaseResponse<EnquiryDetails>>(baseResponse, HttpStatus.ACCEPTED);
		
	   }
	
	@GetMapping("/oeGetEnquiries")
	public ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>> oeGeTforwadedEnquiries()
      	{
	              Iterable<EnquiryDetails> getalldata = enqservice.getalldata();    
	              List<EnquiryDetails> collect = StreamSupport.stream(getalldata.spliterator(), false)
	              .filter(enq->enq.getForwardToOe()!=null).collect(Collectors.toList());
	              
	               BaseResponse<Iterable<EnquiryDetails>> list = new BaseResponse<Iterable<EnquiryDetails>>
	               (201, new Date(), "All Forwrded enqiries", collect);
	             
	               return new ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>>(list, HttpStatus.ACCEPTED);
		
  	     }
	
	
	@DeleteMapping("/deleteEnquiries/{enquryId}")
	public ResponseEntity<BaseResponse<EnquiryDetails>> oeDeleteEnquiries(@PathVariable Integer enquryId)
	{
		enqservice.deleteData(enquryId);
		BaseResponse<EnquiryDetails> baseResponse = new BaseResponse<EnquiryDetails>(201, new Date(), "Data Deleted", null);
		return new ResponseEntity<BaseResponse<EnquiryDetails>>(baseResponse,HttpStatus.OK);

		
	}
	
	
	
	

}
