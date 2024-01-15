#!/usr/bin/env groovy

/**
 * This method is used in Jenkins to check out code from a Git repository.
 * It leverages the GitSCM plugin for Jenkins to perform checkout operations based on the provided repository details.
 *
 * @since 1.0.0
 *
 * @see checkout - Jenkins pipeline step that checks out source code from a repository.
 * @link https://www.jenkins.io/doc/pipeline/steps/git/ - More information about the Git plugin in Jenkins.
 * @global String $class - The type of source code management system. Here, it is set to 'GitSCM'.
 * @global Array branches - The branches to be checked out.
 * @global Array userRemoteConfigs - Configuration details for the remote Git repository, including URL and credentials.
 *
 * @param Map git - A map containing repository details. Keys include 'branch', 'url', and 'credentialsId'.
 *                  The 'branch' key specifies the branch to be checked out.
 *                  The 'url' key provides the repository URL.
 *                  The 'credentialsId' key refers to the Jenkins credentials for repository access.
 * @return void - This method does not return a value but performs a checkout operation in Jenkins.
 */
 
def call(Map git){
  checkout(
    [
        $class: 'GitSCM', 
        branches: [[name: git.branch]],
        userRemoteConfigs: [
            [
                url: git.url,
                credentialsId: git.credentialsId
            ]
        ]
    ]
  )
}