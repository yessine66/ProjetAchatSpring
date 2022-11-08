pipeline{
    agent any
    
    stages {
        
        stage("TestPipeline"){
            steps{
                echo 'Pipeline is working ~~~~~~~~~~~~~~~~~  '
            }
        }
        
        stage('Github') {
            steps {
                 echo 'Pulling...';
                 git branch: 'daliBack',
                 url : 'https://github.com/yessine66/ProjetAchatSpring.git';
            }
        }
        stage('MVN CLEAN'){
            steps{
                 echo 'Pulling...';
                 sh 'mvn clean'
            }
        }
        stage('MVN COMPILE'){
            steps{
                sh 'mvn compile'
            }
        }
        stage('MVN PACKAGE'){
             steps{
                 sh 'mvn package'
             }
        }
         stage('MVN SONARQUBE '){
              steps{
                  sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=admin123'
              }
         }
         /*stage("nexus deploy"){
               steps{
               nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/Devops_Project/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'tn.esprit.rh', nexusUrl: '192.168.56.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'http://192.168.56.10:8081/repository/nexus-snapshots', version: '1.0'
               }
         }*/

         stage('Build Docker Image') {
               steps {
               sh 'docker build -t medalibnasr/dockerfile_achat:2.2.4 .'
                }
         }

         stage('Push Docker Image') {
                steps {
                withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                sh "docker login -u medalibnasr -p ${dockerHubPwd}"
                }
                sh 'docker push medalibnasr/dockerfile_achat:2.2.4'
                 }
         }
         stage('DOCKER COMPOSE') {
                            steps {
                               sh "docker login -u medalibnasr -p Le4jul96!"
                               sh 'docker-compose up -d --build'
                            }
                       }
    }
}
