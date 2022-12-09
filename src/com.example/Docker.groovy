#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuild(String imageName) {
        script.sh "docker build -t vladsanyuk/app:$imageName ."
    }

    def dockerLogin() {
        script.withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $PASS | docker login -u $USER --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push vladsanyuk/app:$imageName"
    }
    
}