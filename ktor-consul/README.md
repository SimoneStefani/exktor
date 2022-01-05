# Consul extension for Ktor

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

This module allows to automatically register the application at the [Consul](https://www.consul.io/) and
integrate [Ktor HTTP clients](https://ktor.io/clients/) with Consul to discovery hosts.

## Quick start

#### Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.SimoneStefani.exktor:ktor-consul:1.1.1")
}
```

#### Registering application

```kotlin
fun Application.module() {
    install(ConsulFeature) {
        serviceName = "MyService" // by default - "application" or ktor.application.id from config file
        host = "my-host.com" // by default - "localhost" or connector.host
        port = 80 // by default - 80 or ktor.deployment.port from config file
        consulUrl = "http://192.168.99.100:8500"
        config { // this: Consul.Builder
            // ...
        }
        registrationConfig { // this: ImmutableRegistration.Builder
            // ...
            // Health check example:
            // check(Registration.RegCheck.http("$host:$port/health", 120))
        }
    }
}
```

#### Consul client

```kotlin
val client = HttpClient(Apache) {
    install(ConsulClientFeature) {
        consulUrl = "http://192.168.99.100:8500"
        serviceName = "MyService"
        loadBalancer { // this: List<ServiceHealth>
            // Your implementation:
            // Return one of the ServiceHealth
            // by default:
            getOrNull(0)
        }
        // Also, one more load balancer implementation available:
        loadBalancer(roundRobin())
        config { // this: Consul.Builder
            // ...
        }
    }
    install(JsonFeature)
}
```
