var trombiApp = angular.module('trombiApp', ['ui.bootstrap','ngRoute', 'ngMaterial']);

trombiApp.config(function($routeProvider, $locationProvider) {
	$routeProvider
	 .when('/index' , {templateUrl: 'view/default.html'})
	 .when('/data', {templateUrl: 'view/tabTrombi.html', controller : 'TabTrombiController'})	
	 .otherwise({redirectTo: '/index'});
});