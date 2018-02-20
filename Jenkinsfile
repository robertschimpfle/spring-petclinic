def scm_url = 'https://github.com/comquent/spring-petclinic.git'
def container_name = 'ci_spring-petclinic'
node {

    stage('Checkout') {
        deleteDir()
        git(url: scm_url)
    }

    stage('Build') {
        withMaven(jdk: 'JDK 8', maven: 'MVN 3.5') {
            sh 'mvn package'
        }
    }
    
    stage('Test') {
        // mvn...
    }
}
