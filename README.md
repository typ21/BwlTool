# BWLTool
Tool zur Hilfe bei häufigen Rechnungen in der BWL.

## Was macht unser Tool?
- Es wird Port 8080 für einen Tomcat Webserver geöffnet
- Es wird mit Vaadin + Spring Boot eine Webseite verfügbar gemacht, mit der man häufige BWL Rechnungen effizent lösen kann

## Richtig in der IDE zum laufen bringen
1. Die pom.xml mit IntelliJ oder Eclipse öffnen
2. Abwarten bis alle Depencencies heruntergeladen wurden
3. Am Besten mit Java 11 starten

## Develepment- und Production mode
```java
public static void main (String[] args) {
    LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args)); // <-- Dev. mode
    SpringApplication.run(Application.class, args); // <-- Production mode
}
```

## Build
`mvn clean package -Pproduction`

## Quellen
Das Backend von "Netzplanrechner" ist von  
-> https://github.com/projectcodingduck/netzplan-service
