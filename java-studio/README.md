# Java Studio
Mobile-first Eclipse-inspired Java practice IDE.

## Architecture
Android (Java + XML) -> REST API -> Spring Boot -> MySQL
Execution adapters are designed for JDK (Core Java) and Apache Tomcat (JSP/Servlet).

## Important
This package is a development foundation, not a claim that every execution feature is production-complete. The Android app and backend scaffold are included; real JDK/Tomcat sandboxing still requires deployment infrastructure and security hardening.

## Run backend locally
Requires Java 17+ and Maven 3.9+.

```bash
cd backend
mvn spring-boot:run
```
Health: `GET /api/health`

## Android
Open `android/` in Android Studio. Set `BASE_URL` in `MainActivity.java` to the backend URL reachable from the phone/emulator.

## Database
Run `database/schema.sql` on MySQL. Set `MYSQL_URL`, `MYSQL_USER`, `MYSQL_PASSWORD` in the backend environment.

## Render
`deployment/Dockerfile` builds the Spring Boot backend. For a real execution server, provision JDK and Tomcat separately or use a dedicated isolated execution service; do not expose host shell execution to untrusted users.
