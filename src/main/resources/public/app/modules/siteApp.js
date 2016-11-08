var siteModule = angular.module('siteModule', ['ui.router']);

siteModule.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('site.home', { //child of site view, has two named views
        	url : '/home',        	
        	views : {
        		'' : {
        			templateUrl : 'app/modules/home/home.html',
                	controller: 'HomeCtrl'
        		},
                
                'filmtable@site.home' : {
        			templateUrl : 'app/shared/filmStatusTable/filmStatusTable.html',
                	controller: 'FilmStatusTableController'        			
        		}
        	}
        })
        .state('site.login', {
            url : '/login',
        	templateUrl : 'app/modules/login/login.html',
        	controller: 'LoginCtrl'
        });
});
    