#!/usr/bin/env groovy

/**
 * Builds a Flutter app using the 'flutter build appbundle' command in Jenkins.
 * This method allows for additional parameters to be specified for the build command.
 *
 * @since 1.0.0
 *
 * @param Map params - A map containing build parameters. Default parameters are set for 'mainDartFile' and 'buildNumber'.
 *                     'mainDartFile' key specifies the main Dart file to be used in the build (default: 'lib/main.dart').
 *                     'buildNumber' key specifies the build number, usually from the Jenkins BUILD_NUMBER environment variable.
 *                     Additional parameters can be specified as needed.
 *
 * additional parameters example => '--target-platform android-arm,android-arm64,android-x64'
 * 
 * @return void - This method does not return a value but performs the build operation in Jenkins.
 */

def call(Map params = [:]) {
    def mainDartFile = params.get('mainDartFile', 'lib/main.dart')
    def buildNumber = params.get('buildNumber', env.BUILD_NUMBER)
    def additionalParams = params.get('additionalParams', '')

    sh "flutter build appbundle ${mainDartFile} --release --build-number=${buildNumber} ${additionalParams}"
}
