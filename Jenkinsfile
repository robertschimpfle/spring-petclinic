node {
    def mvnHome
    mvnHome = tool 'MVN 3.3'
    env.JAVA_HOME = tool 'Java 8'
   
   stage('Preparation') { // for display purposes
        git 'https://github.com/spring-projects/spring-petclinic.git'
   }
 
   stage('Build') {
      sh "'${mvnHome}/bin/mvn' install -Dmaven.test.skip=true"
   }
 
   stage('Test') {
       parallel (
           "test":     {
               sh "'${mvnHome}/bin/mvn' test"},
           "analysis": {
               sh "'${mvnHome}/bin/mvn' findbugs:findbugs"
               sh "'${mvnHome}/bin/mvn' checkstyle:checkstyle"
               sh "'${mvnHome}/bin/mvn' pmd:pmd"},
           "docu":     {
               sh "'${mvnHome}/bin/mvn' javadoc:javadoc -Dmaven.javadoc.failOnError=false"}
       )
   }

   stage('Report') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
    
   stage('Deploy') {
      sleep 10
      echo "PerClinic deployed"
   }
}
