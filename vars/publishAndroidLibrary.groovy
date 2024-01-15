#!/usr/bin/env groovy

/**
 * This method is used in Jenkins to upload Android AAB/APKs to Google Play.
 * It utilizes the 'androidApkUpload' step from the Google Play Android Publisher plugin.
 *
 * @since 1.0.0
 *
 * @see androidApkUpload - Jenkins pipeline step for uploading Android AAB/APKs to Google Play.
 * @link https://www.jenkins.io/doc/pipeline/steps/google-play-android-publisher/ - More information about the Google Play Android Publisher plugin.
 * @global String googleCredentialsId - Specifies the Google Play credentials ID (optional).
 * @global String trackName - Specifies the release track (internal, alpha, beta, production) for the app files (optional).
 * @global String filesPattern - Pattern matching AABs or APKs to be uploaded (optional).
 * @global String applicationId - The Application ID of the Android app (optional).
 * @global String rolloutPercentage - The percentage of users to roll out the upload (optional).
 * @global String additionalVersionCodes - Version codes from a previous release to include in the new release (optional).
 * @global String deobfuscationFilesPattern - Patterns matching ProGuard mapping files for crash report deobfuscation (optional).
 * @global String expansionFilesPattern - Patterns matching expansion files to be associated with the APKs (optional).
 * @global String inAppUpdatePriority - Priority for in-app updates (optional).
 * @global String nativeDebugSymbolFilesPattern - Patterns matching zip files containing native library symbols (optional).
 * @global String recentChangeList - "What's new" text for the uploaded file(s) (optional).
 * @global String releaseName - Name to identify the release in Google Play Console UI (optional).
 * @global boolean usePreviousExpansionFilesIfMissing - Use previously uploaded expansion files if missing (optional).
 *
 * @param Map googlePlay - A map containing configuration details for the APK upload.
 * @return void - This method performs an APK upload operation in Jenkins but does not return a value.
 */
 
def call(Map googlePlay){
  androidApkUpload (
    googleCredentialsId: googlePlay.credentialsId,
    trackName: googlePlay.trackName,
    filesPattern: googlePlay.filesPattern,
    applicationId: googlePlay.applicationId,
    rolloutPercentage: googlePlay.rolloutPercentage
  ) 
}