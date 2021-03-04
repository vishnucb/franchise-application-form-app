package com.assignment.franchise.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.franchise.entity.ApplicationFormEntity;
import com.assignment.franchise.model.ApplicationFormModel;
import com.assignment.franchise.repository.ApplicationRepository;
import com.assignment.franchise.services.interfaces.ApplicationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods to handling application details
 * 
 * @author Vishnu
 *
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public Integer saveApplication(ApplicationFormModel applicationFormModel) {
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		ApplicationFormEntity applicationFormEntity = new ApplicationFormEntity();
		applicationFormEntity.setApplicantsName(applicationFormModel.getApplicantsName());
		applicationFormEntity.setIdNumber(applicationFormModel.getIdNumber());
		applicationFormEntity.setBirthDate(applicationFormModel.getBirthDate());
		applicationFormEntity.setContactAddress(applicationFormModel.getContactAddress());
		applicationFormEntity.setContactPhone(applicationFormModel.getContactPhone());
		applicationFormEntity.setContactEmail(applicationFormModel.getContactEmail());
		applicationFormEntity.setDescriptionPreviousExperience(applicationFormModel.getDescriptionPreviousExperience());
		applicationFormEntity.setDescriptionInterestAboutOurBrand(applicationFormModel.getDescriptionInterestAboutOurBrand());
		applicationFormEntity.setInvestmentAmountInUSD(applicationFormModel.getInvestmentAmountInUSD());
		StringBuilder regions = new StringBuilder();
		if(applicationFormModel.getGeographicalAreasToOperate() != null)
			for(String region : applicationFormModel.getGeographicalAreasToOperate()) {
				if(regions.length()>0) {
					regions.append(",");
				}
				regions.append(region);
			}
		applicationFormEntity.setGeographicalAreasToOperate(regions.toString());
		applicationFormEntity.setAdditionalNotes(applicationFormModel.getAdditionalNotes());
		applicationFormEntity.setApplicationDateTime(localDateTime.format(dateFormat));
		return applicationRepository.save(applicationFormEntity).getApplicationId();
	}

	@Override
	public List<ApplicationFormModel> getAllApplicationWithBasicDetails() {
		List<ApplicationFormEntity> applicationEntityList = applicationRepository.findAll(); //TODO Use pagination and sort by datetime column
		List<ApplicationFormModel> applicationModelList = new ArrayList<>();
		applicationEntityList.forEach(applicationEntity -> {
			ApplicationFormModel applicationModel = new ApplicationFormModel();
			applicationModel.setApplicationId(applicationEntity.getApplicationId());
			applicationModel.setApplicantsName(applicationEntity.getApplicantsName());
			applicationModel.setIdNumber(applicationEntity.getIdNumber());
			applicationModel.setApplicationDateTime(applicationEntity.getApplicationDateTime());
			applicationModelList.add(applicationModel);
		});
		return applicationModelList;
	}

	@Override
	public ApplicationFormModel getApplicationById(Integer applicationId) {
		ApplicationFormEntity applicationEntity = applicationRepository.getOne(applicationId);
		ApplicationFormModel applicationModel = new ApplicationFormModel();
		applicationModel.setApplicationId(applicationEntity.getApplicationId());
		applicationModel.setApplicantsName(applicationEntity.getApplicantsName());
		applicationModel.setIdNumber(applicationEntity.getIdNumber());
		applicationModel.setBirthDate(applicationEntity.getBirthDate());
		applicationModel.setContactAddress(applicationEntity.getContactAddress());
		applicationModel.setContactPhone(applicationEntity.getContactPhone());
		applicationModel.setContactEmail(applicationEntity.getContactEmail());
		applicationModel.setDescriptionPreviousExperience(applicationEntity.getDescriptionPreviousExperience());
		applicationModel.setDescriptionInterestAboutOurBrand(applicationEntity.getDescriptionInterestAboutOurBrand());
		applicationModel.setInvestmentAmountInUSD(applicationEntity.getInvestmentAmountInUSD());
		String regions[] = applicationEntity.getGeographicalAreasToOperate().split(",");
		applicationModel.setGeographicalAreasToOperate(regions);
		applicationModel.setAdditionalNotes(applicationEntity.getAdditionalNotes());
		applicationModel.setApplicationDateTime(applicationEntity.getApplicationDateTime());
		return applicationModel;
	}

}
