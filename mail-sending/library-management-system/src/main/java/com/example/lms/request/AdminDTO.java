package com.example.lms.request;

import java.util.List;

import com.example.lms.entity.Notifications;
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
public class AdminDTO {

	private Integer adminId;

	private String adminName;

	private Double accountBalance;

	private List<Notifications> notifications;
}
