package com.example.lms.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class LmsApplicationDTO {

	private Integer bookId;

    private Integer userId;
    
    private String userName;
    
    private Double booksNeededForHowManyHours;

}
