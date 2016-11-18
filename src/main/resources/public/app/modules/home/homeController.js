angular.module("springDemoApp")
        .controller("HomeCtrl", ["$rootScope", "$scope", "ApiService", "UserApiConstants", "MessageService", function ($rootScope, $scope, ApiService, UserApiConstants, MessageService) {
        	
    		$scope.loadUsers = function(){
    			ApiService.apiSendGet(UserApiConstants.USERS_FIND_ALL).then(function(data){
            		$scope.users = data;
            	});	
    		};
    		
    		$scope.onDropComplete = function(targetIndex,data,event,obj,item){
    			var dataIndex = $scope.users.indexOf(data);
    			if(dataIndex > -1 && targetIndex > -1 && dataIndex !== targetIndex){
    				var tmp = $scope.users[targetIndex];
    				$scope.users[targetIndex] = $scope.users[dataIndex];
    				$scope.users[dataIndex] = tmp;
    			}
    		};
    		
    		$scope.onUserClick = function(user){
    			MessageService.showSticky({type : 'success', body : user});
    		};
    		
    		var init = function(){
    			$rootScope.currentPage = "Home";
    			$scope.loadUsers();
    		};
    		
    		init();
        	
        	
}]);