var trombiApp = angular.module('trombiApp', ['ui.bootstrap','ngRoute', 'ngMaterial']);

trombiApp.config(function($routeProvider, $locationProvider) {
	$routeProvider
	 .when('/index' , {templateUrl: 'view/default.html'})
	 .when('/data', {templateUrl: 'view/tabTrombi.html', controller : 'TabTrombiController'})	
	 .otherwise({redirectTo: '/index'});
});

 trombiApp.config(function($httpProvider) {
      //Enable cross domain calls
      $httpProvider.defaults.useXDomain = true;
 
      //Remove the header used to identify ajax call  that would prevent CORS from working
      delete $httpProvider.defaults.headers.common['X-Requested-With'];
  });
  