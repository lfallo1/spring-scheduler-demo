
	angular.module('springDemoApp').service('MessageService', ['toaster', 'ToasterConstants', function(toaster, ToasterConstants){

		var service = {};
		
		//configure different toasters
		var stickyToasterOptions = {
		  'toaster-id' : ToasterConstants.STICKY_TOASTER,
		  'close-button': true,
		  'debug': false,
		  'position-class': 'toast-top-full-width',
		  'onclick': null,
		  'show-duration': 200,
		  'time-out': 0,
		  'extended-timeOut': 1000
		};
		
		var generalToasterOptions = {
		  'toaster-id' : ToasterConstants.GENERAL_TOASTER,
		  'closeButton': false,
		  'debug': false,
		  'positionClass': 'toast-top-right',
		  'onclick': null,
		  'showDuration': '200',
		  'hideDuration': '1000',
		  'timeOut': '5000',
		  'extendedTimeOut': '1000',
		  'showEasing': 'swing',
		  'hideEasing': 'linear',
		  'showMethod': 'fadeIn',
		  'hideMethod': 'fadeOut'
		};
		
		service.getStickyToasterOptions = function(){
			return stickyToasterOptions;
		};
		
		service.getGeneralToasterOptions = function(){
			return generalToasterOptions;
		};

		
		//--- setup available methods---
		
		//show a sticky message
		service.showSticky = function(params){
			params['toasterId'] = ToasterConstants.STICKY_TOASTER;
			show(params);
		};
		
		//show a general message
		service.showGeneral = function(params){
			params['toasterId'] = ToasterConstants.GENERAL_TOASTER;
			show(params);
		};
		
		var show = function(params){
			toaster.pop(params);
		};
		
		return service;

	}]);
