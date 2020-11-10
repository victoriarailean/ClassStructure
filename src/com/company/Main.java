package com.company;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();


        Scanner var = new Scanner(System.in);
        String directory;

        System.out.println("Enter directory");
        directory = var.nextLine();

        System.out.println("Directory is: " + directory);
        File[] files = new File(directory).listFiles(File::isFile);
        File[] folders = new File(directory).listFiles(File::isDirectory);

        Element element = document.createElement("name");
        document.appendChild(element);

        Element name_dir = document.createElement("name");
        name_dir.appendChild(document.createTextNode(directory));
        element.appendChild(name_dir);

        Element files_count = document.createElement("files_number");
        files_count.appendChild(document.createTextNode(String.valueOf(files.length)));
        element.appendChild(name_dir);

        Element foldres_count = document.createElement("folders_number");
        foldres_count.appendChild(document.createTextNode(String.valueOf(folders.length)));
        element.appendChild(name_dir);


        for (File file : files) {

            Element file_name = document.createElement("files_name");
            file_name.appendChild(document.createTextNode(String.valueOf(file)));
            element.appendChild(file_name);
        }

        for (File folder : folders) {

            Element folder_name = document.createElement("folder_name");
            folder_name.appendChild(document.createTextNode(String.valueOf(folder)));
            element.appendChild(name_dir);

        }

        for (File folder_number : folders) {
            Element folder_number = document.createElement("folder_number");
            folder_number.appendChild(document.createTextNode(String.valueOf(folder_number)));
            element.appendChild(folder_number);
        }



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult streamResult = new StreamResult(new File("data.xml"));
            transformer.transform(source, streamResult);
    }
}






















