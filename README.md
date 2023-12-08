# kc-attribute-mapper-spi
A Keycloak identity provider SPI to fix an issue with attribute mappers not firing during Token Exchange

## Generate POM

```shell
mvn archetype:generate -DgroupId=org.bradhead.keycloak -DartifactId=keycloak-extension -DarchetypeArtifactId=maven-archetype-quickstart -D-DinteractiveMode=false
```

## Build the extension

```shell
cd keycloak-extension && mvn clean install && cd .
```

## Deploy to Keycloak

```shell
cp keycloak-extension/target/keycloak-extension-bradhead-1.0-SNAPSHOT.jar /opt/keycloak/providers/.
kc.sh build
