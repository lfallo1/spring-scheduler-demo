angular.module('springDemoApp').controller('LoginCtrl', ['$q', '$http', '$scope', '$rootScope', 
                                                         function($q, $http, $scope, $rootScope){

	$scope.login = function(){
		var url = 'oauth/token?username=' + $scope.username + '&password=' + $scope.password + '&grant_type=password&client_secret=123456&client_id=' + 'sbg' + '&scope=read,write';
		$http.post(url).then(function(res){
			console.log(res.data)
		}, function(err){
			console.log(err);
		});
	};
	
	
}]);