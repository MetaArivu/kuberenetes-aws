# ISTIO

https://istio.io/latest/

Istio extends Kubernetes to establish a programmable, application-aware network using the powerful Envoy service proxy. Working with both Kubernetes and traditional workloads, Istio brings standard, universal traffic management, telemetry, and security to complex deployments.

To get started with istio refer below link

https://istio.io/latest/docs/setup/getting-started/#download

### Create Namespace with istio enabled 
kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/namspace.yml

Once istio is enabled at namespace, any deployment is done in that namespace will be enabled with istio


### Demo 1
This will focus on deploying product and product review service deployment with istio enabled

### Demo 2
This will focus on deploying v2 version of product service and redirecting traffic to new version based on custom header


