var app = angular.module('app');
app.controller('activationCtrl', function($scope, $routeParams, $http) {
	var token = $routeParams.param;
	$scope.activated = "verification status"
        $http.post('/user/activation/' + token).then(
           function success(response) {
            $scope.activated = response.data;
        }, function error(response) {
            $scope.activated = response.data;
        });
});