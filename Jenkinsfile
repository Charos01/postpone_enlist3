pipeline {
    agent any
     tools {
        
         maven 'maven3'
         jdk 'jdk'
         dockerTool 'docker'
         
         }
    
    stages{
        stage('Initialize'){
            steps {
            
            sh '''
            mvn clean install -DskipTests
            '''
             sh '''
             mvn compile com.google.cloud.tools:jib-maven-plugin:3.2.1:build -Dimage=charosregistry.azurecr.io/charos/postpone  -Djib.to.auth.username=charosRegistry  -Djib.to.auth.password=W+uuvdVvHnau2lqgaqRX7bOeAfexMYxB
             
             '''
             sh '''
             whoami
             
             '''
            
            }
       }
        stage('Ansible'){
            steps { 
                ansiblePlaybook becomeUser: 'jenkins', installation: 'ansible', inventory: './hosts.yml', playbook: 'docker-playbook.yml'
            }
        }
        }

}
     
