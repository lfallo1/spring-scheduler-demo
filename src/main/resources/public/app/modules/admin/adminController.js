angular.module('springDemoApp').controller('AdminCtrl', ['$scope', 'users', '$stateParams', function($scope, users, $stateParams){

	var init = function(){
		$scope.myUsernameParam = $stateParams.username;
		$scope.users = users;
	};
	
	init();
	
}])
