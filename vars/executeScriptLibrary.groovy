#!/usr/bin/env groovy

/**
 * This method is used in Jenkins pipelines to execute a specified shell script using bash.
 * It runs the script with the 'bash' command.
 *
 * @since 1.0.0
 *
 * @see sh - Jenkins pipeline step for executing shell commands.
 * @link https://www.jenkins.io/doc/pipeline/steps/workflow-durable-task-step/#sh-shell-script - More information about the shell script step.
 *
 * @param String scriptFile - The name of the shell script file to execute.
 * @return void - This method executes the specified shell script in Jenkins but does not return a value.
 */

def call(String scriptFile) {
    sh "bash ${scriptFile}"
}