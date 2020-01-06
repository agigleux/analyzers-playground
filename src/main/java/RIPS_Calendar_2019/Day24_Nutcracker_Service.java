package RIPS_Calendar_2019;

import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import com.thoughtworks.xstream.XStream;

import java.io.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Day24_Nutcracker_Service {

    @RequestMapping(value = "/unserialize", consumes = "text/xml")
    public void unserialize(@RequestBody String xml, HttpServletResponse res) throws IOException,
            ParserConfigurationException, SAXException, XPathExpressionException, TransformerException {
        res.setContentType("text/plain");
        // Parse xml string
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(new InputSource(new StringReader(xml)));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//com.rips.demo.web.User[@serialization='custom'][1]";
        // only allow User objects to be unserialized!!!
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        // Transform node back to xml string
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(nodeList.item(0)), new StreamResult(writer));
        String xmloutput = writer.getBuffer().toString();
        // Unserialze User
        User user = (User) new XStream().fromXML(xmloutput);
        res.getWriter().print("Successfully unserialized " + user.toString());
    }
}