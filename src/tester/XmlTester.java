package tester;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import generated.Lexer;
import generated.Parser;
import org.w3c.dom.Document;
import Visitor.XmlGenerator;
import Node.ProgramOp;

import java.io.File;
import java.io.FileReader;

public class XmlTester {
    public static void main(String[] args) throws Exception {
        FileReader inFile = new FileReader(args[0]);
        Lexer lexer = new Lexer(inFile);
        Parser p = new Parser(lexer);
        //System.out.println(p.debug_parse().parse_state);
        ProgramOp prog =  (ProgramOp) p.parse().value;

        XmlGenerator xml = new XmlGenerator();
        Document doc = (Document) prog.accept(xml);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(System.getProperty("user.dir")+"\\albero_sintattico.xml"));
        transformer.transform(domSource, streamResult);
        /*Symbol token;
        while ((token = lexer.next_token())!= null) {
            if(token.sym == sym.EOF){
                break;
            }
            String s = "<" + sym.terminalNames[token.sym] +
                    (token.value == null ? ">" : ("," + token.value + ">"));
            System.out.println(s);
        }*/


    }
}
