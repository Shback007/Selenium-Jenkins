pipeline {

    agent any

    tools {
        jdk 'Java_21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Shback007/Selenium-Jenkins.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            junit '**/surefire-reports/*.xml'
        }

        success {
            echo 'Tests Passed Successfully!'
        }

        failure {
            echo 'Tests Failed!'
        }
    }
}