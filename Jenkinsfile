def scm_url = 'https://github.com/comquent/spring-petclinic.git'
def container_name = 'ci_spring-petclinic'
node {

    stage('Checkout') {
        deleteDir()
        git(url: scm_url)
    }

    stage('Build') {
        sh 'sudo docker build -t mypetclinic .'
    }
    
    stage('Test') {
        try {
            sh "sudo docker run --name ${container_name} -e SCM_URL='${scm_url}' -p 8081:8080 myjenkins"
        } finally {
            sh "sudo docker stop ${container_name}"
            sh "sudo docker rm ${container_name}"
        }
    }
}