package model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "rechnung")
@XmlAccessorType(XmlAccessType.FIELD)
@Accessors(chain = true)
public class PlainModel {

    public String bestellnummer;
    public String bestelldatum;
    public String artikelName;
    public Double artikelPreis;
    public int menge;
    public String strasse;
    public String strasse2;
    public String plz;
    public String name;
    public String stadt;
    private double gesamtpreis;
    private double versandkosten;
    private double rabattVersandkosten;
    private double versandInsgesamt;
    private String land;
}
