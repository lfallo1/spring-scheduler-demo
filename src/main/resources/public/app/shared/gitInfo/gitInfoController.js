angular.module("springDemoApp").controller("GitInfoCtrl", ["$scope", "ApiService", function($scope, ApiService){
	
	//load git information
	var loadGitInfo = function(){
		ApiService.apiSendGetNoToken('manage/info').then(function(data){
			$scope.git = data.git;
		});
	};
	
	//ran on startup
	var init = function(){
		loadGitInfo();
	}
	
	init();
	
}]);