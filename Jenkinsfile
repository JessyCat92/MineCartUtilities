pipeline {
  agent any
  stages {
    stage('Sonar-Scanner') {
      steps {
        withSonarQubeEnv('SonarQubeScanner') {
          sh '${scannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=mc:mcu -Dsonar.projectName=MineCartUtilities -Dsonar.projectVersion=${BUILD_DISPLAY_NAME}'
        }
        waitForQualityGate()
      }
    }
  }
}