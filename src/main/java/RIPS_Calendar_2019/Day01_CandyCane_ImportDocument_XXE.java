package RIPS_Calendar_2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

// Missing org.jdom2.input.SAXBuilder Support => https://jira.sonarsource.com/browse/SONARJAVA-3246
public class Day01_CandyCane_ImportDocument_XXE {
  // This function extracts the text of an OpenOffice document
  public static String extractString() throws IOException, JDOMException {
    File initialFile = new File("uploaded_office_doc.odt");
    InputStream in = new FileInputStream(initialFile);
    final ZipInputStream zis = new ZipInputStream(in);
    ZipEntry entry;
    List<Content> content = null;
    while ((entry = zis.getNextEntry()) != null) {
      if (entry.getName().equals("content.xml")) {
        final SAXBuilder sax = new org.jdom2.input.SAXBuilder();
        sax.setFeature("http://javax.xml.XMLConstants/feature/secure-processing",true);
        Document doc = sax.build(zis);
        content = doc.getContent();
        zis.close();
        break;
      }
    }
    StringBuilder sb = new StringBuilder();
    if (content != null){
      for(Content item : content){
        sb.append(item.getValue());
      }
    }
    return sb.toString();
  }
}
