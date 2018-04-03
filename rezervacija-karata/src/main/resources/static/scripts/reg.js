function myController($scope){
    $scope.submitMyForm=function(){
        /* while compiling form , angular created this object*/
        var data=$scope.fields;  
        /* post to server*/
        //$http.post(url, data);  
        alert(data);
    }

}