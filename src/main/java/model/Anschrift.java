package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Anschrift {
    private String hausnummer;
    private String strasse;
    private String stadt;
    private String name;

    public Anschrift(String hausnummer, String strasse, String stadt, String name) {
        this.hausnummer = hausnummer;
        this.strasse = strasse;
        this.stadt = stadt;
        this.name = name;
    }

    public Anschrift() {
    }
}
