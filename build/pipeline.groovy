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
                bat 'javac -d . "%WORKSPACE%src\\test\\java\\by\\itacademy\\linnik\\ui\\TestCart.java"'
            }
        }

        stage('Run') {
            steps {
                bat 'java -cp . test.ui.TestCart'
            }
        }
    }
}