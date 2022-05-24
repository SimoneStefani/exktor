dependencies {
    api("org.postgresql:postgresql:42.3.6")
    api("org.jetbrains.exposed:exposed-core:0.38.2")
    api("org.jetbrains.exposed:exposed-dao:0.38.2")
    api("org.jetbrains.exposed:exposed-jdbc:0.38.2")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")
    api(project(":ktor-sql"))
}
