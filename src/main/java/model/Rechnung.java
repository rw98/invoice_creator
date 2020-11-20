package model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Rechnung {
    private Bestellung bestellung;
    private String rechnungNummer;
    private String rechnungDatum;
    private Anschrift anschrift;




    public Rechnung(Bestellung bestellung, String rechnungNummer, String rechnungDatum, Anschrift anschrift) {
        this.bestellung = bestellung;
        this.rechnungNummer = rechnungNummer;
        this.rechnungDatum = rechnungDatum;
        this.anschrift = anschrift;
    }

    public Rechnung() {
    }
}
