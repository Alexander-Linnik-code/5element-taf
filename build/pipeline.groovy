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
                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\Singleoton\\Singleton.java"'

                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\CartPage.java"'
                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\CatalogPage.java"'
                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\HomePage.java"'
                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\LaptopPage.java"'
                bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\LoginPage.java"'

                bat 'javac -d . "%WORKSPACE%\\src\\test\\java\\by\\itacademy\\linnik\\ui\\TestCart.java"'
            }
        }

        stage('Run') {
            steps {
                bat 'java -cp . test.ui.TestCart'
            }
        }
    }
}