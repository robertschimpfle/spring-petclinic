node {
    stage('Checkout') {
        checkout scm
    }
    stage('Build') {
        withMaven(jdk: 'JDK 8', maven: 'MVN.3.5') {
            sh "mvn clean install -Dmaven.test.skip=true"
        }
    }   
    stage('Test & Analyse') {
        withMaven(jdk: 'JDK 8', maven: 'MVN.3.5') {
            parallel (
                test: { sh "mvn test" },
                analyse: { sh "mvn findbugs:findbugs" }
            )
        }
    }   
    stage('report') {
        junit '**/target/surefire-reports/TEST-*.xml'
    }
}
