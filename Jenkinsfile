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
    }
}
