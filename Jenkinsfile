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
         stage("nexus deploy"){
                          steps{
                           nexusArtifactUploader artifacts: [[artifactId: 'ProjetAchatSpring', classifier: '', file: '/var/lib/jenkins/workspace/projetDevops/target/docker-spring-boot.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'tn.esprit.rh.achat', nexusUrl: '192.168.56.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '2.2.4'
                          }
                          }
    }
}
