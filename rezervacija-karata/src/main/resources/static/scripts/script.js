var app = angular.module('app', [ 'ngRoute' ]);
app.config(function($routeProvider) {
	$routeProvider.when('/registration', {
		templateUrl : 'registration.html',
		controller : 'regCtrl'
	}).when('/login', {
		templateUrl : 'login.html',
		controller : 'logCtrl'
	}).when('/user', {
		templateUrl : 'user.html',
		controller : 'uCtrl'
	}).when('/activation/:param', {
		templateUrl : 'activation-page.html',
		controller : 'activationCtrl'
	}).when('/update-user', {
		templateUrl : 'update-form.html',
		controller : 'uCtrl'
	});
});
