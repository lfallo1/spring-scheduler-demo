angular.module('springDemoApp').controller('LoginCtrl', ['$q', '$http', '$scope', '$rootScope', "$location",
                                                         function($q, $http, $scope, $rootScope, $location){
	
	$scope.login = function(){
		var url = 'oauth/token?grant_type=password&username='+ $scope.username +'&password=' + $scope.password;
		$http({method: 'POST', url, headers : $rootScope.authheader}).then(function(res){
			$rootScope.authentication = res.data;
			$location.path("/");
		}, function(err){
			console.log(err);
		});
	};
	
	
}]);