# spinner

A simple Spring Boot app to spin up CPU.  

perform this command many times to get the CPU spinning:

```shell
curl localhost:8080/spin
```

If the app is deployed to PCF and configured with an autoscaler service, then you should see it adding/removing instances.
