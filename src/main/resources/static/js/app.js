var app = angular.module("FranchiseApplicationForm", []);

app.controller("ApplicationFormController", function($scope, $http, $filter) {

	$scope.regions = ['Region 1', 'Region 2', 'Region 3', 'Region 4', 'Region 5', 'Region 6', 'Region 7', 'Region 8', ]; //TODO: Provide actual regions
	$scope.message = "";
	$scope.applications = [];
	$scope.application = "";
	$scope.applicationForm = {
			applicationId: -1,
			applicantsName: "",
			idNumber: "",
			birthDate: "",
			contactAddress: "",
			contactPhone: "",
			contactEmail: "",
			descriptionPreviousExperience: "",
			descriptionInterestAboutOurBrand: "",
			investmentAmountInUSD: "",
			geographicalAreasToOperate: "",
			additionalNotes: ""
	};

	// Create application
	$scope.submitApplication = function() {
		$scope.message = "";
		$scope.applicationForm.birthDate = formatDate($scope.applicationForm.birthDate);
		$http({
			method: "POST",
			url: '/v1/api/applications',
			data: angular.toJson($scope.applicationForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function success(response) {
			clearFormData();
			$scope.message = "Application submitted successfully";
	      },
	      function error (response) {
	    	  $scope.message = "Application submission failed";
	      });
	};

	// Retrieve applications
	$scope.retrieveApplicationList = function() {
		$http({
			method : 'GET',
			url : '/v1/api/applications'
		}).then(function success(response) {
	          $scope.applications = response.data;
	          $scope.message='';
	      },
	      function error (response) {
	          $scope.message='Failed to load applications';
	      });
	};
	
	// Redirect to individual application
	$scope.viewApplication = function(application) {
		localStorage.setItem("applicationId", application.applicationId);
		window.location = "/application";
	};
	
	// Retrieve applications by applicationId
	$scope.retrieveApplication = function() {
		var applicationId = parseInt(localStorage.getItem("applicationId"));
		$http({
			method : 'GET',
			url : '/v1/api/applications/'+applicationId
		}).then(function success(response) {
	          $scope.application = response.data;
	          $scope.message='';
	      },
	      function error (response) {
	    	  $scope.message='Failed to load application';
	      });
	};
	
	// Format date in dd-mmm-yyyy
	function formatDate(date){
		var d = date.getDate();
		var m = date.getMonth() + 1;
		var y = date.getFullYear();

		var dateString = (d <= 9 ? '0' + d : d) + '-' + (m <= 9 ? '0' + m : m) + '-' + y;
		return dateString;
	}

	// Clear the form
	function clearFormData() {
		$scope.applicationForm.applicationId= -1;
		$scope.applicationForm.applicantsName= "";
		$scope.applicationForm.idNumber= "";
		$scope.applicationForm.birthDate= "";
		$scope.applicationForm.contactAddress= "";
		$scope.applicationForm.contactPhone= "";
		$scope.applicationForm.contactEmail= "";
		$scope.applicationForm.descriptionPreviousExperience= "";
		$scope.applicationForm.descriptionInterestAboutOurBrand= "";
		$scope.applicationForm.investmentAmountInUSD= "";
		$scope.applicationForm.geographicalAreasToOperate= "";
		$scope.applicationForm.additionalNotes= "";
	};
});