// Powered by Infostretch 

timestamps {

node () {

	stage ('Projet Java Test - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'fbd74405-5f6e-47d9-bb75-0953374e6f5a', url: 'https://github.com/tawnydev/ProjetJavaTest']]]) 
	}
	stage ('Projet Java Test - Build') {
 			// Maven build step
	withMaven(maven: 'Maven 3.6.0') { 
 			if(isUnix()) {
 				sh "mvn clean package " 
			} else { 
 				bat "mvn clean package " 
			} 
 		} 
	}
	stage ('Projet Java Test - Post build actions') {
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