# Java Studio architecture

Android Java/XML app -> HTTPS REST API -> Spring Boot -> MySQL.

Core Java execution should be isolated behind a sandboxed execution service using JDK.
JSP/Servlet execution should be isolated behind Apache Tomcat.

Never execute arbitrary user code directly inside the main API process or with unrestricted host privileges.
