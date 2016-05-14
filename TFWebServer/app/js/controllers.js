'use strict';

/* Controllers */

var app = angular.module('tfa.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});

app.controller('SearchCtrl', ['$scope', '$routeParams', 'SearchFactory', '$location',
    function ($scope, $routeParams, UserFactory, $location) {

        // callback for ng-click 'updateUser':
        $scope.doSearch = function () {
            UserFactory.update($scope.user);
            $location.path('/search');
        };

        $scope.user = SearchFactory.show({id: $routeParams.id});
    }]);

app.controller('UserCtrl', ['$scope', 'UsersFactory', '$location',
    function ($scope, UsersFactory, $location) {

        // callback for ng-click 'createNewUser':
        $scope.createNewUser = function () {
            UsersFactory.create($scope.user);
            $location.path('/users/add');
        }
    }]);
