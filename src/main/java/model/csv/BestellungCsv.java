
package model.csv;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BestellungCsv {
    @CsvBindByName(column = "bestellnummer", required = true)
    public String bestellnummer;
    @CsvBindByName(column = "bestelldatum", required = true)
    public String bestelldatum;
    @CsvBindByName(column = "artikelName", required = true)
    public String artikelName;
    @CsvBindByName(column = "artikelPreis", required = true)
    public Double artikelPreis;
    @CsvBindByName(column = "menge", required = true)
    public int menge;
    @CsvBindByName(column = "strasse", required = true)
    public String strasse;
    @CsvBindByName(column = "strasse2", required = false)
    public String strasse2;
    @CsvBindByName(column = "name", required = true)
    public String name;
    @CsvBindByName(column = "stadt", required = true)
    public String stadt;
    @CsvBindByName(column = "plz", required = true)
    public String plz;
    @CsvBindByName(column = "versandkosten", required = true)
    public double versandkosten;
    @CsvBindByName(column = "versandkostenrabatt", required = true)
    public double versandkostenRabatt;
    @CsvBindByName(column = "land", required = true)
    public String land;
}
