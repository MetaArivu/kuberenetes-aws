# Create Namespace

https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/

Kubernetes supports multiple virtual clusters backed by the same physical cluster. These virtual clusters are called namespaces.

kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/02-create-namespace/1-namespace.yml

Above command will create namespace called "microserviceworkshop", we will be using this namespace to create POD/Service etc.

kubectl get namespace - command to List Namespace use 

