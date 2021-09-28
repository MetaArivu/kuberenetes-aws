
# Kubernetes on AWS using Kops

## 1 Create EC2 Instance
Create EC2 Instance on AWS and Login with your credentials

## 2 Create S3 Bucket 
aws s3 mb s3://ketan-gote.link --region ap-south-1

## 3 Create IAM Role and attach to EC2 Instance
Role which need to be attached are specified in below URL
https://kops.sigs.k8s.io/getting_started/aws/

## 4 Install Kops on EC2
curl -LO https://github.com/kubernetes/kops/releases/download/$(curl -s https://api.github.com/repos/kubernetes/kops/releases/latest | grep tag_name | cut -d '"' -f 4)/kops-linux-amd64
chmod +x kops-linux-amd64
sudo mv kops-linux-amd64 /usr/local/bin/kops

## 5 Install kubectl
curl -LO https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
chmod +x ./kubectl
sudo mv ./kubectl /usr/local/bin/kubectl

## 6 Create Key oon EC2
ssh-keygen -f .ssh/id_rsa

## 6 Create private hosted zone in AWS Route53
Here you define your DNS 

## 7 Define enviornment in .bashrc

export KOPS_CLUSTER_NAME=ketan-gote.link
export KOPS_STATE_STORE=s3://ketan-gote.link

## 8 Create Cluster

kops create cluster \
--name=ketan-gote.link \
--state=s3://ketan-gote.link \
--zones=ap-south-1a,ap-south-1b \
--node-count=1 \
--node-size=t2.medium \
--master-size=t2.medium \
--dns-zone=ketan-gote.link

OR


kops create cluster \
--name=${KOPS_CLUSTER_NAME} \
--state=${KOPS_STATE_STORE} \
--zones=ap-south-1a,ap-south-1b \
--node-count=2 \
--node-size=t3.micro \
--master-size=t3.micro \
--dns-zone=ketan-gote.link

Once command is executed, it will provide suggestion as below

Suggestions:
 * list clusters with: kops get cluster
 * edit this cluster with: kops edit cluster ketan-gote.link
 * edit your node instance group: kops edit ig --name=ketan-gote.link nodes-ap-south-1a
 * edit your master instance group: kops edit ig --name=ketan-gote.link master-ap-south-1a

## 9 Configure Cluster

kops update cluster --name ketan-gote.link --yes --admin

This command will take few miinutes (4-5 min), You can validate cluster using below command

kops validate cluster

## 10 List Nodes and Master
kubectl get nodes - This command will display 2 nodes and 1 master
ssh -i ~/.ssh/id_rsa ubuntu@api.ketan-gote.link - This command can be used to login to master

## 11 Delete Cluster

kops delete cluster  --yes


