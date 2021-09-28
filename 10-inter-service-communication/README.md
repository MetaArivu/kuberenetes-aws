# Inter Service Communication

https://kubernetes.io/docs/concepts/services-networking/connect-applications-service/

A Kubernetes Service is an abstraction which defines a logical set of Pods running somewhere in your cluster, that all provide the same functionality. When created, each Service is assigned a unique IP address (also called clusterIP). This address is tied to the lifespan of the Service, and will not change while the Service is alive. Pods can be configured to talk to the Service, and know that communication to the Service will be automatically load-balanced out to some pod that is a member of the Service.

- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/10-inter-service-communication/1-productms-pod.yml
- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/10-inter-service-communication/1-productms-service.yml
- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/10-inter-service-communication/2-productreviewms-pod.yml
- kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/10-inter-service-communication/2-productreviewms-service.yml


Now when you fetch product service api to reterive product details based on product ID, internally product service will communicate with product review service and get reviews for that product and return reviews along with product details. Access below URL too see product with reviews

- http://a3adc96ec41da4ce4ab391da505b733b-1513600150.ap-south-1.elb.amazonaws.com/productms/product/1



