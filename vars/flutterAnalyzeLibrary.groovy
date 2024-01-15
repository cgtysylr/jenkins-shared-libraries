/**
 * Analyzes a Flutter project using the 'flutter analyze' command in Jenkins.
 *
 * @param Map params - A map containing analysis parameters.
 *                     'flutterRoot' specifies the Flutter SDK root directory.
 *                     'noPub' (boolean) prevents running 'flutter pub get' before analysis.
 *                     'fatalInfos' (boolean) treats informational issues as fatal errors.
 *                     'fatalWarnings' (boolean) treats warning issues as fatal errors.
 *                     'fatalLints' (boolean) treats lint issues as fatal errors.
 *                     'currentPackage' (boolean) analyzes only the current package and its dependencies.
 *
 * @return void - Performs the analysis operation in Jenkins.
 */

def call(Map params = [:]) {
    def flutterRoot = params.get('flutterRoot', '')
    def noPub = params.get('noPub', false)
    def fatalInfos = params.get('fatalInfos', false)
    def fatalWarnings = params.get('fatalWarnings', false)
    def fatalLints = params.get('fatalLints', false)
    def currentPackage = params.get('currentPackage', false)

    def command = "flutter analyze"

    if (!flutterRoot.isEmpty()) {
        command += " --flutter-root=${flutterRoot}"
    }

    if (noPub) {
        command += " --no-pub"
    }

    if (fatalInfos) {
        command += " --fatal-infos"
    } else {
        command += " --no-fatal-infos"
    }

    if (fatalWarnings) {
        command += " --fatal-warnings"
    } else {
        command += " --no-fatal-warnings"
    }

    if (currentPackage) {
        command += " --current-package"
    }

    sh command
}
