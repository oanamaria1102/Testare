package loose.oose.fis;

import loose.oose.fis.documents.Document;
import loose.oose.fis.documents.JSON;
import loose.oose.fis.documents.XML;
import loose.oose.fis.processors.Procesor;
import loose.oose.fis.processors.ProcesorCautare;
import loose.oose.fis.processors.ProcesorCompus;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] xmlList = new String[3];
        xmlList[0] = "<tag>";
        xmlList[1] = "valoare";
        xmlList[2] = "</tag>";

        Document xml = new XML(xmlList);


        String[] jsonList = new String[2];
        jsonList[0] = "nume:";
        jsonList[1] = "valoare1";

        Document json = new JSON(jsonList);

        ArrayList<Document> documente = new ArrayList<>();
        documente.add(xml);
        documente.add(json);

        Procesor       procesorCautare  = new ProcesorCautare("valoare");
        Procesor       procesorCautare1 = new ProcesorCautare("valoare1");
        ProcesorCompus procesorCompus   = new ProcesorCompus();
        procesorCompus.adaugaProcesor(procesorCautare);
        procesorCompus.adaugaProcesor(procesorCautare1);

        System.out.println(procesorCompus.proceseaza(documente));
    }
}
