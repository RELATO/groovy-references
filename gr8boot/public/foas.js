function Foas($scope, $http) {
    //var path = '/foas/Aaron';
    var path = '/foas/' + $scope.who;
    $http.get(path).
        success(function(data) {
            $scope.subject = data.subject;
            $scope.command = data.command;
            $scope.author = data.author;
            $scope.created = data.created;
        });
}
