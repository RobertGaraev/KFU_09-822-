package Kurs2.lab.Lab3;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {
    static ArrayList<Sportsmen> Peopls = new ArrayList<>();

    public static void main(String[] args) {
//        readAndPrintXML();
//        output_to_consol();
//        add_new_sportsmen();
        try {
            create_new_xml();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void readAndPrintXML() {
        // DOM parser - загружает весь xml-файл в память; ! для небольших документов
        try {
            // Создать построитель документа
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            // из файла Создать объект документа для обхода дерева DOM документа
            Document document = builder.parse("Autor_book");

            // Получить корневой элемент
            Node root = document.getDocumentElement();

            System.out.println("List of contacts:\n===========>>>>");

            // Просматриваем все подэлементы корневого - т.е. контакты
            NodeList contacts = root.getChildNodes();
            for (int i = 0; i < contacts.getLength(); i++) {
                Node pers = contacts.item(i);

                // Если узел не текст, то заходим внутрь
                if (pers.getNodeType() != Node.TEXT_NODE) {
                    //Проверка наличия атрибутов и его вывод в случае присутствия
                    if (pers.hasAttributes()) {
                        NamedNodeMap attr_1 = pers.getAttributes();
                        System.out.println(attr_1.getNamedItem("Автор").getNodeValue());
                    }
                    NodeList persProps = pers.getChildNodes();
                    for (int j = 0; j < persProps.getLength(); j++) {
                        Node persProp = persProps.item(j);
                        // Если нода не текст, то это один из параметров книги - печатаем
                        if (persProp.getNodeType() != Node.TEXT_NODE) {
                            NamedNodeMap attr = persProp.getAttributes();
                            System.out.println(attr.getNamedItem("книга").getNodeValue() + "\n" + attr.getNamedItem("страницы").getNodeValue());
                        }
                    }
                    System.out.println("===========>>>>");
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void work_with_sportsmens() {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse("sportsmens");
            Node root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.hasAttributes()) {
                    String name_ = node.getAttributes().getNamedItem("name").getTextContent();
                    String birthday_ = node.getAttributes().getNamedItem("birthday").getTextContent();
                    String s_ = node.getAttributes().getNamedItem("s").getTextContent();
                    Sportsmen sportsmen = new Sportsmen(name_,birthday_,s_);
                    Peopls.add(sportsmen);
                    NodeList nodeList1 = node.getChildNodes();
                    for (int j = 0; j < nodeList1.getLength(); j++) {
                        Node node1 = nodeList1.item(j);
                        if (node1.getNodeType() == Node.ELEMENT_NODE && node1.hasAttributes()) {
                            Element element = (Element) node1;
                            sportsmen.addyear(node1.getAttributes().getNamedItem("year").getNodeValue());
                            sportsmen.addplace(node1.getAttributes().getNamedItem("place").getTextContent());
                            sportsmen.addresult(element.getElementsByTagName("result").item(0).getTextContent());
                            sportsmen.addaward(element.getElementsByTagName("award").item(0).getTextContent());
                        }
                    }
                }
                else continue;
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void output_to_consol() {
        work_with_sportsmens();
        System.out.println("имена и даты рождения всех мужчин:");
        for (Sportsmen value : Peopls) {
            if (value.gets().equals("м")) {
                System.out.println(value.getname() + "  " + value.getbirthday());
            }
        }
        System.out.println("\nимена, даты рождения и количество медалей у женщин страше 1985 года:");
        for (Sportsmen value : Peopls) {
            if (value.gets().equals("ж") && Integer.parseInt(value.getbirthday().substring(0, 4)) < 1985) {
                int i = 0;
                while (!value.getaward(i).equals("-1")) i++;
                System.out.println(value.getname() + "  " + value.getbirthday() + "  Количество медалей: " + i);
            }
        }
        System.out.println("\nимена и результаты спортсменов, участвовавших в 2002 году в соревнованиях в Москве");
        for (Sportsmen sportsman : Peopls) {
            int i = 0;
            while (sportsman.getyear(i) != -1) {
                if (sportsman.getyear(i) == 2002 && sportsman.getplace(i).equals("москва")) {
                    System.out.println(sportsman.getname() + "  " + sportsman.getresult(i));
                }
                i++;
            }
        }
    }

    public static void add_new_sportsmen() {
        Scanner a = new Scanner(System.in);
        String name, birthday, s;
        int k;
        System.out.print("Введите данные спортсмена\nИмя: ");
        name = a.next();
        System.out.print("Дата рождения (гггг-мм-дд): ");
        birthday = a.next();
        System.out.print("Пол м или ж: ");
        s = a.next();
        Sportsmen new_sportsman = new Sportsmen(name, birthday, s);
        System.out.print("Количество соревнований: ");
        k = a.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.print((i+1)+"соревнование:\nМесто: ");
            new_sportsman.addplace(a.next());
            System.out.print("Год: ");
            new_sportsman.addyear(a.next());
            System.out.print("Результат: ");
            new_sportsman.addresult(a.next());
            System.out.print("Медаль: ");
            new_sportsman.addaward(a.next());
        }
    }

    public static void create_new_xml() throws ParserConfigurationException, IOException, SAXException{
        try {
            Document document =  DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("sportsmens");
            Document document_new  = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element rootElement = document_new.createElement("All_Sportsmens");
            document_new.appendChild(rootElement);
            Node root = document.getDocumentElement();
            NodeList contacts = root.getChildNodes();
            for (int i = 0; i < contacts.getLength(); i++) {
                Node node = contacts.item(i);
                work_with_sportsmens();
                Sportsmen sportsmen = Peopls.get(i);
                int sum = 0;
                int k = 0;
                while (sportsmen.getresult(k)!=-1){
                    sum+=sportsmen.getresult(k);
                    k++;
                }
                Element first = document_new.createElement("Sportsmen");
                Element second = document_new.createElement("events");
                Element last = document_new.createElement("results");
                last.appendChild(document_new.createTextNode(String.valueOf(sum)));
                second.setAttribute("number", String.valueOf(k));
                second.appendChild(last);
                if (node.hasAttributes()) {
                    first.setAttribute("name", node.getAttributes().getNamedItem("name").getNodeValue());
                    first.appendChild(second);
                    rootElement.appendChild(first);
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(document_new);
            StreamResult file = new StreamResult(new File("New_Sportsmens.xml"));
            transformer.transform(source,file);
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
