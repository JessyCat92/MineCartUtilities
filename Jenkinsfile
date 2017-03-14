pipeline {
  agent any
  stages {
    stage('Sonar-Scanner') {
        script {
            def scannerHome = tool 'SonarQube Scanner 2.9.0.670';
        }
        withSonarQubeEnv('SonarQube Scanner 2.9.0.670') {
          sh '${scannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://localhost:9000 -Dsonar.projectKey=mc:mcu -Dsonar.projectName=MineCartUtilities -Dsonar.projectVersion=${BUILD_DISPLAY_NAME}'
        }
    }
    stage("Quality Gate"){
      timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
        def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
        if (qg.status != 'OK') {
          error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
      }
    }
  }
}