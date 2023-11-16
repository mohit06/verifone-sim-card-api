pipeline {
	agent any

	tools {
		jdk 'jenkins-jdk'
	}

	stages {

		stage('Build'){
			steps {
				sh "mvn clean install -DskipTests package"
			}
		}

		stage('Test'){
			steps{
				sh "mvn test"
			}
		}

		stage('Deploy') {
			steps {
			    sh "mvn jar:jar deploy:deploy"
			}
		}
	}
}
