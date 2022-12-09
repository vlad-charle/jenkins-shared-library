#!/usr/bin/env groovy

def call(String imageName) {
    sh "docker build -t vladsanyuk/app:$imageName ."
}