package model.xml;

import lombok.Data;
import model.Anschrift;
import model.Bestellung;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RechnungXml {
    private Bestellung bestellung;
    private String rechnungNummer;
    private String rechnungDatum;
    private Anschrift anschrift;

    public RechnungXml(Bestellung bestellung, String rechnungNummer, String rechnungDatum, Anschrift anschrift) {
        this.bestellung = bestellung;
        this.rechnungNummer = rechnungNummer;
        this.rechnungDatum = rechnungDatum;
        this.anschrift = anschrift;
    }

    public RechnungXml() {
    }
}
