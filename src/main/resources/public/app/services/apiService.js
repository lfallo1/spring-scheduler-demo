
	angular.module('springDemoApp').service('ApiService', ['$rootScope', '$http', '$q', '$location', 'DbService', function($rootScope, $http, $q, $location, DbService){

		/**
		 * 				{
				  "access_token": "4039d976-f754-47d5-96ef-51788b61f126",
				  "token_type": "bearer",
				  "refresh_token": "374dfda9-9dd6-45a4-b9ba-cfb064fb2644",
				  "expires_in": 119,
				  "scope": "read write trust"
				}
		 */
		
		var service = {};
		
		var refreshToken = 'oauth/token?grant_type=refresh_token&refresh_token=';
		
		var getRefreshToken = function(){
			var deferred = $q.defer();
			$http.post(refreshToken + $rootScope.authentication.refresh_token, {headers : headers}).then(function(res){
				$rootScope.authentication = res.data;
				deferred.resolve();
			}, function(err){
				deferred.reject();
			});
			return deferred.promise;
		}

		service.apiSendGet = function(url){
			var deferred = $q.defer();
			if($rootScope.authentication){
				$http.get(url + DbService.getDbKey() + "&access_token=" + $rootScope.authentication.access_token, $rootScope.authheader).then(function(res){
					deferred.resolve(res.data);
				}, function(err){
					deferred.reject(err);
				});
			} else{
				deferred.reject();
			}
			return deferred.promise;
		};

		return service;

	}]);
