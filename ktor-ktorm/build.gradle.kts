dependencies {
    api("org.postgresql:postgresql:42.4.2")
    api("org.ktorm:ktorm-core:3.5.0")
    api("org.ktorm:ktorm-support-postgresql:3.5.0")
    api("org.ktorm:ktorm-global:3.5.0")
    api("org.ktorm:ktorm-jackson:3.5.0")
    api(project(":ktor-sql"))
}
