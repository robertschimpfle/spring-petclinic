pipeline {
  agent any
  environment {
    JAVA_HOME = '/home/ec2-user/tools/Java_8'
  }
  tools {
    maven "MVN 3.3"
  }
  stages {
    stage('build') {
      steps {
        sh '/home/ec2-user/tools/MVN_3.3.9/bin/mvn install -Dmaven.test.skip=true'
      }
    }
    stage('test') {
      steps {
        parallel(
          "test": {
            sh '/home/ec2-user/tools/MVN_3.3.9/bin/mvn test'
            
          },
          "analysis": {
            sh '/home/ec2-user/tools/MVN_3.3.9/bin/mvn javadoc:javadoc -Dmaven.javadoc.failOnError=false'
            
          }
        )
      }
    }
    stage('Report') {
      steps {
        echo 'Fertig'
      }
    }
  }
}
