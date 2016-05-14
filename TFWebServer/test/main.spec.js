var assert = chai.assert;
var expect = chai.expect;

describe("Twitter Financial App",function(){
	describe("the search service",function(){
		beforeEach(function(){
			module('SearchData');
			inject(function($injector){
				searchService = $injector.get("searchService");
				$httpBackend = $injector.get("$httpBackend");
			});
		})

		it("should have a property companies, an array",function(){
			expect(searchService.companies).to.be.an('array');
		});

		it ("should call the backend",function(){
			$httpBackend.expectGET("http://localhost:9001/search")
				.respond(200,[]);
			$httpBackend.flush();
		})
	})

	describe("the search controller",function(){
		beforeEach(function(){
			module('SearchData');
			inject(function($injector,$rootScope){
				$scope = $rootScope.$new();
				searchService = $injector.get("searchService");
				$httpBackend = $injector.get("$httpBackend");
				$controller = $injector.get("$controller");
			})
		})

		it ("should store an array of companies in scope",function(){
			$controller("SearchController",{$scope:$scope,searchService:searchService});
			assert.isArray($scope.companies);
		})
	})

	describe("the login filter",function(){
		beforeEach(function(){
			module("UserAccounts");
			inject(function($injector){
				proper = $injector.get("$filter")("proper");
			});
		})

		it ("should verify proper email",function(){
			expect("mherr059@fiu.edu").to.equal("mherr059@fiu.edu");			
		});

		it ("should throw an error on an empty input",function(){
			assert.throws(function(){
				proper(undefined)
			});
		})
	})

	describe("successfull company view page",function(){
		beforeEach(function(){
			module("CompanyData");
		})

		it ("should display the company data (social (sentiment image) and stock)",function(){
			inject(function($rootScope,$compile){
			  $rootScope.company = {name:'Ultimate Software'};
				var element = $compile('<company ticker=company.ticker/>')($rootScope);
				$rootScope.$digest();
				var compTicker = element.text();
				expect(compTicker).to.equal("ulti");
			})
		})
	})
})
