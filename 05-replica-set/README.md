# Replica Set

https://kubernetes.io/docs/concepts/workloads/controllers/replicaset/

A ReplicaSet's purpose is to maintain a stable set of replica Pods running at any given time. As such, it is often used to guarantee the availability of a specified number of identical Pods.

A ReplicaSet ensures that a specified number of pod replicas are running at any given time. However, a Deployment is a higher-level concept that manages ReplicaSets and provides declarative updates to Pods along with a lot of other useful features. Therefore, we recommend using Deployments instead of directly using ReplicaSets, unless you require custom update orchestration or don't require updates at all.

### Create Replica Set
kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/05-replica-set/1-replica-set.yml

This will creates two pod of helloworld

### Command go list  PODS 
  - kubectl get pods --all-namespaces
  - kubectl get pods --namespace microserviceworkshop
  - kubectl get pods -o wide --namespace microserviceworkshop
  - kubectl logs helloworld-pod --namespace microserviceworkshop


### Delete Demo POD
kubectl delete -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/05-replica-set/1-replica-set.yml





