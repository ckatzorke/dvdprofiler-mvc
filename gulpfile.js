var gulp = require('gulp'), rimraf = require('gulp-rimraf'), bower = require('gulp-bower'), jshint = require('gulp-jshint'), stylish = require('jshint-stylish');

var libPath = 'src/main/resources/static/lib';
/*
 * clean
 */
gulp.task('clean', function() {
	'use strict';
	return gulp.src([ 'bower_components/', libPath ], {
		read : false
	}).pipe(rimraf());
});

/*
 * bower install
 */
gulp.task('bower', function() {
	'use strict';
	return bower().pipe(gulp.dest('bower_components'));
});

/**
 * Subtask for bowercopy - jQuery
 */
gulp.task('bower-jquery-copy', [ 'bower' ], function() {
	'use strict';
	return gulp.src([ 'bower_components/jquery/dist/*' ]).pipe(
			gulp.dest(libPath + '/jquery'));
});

/**
 * Subtask for bowercopy - bootstrap
 */
gulp.task('bower-bootstrap-copy', [ 'bower' ], function() {
	'use strict';
	return gulp.src([ 'bower_components/bootstrap/dist/**/*' ]).pipe(
			gulp.dest(libPath + '/bootstrap'));
});

/**
 * bowercopy - copy the dependencies from bower_components to lib
 */
gulp.task('bowercopy', [ 'bower-jquery-copy', 'bower-bootstrap-copy' ],
		function() {
			'use strict';
		});

/*
 * JSHint
 */
gulp.task('lint', function() {
	'use strict';
	return gulp.src(
			[ './www/app/js/**/*.js', 'test/**/*.js', 'gulpfile.js',
					'karma.conf.js' ]).pipe(jshint()).pipe(
			jshint.reporter(stylish));
});

/**
 * default
 */
gulp.task('default', [ 'bowercopy', 'lint' ], function() {
	'use strict';
	// default stuff
});