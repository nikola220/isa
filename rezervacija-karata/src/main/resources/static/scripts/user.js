var app = angular.module('app');
app.controller('uCtrl', function($scope, $http) {
      $http.get('/user/details').then(
         function success(response) {
        	 console.log(response.data);
        	 $scope.test = response.data;
          $scope.user = response.data;
      }, function error(response) {
    	  console.log(response.data);
      });
  });