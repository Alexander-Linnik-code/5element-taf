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
                bat 'javac -d . ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }

         stage('Run') {
            steps {
                bat 'java -cp . ${WORKSPACE}/src/test/ui/TestCart.java'
            }
        }
    }
}
