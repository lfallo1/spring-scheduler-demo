'use strict';

angular.module('springDemoApp', ['ui.router', 'siteConfig'])
        .config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        	//add an http request interceptor (userful for handling errors from server), or managing / monitoring api requests
            $httpProvider.interceptors.push('httpRequestInterceptor');
            
            $urlRouterProvider.otherwise('/');
            $stateProvider
            	.state('site', { //abstract parent view named 'site'.  it has two named views (one is the main view)
            		abstract : true,
	                views: {
	                    '' : {
	                    	templateUrl : 'app/modules/site.html'
	                    },
	                    
	                    // shared views on the site page
	                    'changedb@site': {
	                        templateUrl: 'app/shared/changeDb/changeDb.html',
	                        controller: 'ChangeDbCtrl'
	                    }
	                }
	            })
	            .state('admin', {//State demonstrating Multiple,named views
                    url: "/admin",
                    views: {
                        ""  :    { templateUrl: "app/modules/admin/admin.html" },
                        "portal@admin": { template: "Write whatever you want, it's your virtual admin portal." },
                        "software@admin": { 
                        	templateUrl: "app/modules/admin/admin.software.html" ,                        
                            controller: function($scope){
                                    $scope.clients = ["HP", "IBM", "MicroSoft"];
                            }
                        }
                    }
                });
 
        }])
        .run(['$rootScope', '$http', function ($rootScope, $http) {
        		$rootScope.authheader = {'Authorization' : 'Basic ' + btoa('trustedclient:secret')};
        	
//        		$http.defaults.headers.common['Authorization'] = btoa('trustedclient:secret');
        		
            }]);
