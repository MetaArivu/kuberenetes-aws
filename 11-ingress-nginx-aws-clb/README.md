# NGINX Ingress controller 


- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/0-nginx-mandatory.yml

- kubectl get pods --all-namespaces

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/0-ingress-nginx.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/1-productms-pod.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/1-productreviewms-pod.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/1-productms-service.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/1-productreviewms-service.yml

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/11-ingress-nginx-aws-clb/3-ingress.yml

This will create ingress controller, use below command to get get CLB ADDRESS and use to access API of both the services

- kubectl get ing --all-namespaces

URL:
- http://a5f4bd50d9fd74c248f47361c78b2fdf-416266379.ap-south-1.elb.amazonaws.com/productms/
- http://a5f4bd50d9fd74c248f47361c78b2fdf-416266379.ap-south-1.elb.amazonaws.com/productreviewms/
- http://a5f4bd50d9fd74c248f47361c78b2fdf-416266379.ap-south-1.elb.amazonaws.com/productms/product/
- http://a5f4bd50d9fd74c248f47361c78b2fdf-416266379.ap-south-1.elb.amazonaws.com/productms/product/



