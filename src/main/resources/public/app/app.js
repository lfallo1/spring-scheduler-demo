'use strict';

angular.module('springDemoApp', ['ngRoute'])
        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {

        	//add an http request interceptor (userful for handling errors from server), or managing / monitoring api requests
            $httpProvider.interceptors.push('httpRequestInterceptor');
//            $httpProvider.defaults.useXDomain = true;
//            delete $httpProvider.defaults.headers.common['X-Requested-With'];
        	
            //setup routes
        	$routeProvider.
	        	when('/', {
	        		templateUrl : 'app/modules/home/home.html',
	                controller: 'HomeCtrl'
	            }).
	            when('/login', {
	                templateUrl : 'app/modules/login/login.html',
	                controller : 'LoginCtrl'
	            }).
	            otherwise({
                    redirectTo: '/'
                });
        	
        }])
        .run(['$rootScope', function ($rootScope) {
        	
        		//TODO
        		
            }]);
