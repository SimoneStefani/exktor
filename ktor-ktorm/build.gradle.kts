dependencies {
    api("org.postgresql:postgresql:42.3.4")
    api("org.ktorm:ktorm-core:3.4.1")
    api("org.ktorm:ktorm-support-postgresql:3.4.1")
    api("org.ktorm:ktorm-global:3.4.1")
    api("org.ktorm:ktorm-jackson:3.4.1")
    api(project(":ktor-sql"))
}
