pipeline {
    agent any
     environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'docker-cred'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'veetikol/shoppingcart'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/veetikol/ShoppingCartAssignment.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                recordCoverage(tools: [[parser: 'JACOCO']])
            }
        }

         stage('Docker Build') {
                     steps {
                         script {
                             sh 'docker build -t shoppingcartassignment .'
                         }
                     }
                 }
                 stage('Docker Push') {
                             steps {
                                 script {
                                     withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                                         sh 'echo $DOCKERHUB_PASSWORD | docker login -u $DOCKERHUB_USERNAME --password-stdin'
                                         sh 'docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}'
                                         sh 'docker push ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}'
                                     }
                                 }
                             }
                         }
    }
}