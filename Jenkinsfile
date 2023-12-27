pipeline {
    agent {
        tools { 
        maven 'maven' 
    }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn clean test' 
            }
        }
    }
}
