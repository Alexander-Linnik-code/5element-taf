pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }

         stage('Build') {
            steps {
                sh 'javac ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }

         stage('Run') {
            steps {
                sh 'java ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }
    }
}
