package com.assignment.franchise.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  Entity class for application
 * 
 * @author Vishnu
 *
 */
@Entity
@Table(name = "application")
public class ApplicationFormEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2231409747220512906L;
	@Id
	@GeneratedValue
    @Column(name = "application_id") private Integer	applicationId;
	@Column(name = "applicants_name") private String applicantsName;
	@Column(name = "id_number") private Integer idNumber;
	@Column(name = "birth_date") private String  birthDate;
	@Column(name = "contact_address") private String contactAddress;
	@Column(name = "contact_phone") private String contactPhone;
	@Column(name = "contact_email") private String contactEmail;
	@Column(name = "previous_experience") private String descriptionPreviousExperience;
	@Column(name = "interest_about_our_brand") private String descriptionInterestAboutOurBrand;
	@Column(name = "investment_amount_usd") private String investmentAmountInUSD;
	@Column(name = "geographical_areas_to_operate") private String geographicalAreasToOperate;
	@Column(name = "additional_notes") private String additionalNotes;
	@Column(name = "application_datetime") private String applicationDateTime;
	
	public ApplicationFormEntity() {
		super();
	}

	public ApplicationFormEntity(String applicantsName, Integer idNumber, String birthDate, String contactAddress,
			String contactPhone, String contactEmail, String descriptionPreviousExperience,
			String descriptionInterestAboutOurBrand, String investmentAmountInUSD, String geographicalAreasToOperate,
			String additionalNotes, String applicationDateTime) {
		super();
		this.applicantsName = applicantsName;
		this.idNumber = idNumber;
		this.birthDate = birthDate;
		this.contactAddress = contactAddress;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.descriptionPreviousExperience = descriptionPreviousExperience;
		this.descriptionInterestAboutOurBrand = descriptionInterestAboutOurBrand;
		this.investmentAmountInUSD = investmentAmountInUSD;
		this.geographicalAreasToOperate = geographicalAreasToOperate;
		this.additionalNotes = additionalNotes;
		this.applicationDateTime = applicationDateTime;
	}
	
	/**
	 * @return the applicationId
	 */
	public Integer getApplicationId() {
		return applicationId;
	}
	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	/**
	 * @return the applicantsName
	 */
	public String getApplicantsName() {
		return applicantsName;
	}
	/**
	 * @param applicantsName the applicantsName to set
	 */
	public void setApplicantsName(String applicantsName) {
		this.applicantsName = applicantsName;
	}
	/**
	 * @return the idNumber
	 */
	public Integer getIdNumber() {
		return idNumber;
	}
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the contactAddress
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * @param contactAddress the contactAddress to set
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}
	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the descriptionPreviousExperience
	 */
	public String getDescriptionPreviousExperience() {
		return descriptionPreviousExperience;
	}
	/**
	 * @param descriptionPreviousExperience the descriptionPreviousExperience to set
	 */
	public void setDescriptionPreviousExperience(String descriptionPreviousExperience) {
		this.descriptionPreviousExperience = descriptionPreviousExperience;
	}
	/**
	 * @return the descriptionInterestAboutOurBrand
	 */
	public String getDescriptionInterestAboutOurBrand() {
		return descriptionInterestAboutOurBrand;
	}
	/**
	 * @param descriptionInterestAboutOurBrand the descriptionInterestAboutOurBrand to set
	 */
	public void setDescriptionInterestAboutOurBrand(String descriptionInterestAboutOurBrand) {
		this.descriptionInterestAboutOurBrand = descriptionInterestAboutOurBrand;
	}
	/**
	 * @return the investmentAmountInUSD
	 */
	public String getInvestmentAmountInUSD() {
		return investmentAmountInUSD;
	}
	/**
	 * @param investmentAmountInUSD the investmentAmountInUSD to set
	 */
	public void setInvestmentAmountInUSD(String investmentAmountInUSD) {
		this.investmentAmountInUSD = investmentAmountInUSD;
	}
	/**
	 * @return the geographicalAreasToOperate
	 */
	public String getGeographicalAreasToOperate() {
		return geographicalAreasToOperate;
	}
	/**
	 * @param geographicalAreasToOperate the geographicalAreasToOperate to set
	 */
	public void setGeographicalAreasToOperate(String geographicalAreasToOperate) {
		this.geographicalAreasToOperate = geographicalAreasToOperate;
	}
	/**
	 * @return the additionalNotes
	 */
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	/**
	 * @param additionalNotes the additionalNotes to set
	 */
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	/**
	 * @return the applicationDateTime
	 */
	public String getApplicationDateTime() {
		return applicationDateTime;
	}
	/**
	 * @param applicationDateTime the applicationDateTime to set
	 */
	public void setApplicationDateTime(String applicationDateTime) {
		this.applicationDateTime = applicationDateTime;
	}

}
