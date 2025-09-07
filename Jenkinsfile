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
                        deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: '39c655ec-260f-4e06-8988-3c03f17ef416', path: '', url: 'http://23.22.211.197:8080')], contextPath: null, war: '**/*.war'
                    }
            }
        }
}
