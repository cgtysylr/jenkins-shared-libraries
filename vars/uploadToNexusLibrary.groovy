#!/usr/bin/env groovy

/**
 * Uploads a file to a Nexus repository using provided credentials and paths.
 * This function encapsulates the complexity of the upload process in a single call,
 * making it reusable across different Jenkins pipelines.
 *
 * @since 1.0.0
 *
 * @see withCredentials - Jenkins pipeline step for securely using credentials.
 * @link https://www.jenkins.io/doc/pipeline/steps/credentials-binding/ - More information about binding credentials in Jenkins.
 * @global String credentialsId - The ID of the Jenkins credentials to use for Nexus authentication.
 * @global String nexusUrl - The base URL of the Nexus repository.
 * @global String nexusRepo - The specific Nexus repository where the file will be uploaded.
 * @global String filePath - The local file path of the file to be uploaded.
 * @global String remotePath - The path in the Nexus repository where the file will be placed.
 *
 * @param Map params - A map containing parameters for the Nexus file upload operation.
 * @return void - This method performs the file upload operation in Jenkins but does not return a value.
 */

def call(Map params) {
    withCredentials(
      [
        usernamePassword(
          credentialsId: params.credentialsId,
          usernameVariable: 'USERNAME',
          passwordVariable: 'PASSWORD')
      ]
    ) {
        def uploadPath = "${params.nexusUrl}/repository/${params.nexusRepo}/${params.remotePath}"
        sh "curl -u ${USERNAME}:${PASSWORD} --upload-file ${params.filePath} ${uploadPath}"
      }
}