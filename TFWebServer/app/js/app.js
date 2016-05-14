'use strict';

angular.module('tfa', ['tfa.filters', 'tfa.services', 'tfa.directives', 'tfa.controllers'])
	.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $routeProvider.when('/search', {templateUrl: 'partials/dummy.html', controller: 'SearchCtrl'});            
        $routeProvider.when('/login', {templateUrl: 'partials/user-creation.html', controller: 'UserCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});        
        $httpProvider.defaults.useXDomain = true;
		delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }]);
