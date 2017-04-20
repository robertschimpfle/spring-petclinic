pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '/home/ec2-user/tools/MVN_3.3.9/bin/mvn install -Dmaven.test.skip=true'
      }
    }
  }
  environment {
    JAVA_HOME = '/home/ec2-user/tools/Java_8'
  }
}