# DEMO 1

This will focus on deploying product and product review service deployment with istio enabled.

Execute below YML in following order

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/1-productms-pod.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/1-productms-svc.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/1-productms-vr-svc.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/2-productreviewms-pod.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/2-productreviewms-service.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/2-productreeviewms-vr-svc.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/14-istio/demo-1/gateway.yml

Once everything is deployed access

