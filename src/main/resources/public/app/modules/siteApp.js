var siteModule = angular.module('siteConfig', ['ui.router']);

siteModule.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('site.home', { //child of site view, has two named views
        	url : '/',        	
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
    