module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    bowercopy: {
      options: {
        srcPrefix: 'bower_components'
      },
      bootstrap: {
        options: {
          destPrefix: 'src/main/resources/static'
        },
        files: {
          'lib/bootstrap/bootstrap.min.css': 'bootstrap/dist/css/bootstrap.min.css',
          'lib/bootstrap/bootstrap-theme.min.css': 'bootstrap/dist/css/bootstrap-theme.min.css',
          'lib/bootstrap/bootstrap.min.js': 'bootstrap/dist/js/bootstrap.min.js',
          'lib/bootstrap/fonts/': 'bootstrap/dist/fonts/*',
          'lib/jquery/jquery.min.js': 'jquery/dist/jquery.min.js',
          'lib/jquery/vendor/jquery.min.map': 'jquery/dist/jquery.min.map'
        }
      }
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-bowercopy');

  // Default task(s).
  grunt.registerTask('default', ['bowercopy']);

};