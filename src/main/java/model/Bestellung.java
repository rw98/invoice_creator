package model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Getter
@Setter
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Bestellung {
    private String bestellnummer;
    private String bestelldatum;
    private Artikel artikel;
    private double summeNetto;
    private double summeBrutto;
    private int menge;

    public Bestellung(String bestellnummer, String bestelldatum, Artikel artikel, double summeNetto, double summeBrutto, int menge) {
        this.bestellnummer = bestellnummer;
        this.bestelldatum = bestelldatum;
        this.artikel = artikel;
        this.summeNetto = summeNetto;
        this.summeBrutto = summeBrutto;
        this.menge = menge;
    }

    public Bestellung() {
    }
}
