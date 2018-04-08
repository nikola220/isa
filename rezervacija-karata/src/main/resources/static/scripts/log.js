var app = angular.module('app');
app.controller('logCtrl', function($scope, $http, $window) {
	  
    $scope.logFunc = function () {
    	var user = JSON.parse(JSON.stringify($scope.user));
        $http.post('/user/login', user).then(
           function success(response) {
            $scope.resp = response.data;
            $window.location.href = '/';
        }, function error(response) {
            $scope.resp = response.data;
        });
    }
});
  
