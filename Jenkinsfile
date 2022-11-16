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
                echo 'Pulling... ';
                git branch: 'aziz',
 		url: 'https://github.com/yessine66/ProjetAchatSpring.git'
            }
        }
        
        stage("TestEnv"){
            steps{
                sh"""mvn -version"""     
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
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
             /* stage("nexus deploy"){
                 steps{
                 // nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/SpringP/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'tn.esprit.rh', nexusUrl: '192.168.100.200:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '1.0.0'
                //    sh 'mvn deploy'
               }
         }*/

         stage('Build Docker Image') {
               steps {
               sh 'docker build -t medazizbennasr/spring_achat:1.0.0 .'
                }
         }

         stage('Push Docker Image') {
                steps {
                sh 'docker push medazizbennasr/spring_achat:1.0.0'
             }
        }
         stage('DOCKER COMPOSE') {
                            steps {
                               sh 'docker-compose up -d --build'
                            }
                       }
    }
}

