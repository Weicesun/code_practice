var Person = require("./lib/Person");

var ben = new Person("Ben franklin");
var george = new Person("Geroge washington");

george.on('speak', function(said) {
	console.log(`$(this.name) -> ${said}`);
})
ben.on('speak', function(said) {
	console.log(`${this.name}: ${said}`);
});

ben.emit('speak', "YOu may delay, but time will not");
george.emit('speak', "It is far better tp be alone than to be in bad company");