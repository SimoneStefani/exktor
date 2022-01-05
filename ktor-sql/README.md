# HikariCP extension for Ktor

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

This module allows setting up HikariCP connection pool at application start.

## Quick start

#### Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.SimoneStefani.exktor:ktor-sql:1.1.1")
}
```

#### Connection pool configuration

```kotlin
fun Application.module() {
    install(SqlFeature) { // this: HikariConfig
        // ...
    }
}
```

Almost all configs could be configured at the configuration file:

* dataSource.dataSourceClassName
* dataSource.jdbcUrl
* dataSource.username
* dataSource.password
* dataSource.autoCommit
* dataSource.connectionTimeout
* dataSource.idleTimeout
* dataSource.maxLifetime
* dataSource.connectionTestQuery
* dataSource.minimumIdle
* dataSource.maximumPoolSize
* dataSource.poolName
* dataSource.initializationFailTimeout
* dataSource.isolateInternalQueries
* dataSource.allowPoolSuspension
* dataSource.readOnly
* dataSource.registerMbeans
* dataSource.catalog
* dataSource.connectionInitSql
* dataSource.driverClassName
* dataSource.transactionIsolation
* dataSource.validationTimeout
* dataSource.leakDetectionThreshold
* dataSource.schema

For more information please
read [HikariCP official documentation](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby).

**Note**: Programmatic configuration will override configs from configuration file

#### Access to the connection pool

Anywhere inside `Application` context you could use variable `dataSource`
(`javax.sql.DataSource`) to access to the connection pool.

#### Events

`ktor-sql` module listen to standard ktor events to create/close connection poll and producing own events:

* _ApplicationStarted_
    * **DBConnecting** - before create connection pool
    * **DBConnected** - when connection pool was successfully created
* _ApplicationStopPreparing_
    * **DBClosing** - before closing connection pool
    * **DBClosed** - connection poll was closed
