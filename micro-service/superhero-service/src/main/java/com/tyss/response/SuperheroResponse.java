package com.tyss.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SuperheroResponse {

	private boolean error;
	
	private String message;
	
	private Object data;
	
}
