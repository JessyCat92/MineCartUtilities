pipeline {
  agent any
  stages {
    stage('Sonar-Scanner') {
      steps {
        script {
          def scannerHome = tool 'SonarQubeScanner';
          withSonarQubeEnv('TerraTex SonarQube') {
            sh '${scannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=mc:mcu -Dsonar.projectName=MineCartUtilities -Dsonar.projectVersion=${BUILD_DISPLAY_NAME}'
          }

          timeout(time: 1, unit: 'HOURS') {
            def qg = waitForQualityGate()
            if (qg.status != 'OK') {
              error "Pipeline aborted due to quality gate failure: ${qg.status}"
            }
          }
        }
      }
    }
  }
}