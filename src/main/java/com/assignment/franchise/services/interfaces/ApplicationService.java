package com.assignment.franchise.services.interfaces;

import java.util.List;

import com.assignment.franchise.model.ApplicationFormModel;

public interface ApplicationService {

	public Integer saveApplication(ApplicationFormModel applicationFormModel);
	public List<ApplicationFormModel> getAllApplicationWithBasicDetails();
	public ApplicationFormModel getApplicationById(Integer applicationId);
}
