#!/usr/bin/env groovy

def call(String buildResult, String ch) {
  if ( buildResult == "SUCCESS" ) {
    slackSend channel: ch, color: "good", message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
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
