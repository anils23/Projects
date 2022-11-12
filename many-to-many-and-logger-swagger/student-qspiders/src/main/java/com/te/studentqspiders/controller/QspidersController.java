package com.te.studentqspiders.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.studentqspiders.entity.Qspiders;
import com.te.studentqspiders.request.QspidersRequest;
import com.te.studentqspiders.response.Response;
import com.te.studentqspiders.service.QspidersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QspidersController {

	private final QspidersService service;

	@PostMapping("/add-qspiders-details")
	public ResponseEntity<Response> addQspidersDetails(@RequestBody QspidersRequest request) {
		log.info("Request for adding qspiders details");
		QspidersRequest qspiders = service.addQspidersDetails(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(qspiders).build());
	}

	@GetMapping("/get-qspiders-details/{qspidersId}")
	public ResponseEntity<Response> getQspidersDetails(@PathVariable Integer qspidersId) {
		log.info("Request for getting qspiders details");
		Qspiders qspiders = service.getQspidersDetails(qspidersId);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(qspiders).build());
	}

	@PutMapping("/update-qspider-details")
	public ResponseEntity<Response> updateQspidersDetails(@RequestBody QspidersRequest request) {
		log.info("Request for updating qspiders details");
		QspidersRequest qspiders = service.updateQspiderDetails(request);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).data(qspiders).build());
	}

	@DeleteMapping("/delete-qspiders-details/{qspidersId}")
	public ResponseEntity<Response> deleteQspidersDetails(@PathVariable Integer qspidersId) {
		log.info("Request for deleting qspiders details");
		String string = service.deleteQspiderDetails(qspidersId);
		return ResponseEntity.ok(Response.builder().error(Boolean.FALSE).message(string).build());
	}

}
