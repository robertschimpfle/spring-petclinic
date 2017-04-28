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
           "test":     {sh "'${mvnHome}/bin/mvn' test"},
           "analysis": {sh "'${mvnHome}/bin/mvn' findbugs:findbugs"},
           "docu":     {sh "'${mvnHome}/bin/mvn' javadoc:javadoc -Dmaven.javadoc.failOnError=false"}
       )
   }

   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}
