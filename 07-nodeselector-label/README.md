# Nodeselector

https://kubernetes.io/docs/concepts/scheduling-eviction/assign-pod-node/

You can constrain a Pod so that it can only run on particular set of Node(s). There are several ways to do this and the recommended approaches all use label selectors to facilitate the selection.

First you need to add label to node using below command
- kubectl get nodes --show-labels : This show labels for nodes
- kubectl label nodes ip-172-20-44-75.ap-south-1.compute.internal server-type=high-specs

NOTE: To see this result for this you should atleast have more then one node running and one node without above label

### Apply 
kubectl apply -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/07-nodeselector-label/nodeselector.yml






