# BWLTool
Tool zur Hilfe bei der BWL Klausur

<H2>Was macht unser Tool?</H2>
 - Es wird Port 8080 für einen Tomcat Webserver geöffnet</br>
 - Es wird mit Vaadin + Spring Boot eine Webseite verfügbar gemacht, mit der man häufige BWL Rechnungen effizent lösen kann

<H2>Richtig in der IDE zum laufen bringen</H2>

1. Die pom.xml mit InelliJ oder Eclipse öffnen
2. Abwarten bis sichalle Depencencies heruntergeladen haben.
3. Am besten mit Java 15 starten

<H2>Develepment- und Production mode</H2>

<code>
    public static void main (String[] args){
             
    LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));//<-- Dev. mode
    SpringApplication.run(Application.class, args); //<-- Production mode
}
</code>

<H2>Build<H2>
<code>
    mvn clean package -Pproduction
</code>
</br>
<H2>Quellen<H2>
<text>
Das Backend von "Netzplanrechner" ist von</br> 
-> https://github.com/projectcodingduck/netzplan-service
</text>
