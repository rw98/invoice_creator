package model.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class AnschriftXml {
    private String strasse;
    private String name;
    private String stadt;

    public AnschriftXml() {
    }

    public AnschriftXml(String strasse, String name, String stadt) {
        this.strasse = strasse;
        this.name = name;
        this.stadt = stadt;
    }
}
