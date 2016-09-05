var fs = require("fs");
if (fs.existsSync("lib")) {
	console.log("Directory exit");
} else {
	fs.mkdir("lib1", function(err) {
		if (err) {
			console.log(err);
		} else {
			console.log("created");
		}
	});
}
fs.renameSync("./core.js", "./core.json");
console.log("rename success");;
fs.rename("./lib/Person.js", "./node.md", function(err) {
	if (err) {
		console.log(err);
	} else {
		console.log("move rename");
	}
})
