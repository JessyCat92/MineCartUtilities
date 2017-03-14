pipeline {
  agent any
  stages {
    stage('Sonar-Scanner') {
      steps {
        script {
          withSonarQubeEnv('TerraTex SonarQube') {
            sh "${tool 'SonarQubeScanner'}/bin/sonar-scanner -Dsonar.projectVersion=${BUILD_DISPLAY_NAME}"
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
    stage('Build-Package') {
      steps {
        script {
          def mvnHome = tool 'Maven'
          sh "${mvnHome}/bin/mvn clean package -DskipTests"
        }
      }
    }
    stage('Publish Artifacts') {
      archiveArtifacts artifacts: '**/target/*.jar'
    }
  }
}