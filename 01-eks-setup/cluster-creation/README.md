# EKS Cluster

EKS has four objects
- EKS Control Plane (Managed by AWS, you only provision it)
- Worker Nodes & Node Group (It is group of EC2 instance where application runs)
- Farget Profiles (Serverless)
- VPC (Secure neetworking)

Create Cluster

## Create Cluster
eksctl create cluster --name=eks-demo-cluster \
                      --region=ap-south-1 \
                      --zones=ap-south-1a,ap-south-1b \
                      --without-nodegroup 

NOTE:  We are using without-nodegroup otherwise cluster will be created production grade by default

## Get List of clusters
eksctl get cluster           

## Associate IAM OIDC Provider for our EKS Cluster

eksctl utils associate-iam-oidc-provider \
    --region ap-south-1 \
    --cluster eks-demo-cluster \
    --approve

## Create Node Group

eksctl create nodegroup --cluster=eks-demo-cluster \
                       --region=ap-south-1 \
                       --name=ap-south-1-ng-public1 \
                       --node-type=t3.medium \
                       --nodes=2 \
                       --nodes-min=2 \
                       --nodes-max=3 \
                       --node-volume-size=20 \
                       --ssh-access \
                       --ssh-public-key=eks-demo \
                       --managed \
                       --asg-access \
                       --external-dns-access \
                       --full-ecr-access \
                       --appmesh-access \
                       --alb-ingress-access 

Note: 
- You should create Key Pair on AWS EC2 and download it. 
- Once it is downloaded give permission using chmod 400 <filename>

## Verify Nodes & Cluster

- kubectl get nodes -o wide
- eksctl get cluster           
- Goto EKS AWS UI and check cluster configuration
- eksctl get nodegroup --cluster=eks-demo-cluster
- ssh -i eks-demo.cer ec2-user@13.235.238.193

## Delete Cluster
eksctl delete cluster eks-demo-cluster

## Delete Node Group
eksctl delete nodegroup --cluster=eks-demo-cluster --name=ap-south-1-ng-public1

when we are deleting the cluster using eksctl, its core components should be in same state which means roll back the change we have done to security group before deleting the cluster
