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
                bat 'javac -d . /src/test/ui/TestCart.java'
            }
        }

         stage('Run') {
            steps {
                bat 'java -cp . /src/test/ui/TestCart.java'
            }
        }
    }
}
