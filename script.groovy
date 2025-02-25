def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub_credential', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t fonyuya/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push fonyuya/demo-app:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
