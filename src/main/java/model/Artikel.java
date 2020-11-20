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
public class Artikel {
    private String artikelName;
    private Double artikelPreisNetto;
    private Double mwst;
    private Double artikelPreisBrutto;

    public Artikel(String artikelName, Double artikelPreisNetto, Double mwst, Double artikelPreisBrutto) {
        this.artikelName = artikelName;
        this.artikelPreisNetto = artikelPreisNetto;
        this.mwst = mwst;
        this.artikelPreisBrutto = artikelPreisBrutto;
    }

    public Artikel() {
    }
}
