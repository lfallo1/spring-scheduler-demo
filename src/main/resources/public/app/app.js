'use strict';

angular.module('springDemoApp', ['ngRoute'])
        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {

        	$routeProvider.
	        	when('/', {
	        		templateUrl : 'app/home/home.html',
	                controller: 'HomeCtrl'
	            }).
	            when('/login', {
	                templateUrl : 'app/login/login.html',
	                controller : 'LoginCtrl'
	            }).
	            otherwise({
                    redirectTo: '/'
                });
        	
        	 $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        	
        }])
        .run(['$rootScope', function ($rootScope) {
        	
        		//TODO
        		
            }]);
