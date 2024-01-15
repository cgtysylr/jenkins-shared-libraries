#!/usr/bin/env groovy

/**
 * This method is used in Jenkins to create a zip file from the specified directory and parameters.
 * It utilizes the 'zip' step with configurable parameters.
 *
 * @since 1.0.0
 *
 * @see zip - Jenkins pipeline step for creating a zip file.
 * @link https://www.jenkins.io/doc/pipeline/steps/pipeline-utility-steps/#zip-create-zip-file - More information about the zip step.
 * @global String zipName - The name/path of the zip file to create.
 * @global String dir - The path of the base directory to create the zip from.
 * @global boolean archive - (Optional) If true, the zip file will be archived as an artifact of the current build. Default is false.
 * @global String exclude - (Optional) Ant style pattern of files to exclude from the zip.
 * @global String glob - (Optional) Ant style pattern of files to include in the zip.
 * @global boolean overwrite - (Optional) If true, will overwrite an existing zip file with the same name. Default is false.
 * @global boolean defaultExcludes - (Optional) If true, uses default exclusions. Default is true.
 *
 * @param Map params - A map containing parameters for the zip operation. 
 *                     Expected keys are 'zipName', 'dir', 'archive', 'exclude', 'glob', 'overwrite', and 'defaultExcludes'.
 * @return void - This method performs the zip operation in Jenkins but does not return a value.
 */

def call(Map params){
  zip zipFile: params.name, 
      dir: params.dir, 
      archive: params.archive ?: false, 
      exclude: params.exclude ?: null, 
      glob: params.glob ?: null, 
      overwrite: params.overwrite ?: false, 
      defaultExcludes: params.defaultExcludes ?: true
}
