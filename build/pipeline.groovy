pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }

        stage('Test Cart') {
            steps {
               // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\Singleoton\\Singleton.java"'

                // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\CartPage.java"'
                // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\CatalogPage.java"'
                // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\HomePage.java"'
                // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\LaptopPage.java"'
                // bat 'javac -d . "%WORKSPACE%\\src\\main\\java\\by\\itacademy\\linnik\\pagesui\\LoginPage.java"'

                // bat 'javac -d . "%WORKSPACE%\\src\\test\\java\\by\\itacademy\\linnik\\ui\\TestCart.java"'

                // bat 'java -cp . test.ui.TestCart'

                echo 'test cart'
            }
        }

        stage('Test laptop') {
            steps {
                echo 'test laptop'
            }
        }

        stage('Test login page') {
            steps {
                echo 'test ogin page'
            }
        }
    }
}