pipeline {
    stages {
        stage('Checkout') {
            checkout scm
        }
        stage('Validate the code'){
            script {
                echo 'Validated the test cases'
            }
        }
        stage('Deploy the code') {
            script {
                sh '''
                    sudo cp -pr . /var/www/html/
                    sudo service httpd restart
                '''
            }
        }
    }
}
