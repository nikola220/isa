  var app = angular.module("regApp", []);
  app.controller("regCtrl", function($scope, $http) {
      $scope.regFunc = function () {
          var user = JSON.parse(JSON.stringify($scope.user));
          $http.post("/api/registration/login", user).then(
             function success(response) {
              $scope.resp = response.data;
          }, function error(response) {
              $scope.resp = response.data;
          });
      }
  });
  
