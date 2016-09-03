var spawn = require("child_process").spawn;

var cp = spawn("ndoe", ["alwaysTalking"]);

cp.stdout.on("data", function(data) {
	console.log(`STDOUT: ${data.toString()}`);
});
