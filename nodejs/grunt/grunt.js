module.exports = function(grunt) {
	grunt.iniConfig({
		jshint: {
			files:["*.js", "lib/*.js", "test/*.js"],
			options: {
				esnext: true,
				global: {
					jQuery: true
				}
			}
		},
		less: {
			production: {
				files: {
					"public/css/style.css":["less/*.less"]
				}
			}
		},
		autoprefixer: {
			single_file: {
				src: "public/css/style.css",
				dest: "public/css/style.css"
			}
		}
	});
	grunt.loadNpmTask("grunt-contrib-jshint");
	grunt.loadNpmTask("grunt-contrib-less");
	grunt.loadNpmTask("grunt-contrib-autoprefixer");
	grunt.registerTask(["grunt-contrib-autoprefixer"])
	grunt.registerTask("default", ["jshint"]);
	grunt.registerTask("css",["less"]);
};