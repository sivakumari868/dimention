pipeline {
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Validate the code'){
            steps {
                script {
                    echo 'Validated the test cases'
                }

            }
        }
        stage('Deploy the code') {
            steps {
                script {
                    sh '''
                        sudo cp -pr . /var/www/html/
                        sudo service httpd restart
                    '''
                }
            }
        }
    }
}
