package pdf;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;

public class PdfBuilder {

    public static void xmlToPdfPerXsl(String inputXML ) throws Exception
    {
        OutputStream pdf = new FileOutputStream( inputXML.replaceAll(".xml",".pdf") );
        Fop fop = FopFactory.newInstance(new URI(".")).newFop( MimeConstants.MIME_PDF, pdf );
        Source xml = new StreamSource( inputXML );
        Source xsl = new StreamSource( "C:/workspace/amazon_invoice_creator/src/main/resources/xslt/rechnung.xsl" );
        Result sax = new SAXResult( fop.getDefaultHandler() );
        Transformer transformer = TransformerFactory.newInstance().newTransformer( xsl );
        transformer.transform( xml, sax );
    }
}
