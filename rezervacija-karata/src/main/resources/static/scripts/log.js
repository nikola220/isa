var app = angular.module('app');
app.controller('logCtrl', function($scope, $http) {
	  
    $scope.logFunc = function () {
    	var user = JSON.parse(JSON.stringify($scope.user));
        $http.post('/user/login', user).then(
           function success(response) {
            $scope.resp = response.data;
        }, function error(response) {
            $scope.resp = response.data;
        });
    }
});
  
