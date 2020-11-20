package mapping;

import model.Artikel;
import model.Bestellung;
import model.Rechnung;
import model.xml.ArtikelXml;
import model.xml.BestellungXml;
import model.xml.RechnungXml;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RechnungMapper {

    RechnungMapper INSTANCE = Mappers.getMapper(RechnungMapper.class);

    @Mapping(source = "bestellung", target = "bestellungXml")
    RechnungXml rechnungToRechnungXml(Rechnung rechnung);
    @Mapping(source = "bestellnummer", target = "bestellnummer")
    @Mapping(source = "bestelldatum", target = "bestelldatum")
    @Mapping(source = "artikel", target = "artikelXml")
    @Mapping(source = "summeNetto", target = "summeNetto")
    @Mapping(source = "summeBrutto", target = "summeBrutto")
    BestellungXml bestellungToBestellungXml(Bestellung bestellung);
    @Mapping(source = "artikelName", target = "artikelName")
    @Mapping(source = "artikelId", target = "artikelId")
    @Mapping(source = "artikelPreisNetto", target = "artikelPreisNetto")
    @Mapping(source = "mwst", target = "mwst")
    @Mapping(source = "artikelPreisBrutto", target = "artikelPreisBrutto")
    ArtikelXml artikelToArtikelXml(Artikel artikel);
}
