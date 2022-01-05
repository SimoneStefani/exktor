# Elastic Client extension for Ktor

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

This module allows connecting to the [ElasticSearch](https://www.elastic.co/) on application start and use created
client instance anywhere inside the `Application` context.

## Quick start

#### Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.SimoneStefani.exktor:ktor-elastic:1.1.0")
}
```

#### Configure client

```kotlin
fun Application.module() {
    install(ElasticFeature) {
        hosts = arrayOf(HttpHost.create("http://192.168.99.100:9300"))
        defaultHeaders = arrayOf(BasicHeader("MyHeader", "MyValue"))
        failureListener = {
            // Implementation of the RestClient.FailureListener
        }
        httpClientConfigCallback = {
            // Implementation of the RestClientBuilder.HttpClientConfigCallback
        }
        requestConfigCallback = {
            // Implementation of the RestClientBuilder.RequestConfigCallback
        }
        pathPrefix = "..."
        nodeSelector = NodeSelector.ANY
        strictDeprecationMode = true
    }
}
```

#### Elastic client

Anywhere inside `Application` context you could use variable `elasticSearchClient`
(`org.elasticsearch.client.RestClient`) to access to the ElasticSearch cluster.
