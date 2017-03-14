pipeline {
  agent any
  stages {
    stage('Sonar-Scanner') {
      steps {
        withSonarQubeEnv('SonarQube Scanner 2.9.0.670') {
          sh '${scannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=mc:mcu -Dsonar.projectName=MineCartUtilities -Dsonar.projectVersion=${BUILD_DISPLAY_NAME}'
        }
        waitForQualityGate()
      }
    }
  }
}