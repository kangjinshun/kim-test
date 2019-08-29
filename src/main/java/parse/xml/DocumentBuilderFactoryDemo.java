package parse.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.FileInputStream;

/**
 * 〈一句话功能简述〉<br>
 * https://www.w3school.com.cn/xpath/xpath_syntax.asp Xpath语法
 * @author kangjinshun
 * @create 2019/8/23
 * @since 1.0.0
 */
public class DocumentBuilderFactoryDemo {
    public static void main(String[] args) throws Exception {
        // 创建工厂
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 通过工厂获取DocumentBuilder实例对象
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        String xmlPath = DocumentBuilderFactoryDemo.class.getResource("/config.xml").getPath();
        FileInputStream fileInputStream = new FileInputStream(xmlPath);
        //documentBuilder获取document对象
        Document doc = documentBuilder.parse(fileInputStream);
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        /*
            //user	选取所有 user 子元素，而不管它们在文档中的位置。
            name	选取 name 元素的所有子节点。
        */
        XPathExpression user = xPath.compile("//user");
        XPathExpression name = xPath.compile("name");
        XPathExpression age = xPath.compile("age");
        XPathExpression sex = xPath.compile("sex");
        NodeList nodeList = (NodeList) user.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            Node nameNode = (Node) name.evaluate(item, XPathConstants.NODE);
            Node ageNode = (Node) age.evaluate(item, XPathConstants.NODE);
            Node sexNode = (Node) sex.evaluate(item, XPathConstants.NODE);
            System.out.println(nameNode.getNodeName() + "-" + nameNode.getTextContent() + ","
                    + ageNode.getNodeName() + "-" + ageNode.getTextContent() + ","
                    + sexNode.getNodeName() + "-" + sexNode.getTextContent());
        }

    }
}
