'use strict';

angular.module('springDemoApp', ['ui.router', 'siteModule', 'angular-storage'])
        .config(['$stateProvider', '$urlRouterProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $httpProvider) {

        	//add an http request interceptor (userful for handling errors from server), or managing / monitoring api requests
            $httpProvider.interceptors.push('httpRequestInterceptor');
            
            $urlRouterProvider.otherwise('/site/home');
            $stateProvider
            	.state('site', { //abstract parent view named 'site'.  it has two named views (one is the main view)
            		abstract : true,
            		url : '/site',
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
                    url: "/admin/:username",                    
                    resolve: {
                    	users : function($http, $q, $state){
                            var deferred = $q.defer();
                            $http.get('https://jsonplaceholder.typicode.com/users').then(function(res){
                            	deferred.resolve(res.data);
                            }, function(err){
                            	deferred.reject();
                            	console.log('admin portal load error: unable to resolve users;')
                            	$state.go('site.home');
                            })
                            return deferred.promise;
                    	}
                    },
                    views: {
                        ""  : { 
                        	templateUrl: "app/modules/admin/admin.html",
                        	controller: "AdminCtrl"
                        },
                        "portal@admin": { template: "Write whatever you want, it's your virtual admin portal." },
                        "software@admin": { 
                        	templateUrl: "app/modules/admin/admin.software.html" ,                        
                            controller: function($scope){
                                    $scope.clients = ["HP", "IBM", "MicroSoft"];
                            }
                        }
                    }
                })
                .state('admin.mgmt', {
                	url : "/mgmt",
                	template : '<div class="alert alert-warning">Admin mgmt title</div>'
                });
 
        }])
        .run(['$rootScope', 'ApiService', function ($rootScope, ApiService) {
        		$rootScope.authheader = {'Authorization' : 'Basic ' + btoa('trustedclient:secret')};
        	
        		if(localStorage.getItem('authorization')){
        			ApiService.apiSendGet('getuser/').then(function(res){
        				$rootScope.user = res.data;
        			});
        			$rootScope.authenticated = true;
        		}
        		
//        		$http.defaults.headers.common['Authorization'] = btoa('trustedclient:secret');
        		
            }]);
