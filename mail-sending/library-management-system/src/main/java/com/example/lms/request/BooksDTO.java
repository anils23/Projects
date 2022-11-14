package com.example.lms.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class BooksDTO {
	
	private Boolean bookAvailibility;
	
	private Integer bookId;
	
	private String bookName;
	
	private String authorName;
	
	private String bookDescription;
	
	private Double costPerHour;
	
	private List<String> users;

}
