def scm_url = 'https://github.com/comquent/spring-petclinic.git'
def container_name = 'ci_spring-petclinic'
node {

    stage('Checkout') {
        deleteDir()
        git(url: scm_url)
    }

    stage('Build') {
        withMaven(....) {
            sh 'mvn package'
        }
    }
    
    stage('Test') {
        // mvn...
    }
}
