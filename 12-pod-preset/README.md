# Preset (Inject data in POD)

NOTE: This is deprecated

https://v1-19.docs.kubernetes.io/docs/tasks/inject-data-application/podpreset/


In the manifest, you can see that the preset has an environment variable definition called DB_PORT. The selector specifies that the preset will act upon any Pod that is labeled applayer:backend.

kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/12-pod-preset/preset.yml

kubectl create -f https://raw.githubusercontent.com/ketan-gote/kuberenetes-aws/main/12-pod-preset/1-productms-pod.yml

kubectl get pods

kubectl get pod productms-pod -o yaml - This will show enviornment variable injected.



