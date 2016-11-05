angular.module("springDemoApp")
        .controller("HomeCtrl", ["$rootScope", "$scope", "ApiService", "UserApiConstants", "$timeout", function ($rootScope, $scope, ApiService, UserApiConstants, $timeout) {
        	
        	$rootScope.currentPage = "Home";
        	
    		ApiService.apiSendGet(UserApiConstants.USERS_FIND_ALL).then(function(data){
        		$scope.users = data;
        	});	
        	
        	
}]);