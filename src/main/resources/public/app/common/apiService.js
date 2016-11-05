(function(){
	
	angular.module('springDemoApp').service('ApiService', ['$rootScope', '$http', '$q', '$location', function($rootScope, $http, $q, $location){
	
		var service = {};
		
		service.apiSendGet = function(url){
			var deferred = $q.defer();
			$http.get(url).then(function(res){
				deferred.resolve(res.data);
			}, function(err){
				deferred.reject(err);
			})
			return deferred.promise;
		}
		
		return service;
		
	}]);
	
})();