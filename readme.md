# Car Configurator


## Build
Use JDK 17 (for example with sdkman: https://sdkman.io/ `sdk use java 17.0.3-tem`)

```
mvn clean install
docker build -t de.mbti/carconfigurator .
```

### Run
```
docker run -p 8080:8080 de.mbti/carconfigurator
```

