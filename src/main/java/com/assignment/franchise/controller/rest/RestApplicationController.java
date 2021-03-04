package com.assignment.franchise.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.franchise.model.ApplicationFormModel;
import com.assignment.franchise.services.interfaces.ApplicationService;

/**
 *  Contains rest api to manage applications
 *  
 * @author Vishnu
 *
 */
@RequestMapping("/v1/api")
@RestController
public class RestApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/applications")
	public ResponseEntity<?> submitApplication(@RequestBody ApplicationFormModel applicationFormModel) {

		Integer applicationId = applicationService.saveApplication(applicationFormModel);
		return new ResponseEntity<Integer>(applicationId, HttpStatus.CREATED);
	}

	@GetMapping("/applications")
	public ResponseEntity<?> retrieveAllApplications() {

		List<ApplicationFormModel> applicationList = applicationService.getAllApplicationWithBasicDetails();
		if(applicationList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ApplicationFormModel>>(applicationList, HttpStatus.OK);
	}

	@GetMapping("/applications/{applicationId}")
	public ResponseEntity<?> retrieveApplication(@PathVariable int applicationId) {

		ApplicationFormModel applicationModel = applicationService.getApplicationById(applicationId);
		if(applicationModel.getApplicationId() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationFormModel>(applicationModel, HttpStatus.OK);
	}

}
