package model.xml;

import lombok.Data;
import model.Artikel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"bestellnummer","bestelldatum","artikel","summeNetto","summeBrutto","menge"})
public class BestellungXml {
    private String bestellnummer;
    private String bestelldatum;
    private Artikel artikel;
    private double summeNetto;
    private double summeBrutto;
    private int menge;

    public BestellungXml(String bestellnummer, String bestelldatum, Artikel artikel, double summeNetto, double summeBrutto, int menge) {
        this.bestellnummer = bestellnummer;
        this.bestelldatum = bestelldatum;
        this.artikel = artikel;
        this.summeNetto = summeNetto;
        this.summeBrutto = summeBrutto;
        this.menge = menge;
    }

    public BestellungXml() {
    }
}
