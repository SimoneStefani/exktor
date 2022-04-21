dependencies {
    api("org.postgresql:postgresql:42.3.4")
    api("org.jetbrains.exposed:exposed-core:0.37.3")
    api("org.jetbrains.exposed:exposed-dao:0.38.2")
    api("org.jetbrains.exposed:exposed-jdbc:0.38.2")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    api(project(":ktor-sql"))
}
