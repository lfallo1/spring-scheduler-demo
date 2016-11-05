
	angular.module('springDemoApp').service('ApiService', ['$rootScope', '$http', '$q', '$location', 'DbService', function($rootScope, $http, $q, $location, DbService){

		var service = {};

		service.apiSendGet = function(url){
			var deferred = $q.defer();
			$http.get(url + DbService.getDbKey()).then(function(res){
				deferred.resolve(res.data);
			}, function(err){
				deferred.reject(err);
			})
			return deferred.promise;
		}

		return service;

	}]);
