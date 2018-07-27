#!/usr/bin/env groovy

def call(String buildResult, String ch, String branch, String commit, String author) {
  if ( buildResult == "SUCCESS" ) {
    slackSend channel: ch, color: "good", message: "Build ${env.BUILD_NUMBER} de ${env.JOB_NAME} \nbranch: ${branch} \ncommit: ${commit} \nautor: ${author} \nSUCESSO"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend channel: ch, color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was failed"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend channel: ch, color: "warning", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was unstable"
  }
  else {
    slackSend channel: ch, color: "danger", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} its resulat was unclear"	
  }
}
