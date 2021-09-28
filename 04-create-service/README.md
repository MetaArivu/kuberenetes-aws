# Service

https://kubernetes.io/docs/concepts/services-networking/service/

You are POD are never exposed directly to outside, it has to be exposed with help of service.

Service is abstract way to expose an application running on a set of Pods as a network service.
With Kubernetes you don't need to modify your application to use an unfamiliar service discovery mechanism. Kubernetes gives Pods their own IP addresses and a single DNS name for a set of Pods, and can load-balance across them.

In Kubernetes, a Service is an abstraction which defines a logical set of Pods and a policy by which to access them (sometimes this pattern is called a micro-service). The set of Pods targeted by a Service is usually determined by a selector

### Demo Service
kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/04-create-service/1-service.yml

This will automatically create Classic Load Balancer on AWS, once it is created go to Route 53 and define sub domain and map to new load balancer.

### Command go list  PODS 
  - kubectl get svc --all-namespaces
  - kubectl get svc --namespace microserviceworkshop
  - kubectl get svc -o wide --namespace microserviceworkshop


### Delete Demo POD
kubectl delete -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/create-first-pod/1-service.yml






