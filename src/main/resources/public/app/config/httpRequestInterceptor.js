angular.module('springDemoApp').factory('httpApiRequestInterceptor', function ($q, $rootScope, $location) {
	
	//handle requests / responses. If api request and user logged in, then session timer on front end should reset
	var handle = function(data){
		console.log(data)
	};
	
    return {
        'request': function (config) {
            return config;
        },
        'response': function (response) {
            return response;
        },
        'responseError': function (rejection) {
        	handle(rejection);
            return $q.reject(rejection);
        }
    };
});