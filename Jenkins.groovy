pipeline {
    agent any
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
        stage('Deploy the Development environment') {
            when {
                expression { env.BRANCH_NAME == 'development' }
            }
            steps {
                script {
                    sh '''
                        sudo cp -pr . /var/www/html/
                        sudo service httpd restart
                    '''
                }
            }
        }

        stage('Deploy the Produaction environment') {
            when {
                expression { env.BRANCH_NAME == 'main' }
            }
            steps {
                script {
                    sh '''
                        sudo cp -pr . /var/www/html/
                        sudo service httpd restart
                    '''
                }
            }
        }

        stage('Deploy the UAT environment') {
            when {
                expression { env.BRANCH_NAME == 'uat' }
            }
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
