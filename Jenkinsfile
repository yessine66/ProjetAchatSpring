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
                git branch: 'main', url: 'https://github.com/yessine66/ProjetAchatSpring.git'
            }
        }
        
        stage("TestEnv"){
            steps{
                sh"""mvn -version"""
            }
        }
    }
}
