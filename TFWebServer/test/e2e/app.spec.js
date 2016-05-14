describe('end to end search tests',function(){
	it ("should have search results",function(done){
		browser.get('http://localhost:8080/search/ulti');
		element.all(by.repeater('company in companies'))
		.then(function(company){
			var first = company[0];
			var text = first.getText();
			expect(text).toEqual('Ultimate Software');
			done();
		})
	})
})