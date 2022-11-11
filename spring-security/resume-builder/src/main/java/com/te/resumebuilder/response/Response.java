package com.te.resumebuilder.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
	
	private Boolean isError;
	
	private String message;
	
	private Object data;

}
