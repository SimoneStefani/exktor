# Exposed extension for Ktor

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

This module allows integrating with [Exposed](https://github.com/JetBrains/Exposed) ORM and access a datasource instance
anywhere inside the `Application` context.

## Quick start

#### Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.SimoneStefani.exktor:ktor-exposed:1.1.0")
}
```
