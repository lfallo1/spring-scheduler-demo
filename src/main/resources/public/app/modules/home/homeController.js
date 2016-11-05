angular.module("springDemoApp")
        .controller("HomeCtrl", ["$rootScope", "$scope", "ApiService", "UserApiConstants", "$timeout", function ($rootScope, $scope, ApiService, UserApiConstants, $timeout) {
        	
    		$scope.loadUsers = function(){
    			ApiService.apiSendGet(UserApiConstants.USERS_FIND_ALL).then(function(data){
            		$scope.users = data;
            	});	
    		};
    		
    		var init = function(){
    			$rootScope.currentPage = "Home";
    			$scope.loadUsers();
    		};
    		
    		init();
        	
        	
}]);