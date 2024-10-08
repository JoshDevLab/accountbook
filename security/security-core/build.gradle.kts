dependencies {
    implementation(project(":core:core-domain"))
    implementation(project(":storage:db-core"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    api ("org.springframework.boot:spring-boot-starter-oauth2-client")
    api ("org.springframework.boot:spring-boot-starter-security")

    implementation ("io.jsonwebtoken:jjwt-api:0.11.2")

    runtimeOnly ("io.jsonwebtoken:jjwt-impl:0.11.2")
    runtimeOnly ("io.jsonwebtoken:jjwt-jackson:0.11.2")

    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("org.springframework.security:spring-security-test")
}
