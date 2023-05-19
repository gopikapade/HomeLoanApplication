package com.homeloan.main.responce;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResponse<T> {
	
	private int responseStatus;
	private Date date=new Date();
	private String ResponseMessage;
	private T body;
	

}
