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
                bat 'javac ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }

         stage('Run') {
            steps {
                bat 'java ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }
    }
}
