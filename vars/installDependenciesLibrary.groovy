#!/usr/bin/env groovy

/**
 * Installs a list of packages using apt-get in a Jenkins pipeline.
 *
 * @param packages A list of package names to be installed.
 */
 
def call(List<String> packages) {
    def packagesToInstall = packages.join(' ')
    sh "apt-get update && apt-get install -y ${packagesToInstall}"
}