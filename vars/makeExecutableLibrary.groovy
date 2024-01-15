#!/usr/bin/env groovy

/**
 * This method is used in Jenkins pipelines to make specified script files executable.
 * It runs the 'chmod +x' command for each script file provided as an argument.
 *
 * @since 1.0.0
 *
 * @see sh - Jenkins pipeline step for executing shell commands.
 * @link https://www.jenkins.io/doc/pipeline/steps/workflow-durable-task-step/#sh-shell-script - More information about the shell script step.
 *
 * @param String... scriptFiles - Variable number of script file names to make executable.
 * @return void - This method makes the specified files executable in Jenkins but does not return a value.
 */

def call(String... scriptFiles) {
    scriptFiles.each { scriptFile ->
        sh "chmod +x ${scriptFile.trim()}"
    }
}