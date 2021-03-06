var app = angular.module('app');
app.controller('uCtrl', function($scope, $http, $window) {
      $http.get('/user/details').then(
         function success(response) {
        	 console.log(response.data);
          $scope.user = response.data;
      }, function error(response) {
    	  console.log(response.data);
      });
      
      $scope.updFunc = function () {
          var user = JSON.parse(JSON.stringify($scope.user));
          $http.post('/user/update', user).then(
             function success(response) {
              $scope.user = response.data;
              $window.location.href = '#!/user';
          }, function error(response) {
          });
      }
      
  });