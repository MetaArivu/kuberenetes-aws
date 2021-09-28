# Simple Helloworld Application

Complie the application: mvn clean install

Create Docker and push to docker hub
- docker build -t helloworld .
- docker tag helloworld:latest ketangote/helloworld
- docker push ketangote/helloworld
