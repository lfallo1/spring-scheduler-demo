angular.module("springDemoApp")
        .controller("SiteCtrl", ["$rootScope", "$scope", "DbConstants", function ($rootScope, $scope, DbConstants) {
        	
    		var init = function(){
    			$rootScope.currentPage = DbConstants.SITE_NAME + "Home";
    			$scope.title = "Welcome to this skeleton home page!";
    		};
    		
    		init();
    		
}]);