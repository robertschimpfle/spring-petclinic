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
        timeout(time:"1000") {
          sh 'mvn install -Dmaven.test.skip=true'
        }
      }
    }
    stage('test') {
      steps {
        parallel(
          "test": {
            sh 'mvn test'
            
          },
          "analysis": {
            sh 'mvn javadoc:javadoc -Dmaven.javadoc.failOnError=false'
            
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
