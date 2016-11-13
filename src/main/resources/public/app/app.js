'use strict';

angular.module('springDemoApp', ['ui.router', 'angular-storage'])
        .config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        	//add an http request interceptor (userful for handling errors from server), or managing / monitoring api requests
            $httpProvider.interceptors.push('httpRequestInterceptor');
            
            $urlRouterProvider.otherwise('/site');
            $stateProvider
            	.state('site', {
            		url : '/site',
	                views: {
	                    '' : {
	                    	templateUrl : 'app/modules/site.html',
	                    	controller : 'SiteCtrl'
	                    },
	                    
	                    // named view on the 'site' state
	                    'namedview@site': {
	                        template: '<div class="alert alert-warning">I\'m a named view!</div>'
	                    }
	                }
	            });
 
        }])
        .run( [ '$rootScope', function ($rootScope) {
        		
        		//perform any setup
        		
            }]);
