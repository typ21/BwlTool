package de.adesso.jani.views.sites.info;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@Route(value="datenschutz", layout = MainView.class)
@PageTitle("Datenschutz")
public class Datenschutz extends VerticalLayoutWithFooter {

    public Datenschutz(){
        add(
                new H2("Datenschutzerklärung"),
                new Span("Dieses Dokument informiert Sie über die Art, den Umfang und Zweck der Erhebung, die Nutzung und die Verarbeitung von personenbezogenen Daten durch den Anbieter dieser Website (siehe Impressum). Die rechtlichen Grundlagen des Datenschutzes finden Sie in der Datenschutz-Grundverordnung (DSGVO), im Bundesdatenschutzgesetz (BDSG) und dem Telemediengesetz (TMG). Der Anbieter dieser Website ist die verantwortliche Stelle in allen Belangen des Datenschutzes. Wir weisen darauf hin, dass Hardware und Software, die bei der Nutzung dieser Website zum Einsatz kommen, Sicherheitslücken aufweisen können, wodurch ein vollständiger Schutz der übertragenen Daten vor Zugriffen durch Dritte nicht gewährleistet werden kann. Wir werden keinem Dritten Zugriff auf Ihre in unserem System gespeicherten personenbezogenen Daten gewähren, es sei denn, dass dies gesetzlich erforderlich ist."),
                new H3("Ihre Betroffenenrechte"),
                new Span("Unter den angegebenen Kontaktdaten unseres Datenschutzbeauftragten können Sie jederzeit folgende Rechte ausüben:\n" +
                        "•\tAuskunft über Ihre bei uns gespeicherten Daten und deren Verarbeitung (Art. 15 DSGVO),\n" +
                        "•\tBerichtigung unrichtiger personenbezogener Daten (Art. 16 DSGVO),\n" +
                        "•\tLöschung Ihrer bei uns gespeicherten Daten (Art. 17 DSGVO),\n" +
                        "•\tEinschränkung der Datenverarbeitung, sofern wir Ihre Daten aufgrund gesetzlicher Pflichten noch nicht löschen dürfen (Art. 18 DSGVO),\n" +
                        "•\tWiderspruch gegen die Verarbeitung Ihrer Daten bei uns (Art. 21 DSGVO) und\n" +
                        "•\tDatenübertragbarkeit, sofern Sie in die Datenverarbeitung eingewilligt haben oder einen Vertrag mit uns abgeschlossen haben (Art. 20 DSGVO).\n" +
                        "Sofern Sie uns eine Einwilligung erteilt haben, können Sie diese jederzeit mit Wirkung für die Zukunft widerrufen.\n" +
                        "Sie können sich jederzeit mit einer Beschwerde an eine Aufsichtsbehörde wenden, z. B. an die zuständige Aufsichtsbehörde des Bundeslands Ihres Wohnsitzes oder an die für uns als verantwortliche Stelle zuständige Behörde.\n" +
                        "Eine Liste der Aufsichtsbehörden (für den nichtöffentlichen Bereich) mit Anschrift finden Sie unter: https://www.bfdi.bund.de/DE/Service/Anschriften/Laender/Laender-node.html.\n"),
                new H3("SSL-Verschlüsselung"),
                new Span("Um die Sicherheit Ihrer Daten bei der Übertragung zu schützen, verwenden wir dem aktuellen Stand der Technik entsprechende Verschlüsselungsverfahren (z. B. SSL) über HTTPS."),
                new H3("Vaadin"),
                new Span("Wir verwenden Vaadin für die Nutzerinteraktion für weitere Informationen könnten die \"community -terms\" interessant sein: https://vaadin.com/community-terms."),
                new H3("Cookies"),
                new Span("Unser Service speichert genau 2 Arten von Cookies:\n" +
                        "•\tSession ID\n" +
                        "•\tAkzeptanz der Cookie Meldung\n" +
                        "Die Session ID wird standartmäßig von Vaadin gespeichert, weil es sich um eine \"One Pager\" Lösung handelt. Der Nutzer hat dadurch eine bessere Nutzungserfahrung, denn die Ladezeiten werden stark verkürzt.\n"),
                new H3("Berechnungen"),
                new Span("Wenn die Aktion einer Berechnung angestoßen wird, werden die entsprechenden Eingabefelder ausgelesen und deren Daten verarbeitet. Das ist notwendig, um später eine auf die Berechnung bezogene Ausgabe tätigen zu können.\n" +
                        "Die eingelesenen Daten sind anonym und nicht mit einem bestimmten Nutzer in Verbindung zu bringen. Sie werden außerdem nicht an Dritte weitergegeben.\n"),
                new H3("Server Log"),
                new Span("Schlägt eine Berechnung fehl, so wird der entstandene Fehler und dessen Uhrzeit im Server log gespeichert. Auch hier werden keine Nutzerbezogenen Daten erhoben, sondern lediglich die anonymen eingegebenen Zahlen.\n" +
                        "Es besteht ein berechtigter Grund für das Speichern dieser Fehler, da wir anhand der Fehler die Bedienung des Rechners und die Hinweise an den Nutzer verbessern können.\n"),
                new H3("Information über Ihr Widerspruchsrecht nach Art. 21 DSGVO"),
                new H4("Einzelfallbezogenes Widerspruchsrecht"),
                new Span("Sie haben das Recht, aus Gründen, die sich aus Ihrer besonderen Situation ergeben, jederzeit gegen die Verarbeitung Sie betreffender personenbezogener Daten, die aufgrund Art. 6 Abs. 1 lit. f DSGVO (Datenverarbeitung auf der Grundlage einer Interessenabwägung) erfolgt, Widerspruch einzulegen; dies gilt auch für ein auf diese Bestimmung gestütztes Profiling im Sinne von Art. 4 Nr. 4 DSGVO.\n" +
                        "Legen Sie Widerspruch ein, werden wir Ihre personenbezogenen Daten nicht mehr verarbeiten, es sei denn, wir können zwingende schutzwürdige Gründe für die Verarbeitung nachweisen, die Ihre Interessen, Rechte und Freiheiten überwiegen, oder die Verarbeitung dient der Geltendmachung, Ausübung oder Verteidigung von Rechtsansprüchen.\n"),
                new H4("Empfänger eines Widerspruchs"),
                new Span("Der Verantwortliche, Arne Abbing"),
                new H3("Änderung unserer Datenschutzbestimmungen"),
                new Span("Wir behalten uns vor, diese Datenschutzerklärung anzupassen, damit sie stets den aktuellen rechtlichen Anforderungen entspricht oder um Änderungen unserer Leistungen in der Datenschutzerklärung umzusetzen, z.B. bei der Einführung neuer Services. Für Ihren erneuten Besuch gilt dann die neue Datenschutzerklärung."),
                new H3("Fragen an den Datenschutzbeauftragten"),
                new Span("Wenn Sie Fragen zum Datenschutz haben kontaktieren sie uns bitte über die Impressum angegebenen Daten.")
        );
    }

}
