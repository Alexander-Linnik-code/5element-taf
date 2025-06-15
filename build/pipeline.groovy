pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }

         stage('Second hello') {
            steps {
                sh 'javac ${WORKSPACE}/src/test/java/by/itacademy/linnik/api/TestApi5Element.java'
            }
        }

         stage('Third hello') {
            steps {
                sh 'java ${WORKSPACE}/src/test/java/by/itacademy/linnik/api/TestApi5Element.java'
            }
        }
    }
}
