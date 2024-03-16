## Setup
* Install Windows Docker desktop
    * enable windows container
    ```Enable-WindowsOptionalFeature -Online -FeatureName $("Microsoft-Hyper-V", "Containers") -All```
    ```& $Env:ProgramFiles\Docker\Docker\DockerCli.exe -SwitchDaemon .```


* Install OpenJDK 17
    * Set env
        ```set PATH=C:\dev\pleiades-2022-06-java-win-64bit-jre_20220619\java\17\bin;%PATH%```
        ```set JAVA_HOME=C:\dev\pleiades-2022-06-java-win-64bit-jre_20220619\java\17```

## Build and test Jar 
* Build jar
  ``` mvnw package```

* Test jar
    ```java -jar target/spring-boot-docker-complete-0.0.1-SNAPSHOT.jar```
    Access http://localhost:8080/?name=12345 from browser
    
## Build and test container
* Create Azure Registory container

* Build container
    ```docker build -t <ACR Name>.azurecr.io/<path and tag> .```
    or
    ```docker build -t <ACR Name>.azurecr.io/<path and tag> --platform windows/amd64 .```

    image name example: ```myacr01.azurecr.io/app1:v1.0.1```

* Test container
    ```docker run -p 8080:8080 <ACR Name>.azurecr.io/<path and tag>```
    Access http://localhost:8080/?name=12345 from browser


## Push container
```
az login
az account set -s <Subscription ID>
az acr login --name <ACR Name>
docker push <ACR Name>.azurecr.io/<path and tag>
```

