package converter;

import model.PlainModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DtoToXml{

    private JAXBContext jaxbContext;
    private Marshaller marshaller;

    public DtoToXml() throws JAXBException {
        jaxbContext = JAXBContext.newInstance(PlainModel.class);
        marshaller = jaxbContext.createMarshaller();
    }

    public void dtoRechnungToXml(PlainModel rechnung) throws FileNotFoundException, JAXBException {
        rechnung.setGesamtpreis(rechnung.getArtikelPreis()+rechnung.getVersandkosten());
        //RechnungXml rechnungXml = RechnungMapper.INSTANCE.rechnungToRechnungXml(rechnung);
        marshaller.marshal(rechnung, new FileOutputStream("C:/Users/RW98/Documents/testRechnungen/"
                + rechnung.getBestellnummer()
                + "_rechnung.xml"));

    }

}
