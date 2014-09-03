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
          'app/styles/bootstrap.min.css': 'bootstrap/dist/css/bootstrap.min.css',
          'app/styles/bootstrap-theme.min.css': 'bootstrap/dist/css/bootstrap-theme.min.css',
          'app/scripts/vendor/bootstrap.min.js': 'bootstrap/dist/js/bootstrap.min.js',
          'app/fonts/': 'bootstrap/dist/fonts/*',
          'app/scripts/vendor/jquery.min.js': 'jquery/dist/jquery.min.js',
          'app/scripts/vendor/jquery.min.map': 'jquery/dist/jquery.min.map'
        }
      }
    }
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-bowercopy');

  // Default task(s).
  grunt.registerTask('default', ['bowercopy']);

};