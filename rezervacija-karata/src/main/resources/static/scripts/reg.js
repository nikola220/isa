  var app = angular.module("regApp", []);
  app.controller("regCtrl", function($scope, $http) {
	  $scope.invalidPassword = function() {
		  if($scope.regForm.$dirty){
			  var user = JSON.parse(JSON.stringify($scope.user));
			  return user.password != user.password2;
		  }
		  return true;
	  }
      $scope.regFunc = function () {
          var user = JSON.parse(JSON.stringify($scope.user));
          $http.post("/api/registration/signup", user).then(
             function success(response) {
              $scope.resp = response.data;
          }, function error(response) {
              $scope.resp = response.data;
          });
      }
  });
  