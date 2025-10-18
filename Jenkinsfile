
pipeline {
    agent {
        label 'JavaBuildServer'
    }
    tools {
        maven 'localMaven'
    }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Archiving the artifacts'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }

        stage ('Deployments'){
                    steps {
                        echo "Deploying the Artifacts into tomcat Server"
                        deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-credentials', path: '', url: 'http://44.200.67.95:8080')], contextPath: null, war: '*.war'                    }
            }
        }
}
