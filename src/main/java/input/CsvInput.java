package input;


import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import converter.DtoToXml;
import lombok.extern.slf4j.Slf4j;
import model.PlainModel;
import model.csv.BestellungCsv;
import pdf.PdfBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
@Slf4j
public class CsvInput {

    public static List<BestellungCsv> getListOrdersFromCsv(String path) throws IOException, CsvValidationException {
        List<BestellungCsv> beans = new CsvToBeanBuilder(new FileReader(path))
                .withType(BestellungCsv.class)
                .withSeparator(',')
                .build()
                .parse();
        return beans;
    }

    public static boolean createInvoices(String path) throws Exception {
        DtoToXml dtoToXml = new DtoToXml();
        List<BestellungCsv> bestellungen = getListOrdersFromCsv(path);
        for (BestellungCsv bestellungCsv : bestellungen) {
            PlainModel rechnung = fillrechnungDto(bestellungCsv);
            dtoToXml.dtoRechnungToXml(rechnung);
            PdfBuilder.xmlToPdfPerXsl("C:/Users/RW98/Documents/testRechnungen/"
                    + rechnung.getBestellnummer()
                    + "_rechnung.xml");
        }
        return true;
    }

    private static String modifyDate(String datum){
        String datumUnmod[] = datum.split("T");
        return datumUnmod[0];
    }

    private static String modifyName(String name) {
        String buf = new String(name.getBytes(), StandardCharsets.UTF_8);
        String retString = new String("".getBytes(),StandardCharsets.UTF_8);
        String[] namen = buf.split(" ");
        for (int i = 0; i < namen.length; i++) {
            namen[i] = namen[i].substring(0, 1).toUpperCase()+namen[i].substring(1);
            retString = retString+namen[i]+" ";
        }
        log.info(retString);
        return retString;
    }

    private static PlainModel fillrechnungDto(BestellungCsv bestellungCsv) {
        PlainModel plainModel = new PlainModel();
        plainModel.setArtikelName(bestellungCsv.getArtikelName())
                .setArtikelPreis(bestellungCsv.getArtikelPreis())
                .setBestelldatum(modifyDate(bestellungCsv.getBestelldatum()))
                .setBestellnummer(bestellungCsv.getBestellnummer())
                .setMenge(bestellungCsv.getMenge())
                .setStadt(modifyName(bestellungCsv.getStadt()))
                .setStrasse(modifyName(bestellungCsv.getStrasse()))
                .setName(modifyName(bestellungCsv.getName()))
                .setRabattVersandkosten(bestellungCsv.getVersandkostenRabatt())
                .setVersandInsgesamt(bestellungCsv.getVersandkosten()+bestellungCsv.getVersandkostenRabatt())
                .setVersandkosten(bestellungCsv.getVersandkosten())
                .setPlz(bestellungCsv.getPlz())
        .setLand(bestellungCsv.getLand());
        if (!bestellungCsv.getStrasse2().isEmpty()){
            plainModel.setStrasse2(modifyName(bestellungCsv.getStrasse2()));
        }
        return plainModel;
    }

}
