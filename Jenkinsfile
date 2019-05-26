// Powered by Infostretch 

timestamps {

	node () {
	
		stage ('Recuperation projet') {
	 	 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'fbd74405-5f6e-47d9-bb75-0953374e6f5a', url: 'https://github.com/tawnydev/ProjetJavaTest']]]) 
		}
		stage ('Build package') {
	 			// Maven build step
			withMaven(maven: 'Maven 3.6.0') { 
	 			if(isUnix()) {
	 				sh "mvn clean package" 
				} else { 
	 				bat "mvn clean package" 
				} 
	 		} 
		}
		stage ('Analyse de la qualité'){
		    withMaven(maven: 'Maven 3.6.0') { 
	 			if(isUnix()) {
	 				sh "mvn sonar:sonar \
  						-Dsonar.projectKey=com.kevin.projetjavatest \
  						-Dsonar.host.url=http://localhost:9000 \
  						-Dsonar.login=cbd12baf3eadeaf4cbb9d0f1ff9d6d433d98459e" 
				} else { 
	 				bat "mvn sonar:sonar \
  						-Dsonar.projectKey=com.kevin.projetjavatest \
  						-Dsonar.host.url=http://localhost:9000 \
  						-Dsonar.login=cbd12baf3eadeaf4cbb9d0f1ff9d6d433d98459e" 
				} 
	 		} 		    
		}
		stage ('Notification fin de job par mail') {
			/*
			Please note this is a direct conversion of post-build actions. 
			It may not necessarily work/behave in the same way as post-build actions work.
			A logic review is suggested.
			*/
			// Mailer notification
			step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'kevin.matrix@hotmail.fr', sendToIndividuals: false])
	 
		}
	}
}