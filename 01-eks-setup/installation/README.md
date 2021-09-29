# Setup of AWS, KUBECTL & EKSCTL

https://www.eksworkshop.com/

## 1 - Setup AWS CLI
On Mac
- curl "https://awscli.amazonaws.com/AWSCLIV2.pkg" -o "AWSCLIV2.pkg"
- sudo installer -pkg ./AWSCLIV2.pkg -target /
- aws --version

This should provide AWS CLI version
aws-cli/2.2.35 Python/3.8.8 Darwin/20.6.0 exe/x86_64 prompt/off

Once above step is configure AWS
- aws configure
- AWS Access Key ID [None]: Enter user access key
- AWS Secret Access Key [None]: Enter user secret access key
- Default region name [None]: Enter region
- Default output format [None]: json

Test AWS CLI : aws ec2 describe-vpcs

## 2 - Setup KUBECTL
https://docs.aws.amazon.com/eks/latest/userguide/install-kubectl.html

- mkdir aws-kubectl
- cd aws-kubectl
- curl -o kubectl https://amazon-eks.s3.us-west-2.amazonaws.com/1.21.2/2021-07-05/bin/darwin/amd64/kubectl
- chmod +x ./kubectl
- configure path  e.g: export PATH=/Users/user/opt/aws-kubectl/kubectl:$PATH

Test KUBECTL: kubectl version --short --client


## 3 - Setup EKSCTL
https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html

On Mac
- brew tap weaveworks/tap
- brew install weaveworks/tap/eksctl
- eksctl version


