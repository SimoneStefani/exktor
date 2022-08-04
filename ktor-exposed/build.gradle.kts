dependencies {
    api("org.postgresql:postgresql:42.4.1")
    api("org.jetbrains.exposed:exposed-core:0.39.1")
    api("org.jetbrains.exposed:exposed-dao:0.39.1")
    api("org.jetbrains.exposed:exposed-jdbc:0.39.2")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    api(project(":ktor-sql"))
}
