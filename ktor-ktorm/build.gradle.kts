dependencies {
    api("org.postgresql:postgresql:42.4.0")
    api("org.ktorm:ktorm-core:3.4.1")
    api("org.ktorm:ktorm-support-postgresql:3.5.0")
    api("org.ktorm:ktorm-global:3.4.1")
    api("org.ktorm:ktorm-jackson:3.4.1")
    api(project(":ktor-sql"))
}
