package model.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ArtikelXml {
    private String artikelName;
    private String artikelId;
    private Double artikelPreisNetto;
    private Double mwst;
    private Double artikelPreisBrutto;

    public ArtikelXml(String artikelName, String artikelId, Double artikelPreisNetto, Double mwst, Double artikelPreisBrutto) {
        this.artikelName = artikelName;
        this.artikelId = artikelId;
        this.artikelPreisNetto = artikelPreisNetto;
        this.mwst = mwst;
        this.artikelPreisBrutto = artikelPreisBrutto;
    }
}
