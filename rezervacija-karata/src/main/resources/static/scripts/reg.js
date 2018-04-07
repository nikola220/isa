var app = angular.module('app');
app.controller('regCtrl', function($scope, $http) {
	  
    $scope.regFunc = function () {
        var user = JSON.parse(JSON.stringify($scope.user));
        $http.post('/user/signup', user).then(
           function success(response) {
            $scope.resp = response.data;
        }, function error(response) {
            $scope.resp = response.data;
        });
    }
});
  
