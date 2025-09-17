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
			deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-credentials', path: '', url: 'http://3.216.95.186:8080'), tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-credentials', path: '', url: '')], contextPath: 'simple-web-app', war: '**/*.war'
			#deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat-credentials', path: '', url: 'http://3.216.95.186:8080')], contextPath: null, onFailure: false, war: '**/*.war'
                    }
            }
        }
}
