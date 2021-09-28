# POD

https://kubernetes.io/docs/concepts/workloads/pods/

Pods are the smallest deployable units of computing that you can create and manage in Kubernetes.

A Pod is a group of one or more containers, with shared storage and network resources, and a specification for how to run the containers.


### Demo POD
kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/03-create-first-pod/1-pod.yml

### Command go list  PODS 
  - kubectl get pods --all-namespaces
  - kubectl get pods --namespace microserviceworkshop
  - kubectl get pods -o wide --namespace microserviceworkshop
  - kubectl logs helloworld-pod --namespace microserviceworkshop


### Delete Demo POD
kubectl delete -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/03-create-first-pod/1-pod.yml





