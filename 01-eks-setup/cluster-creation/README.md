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
                       --node-type=t2.micro \
                       --nodes=1 \
                       --nodes-min=1 \
                       --nodes-max=2 \
                       --node-volume-size=20 \
                       --ssh-access \
                       --ssh-public-key=eks-demo \
                       --managed \
                       --asg-access \
                       --external-dns-access \
                       --full-ecr-access \
                       --appmesh-access \
                       --alb-ingress-access 

## Verify Nodes & Cluster

- kubectl get nodes -o wide
- eksctl get cluster           
- Goto EKS AWS UI and check cluster configuration
- eksctl get nodegroup --cluster=eks-demo-cluster
- ssh -i eks-demo.cer ec2-user@13.235.238.193

## Delete Cluster
eksctl delete cluster eks-demo-cluster
