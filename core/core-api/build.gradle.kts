tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}

dependencies {
    implementation(project(":core:core-domain"))
    implementation(project(":security:security-core"))
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation(project(":support:monitoring"))
    implementation(project(":support:logging"))
//    implementation(project(":clients:client"))
//    implementation(project(":clients:aws-client"))

    runtimeOnly(project(":storage:db-core"))

    testImplementation(project(":tests:api-docs"))

    implementation("org.springframework.boot:spring-boot-starter-web")
}
