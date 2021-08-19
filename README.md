## Kafka Sample Application using Aiven, Java and Micronaut

This project contains a sample application using Aiven's hosted Kafka solution. It's built in Java using
Micronaut.

There's a guide that walks through how the application has been built: [Aiven Getting Started Guide](docs/Aiven%20Getting%20Started%20Guide.md)

To be able to run the application and connect to Aiven you need to supply the passwords for the key store and
trust store in any of the Micronaut supported ways, e.g. through environment variables:

```shell
CLIENT_KEYSTORE_PASSWORD=<PASSWORD>
CLIENT_TRUSTSTORE_PASSWORD=<PASSWORD>
```
