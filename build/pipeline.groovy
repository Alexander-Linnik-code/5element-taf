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
                bat 'javac /src/test/ui/TestCart.java'
            }
        }

         stage('Run') {
            steps {
                bat 'java /src/test/ui/TestCart.java'
            }
        }
    }
}
