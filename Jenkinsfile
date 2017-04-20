node {
    def mvnHome
    mvnHome = tool 'MVN 3.3'
    env.JAVA_HOME = tool 'Java 8'
   
   stage('Preparation') { // for display purposes
        git 'https://github.com/comquent/spring-petclinic.git'
   }
 
   stage('Build') {
      sh "'${mvnHome}/bin/mvn' install -Dmaven.test.skip=true"
   }
 
   stage('Test') {
      sh "'${mvnHome}/bin/mvn' test"
   }

   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}