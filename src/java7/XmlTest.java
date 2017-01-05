package java7;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/8/15
 */
@XmlRootElement(name = "XmlTest")
public class XmlTest {
    private String id;
    private String name;
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        XmlTest re = new XmlTest();
        re.setId("1111");
        re.setName("我的错");
        JAXBContext jAXBContext = null;
        //object转XML
        StringWriter stringWriter = new StringWriter();
        try {
            jAXBContext = JAXBContext.newInstance(re.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.marshal(re, stringWriter);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("转出的xml字符串"+stringWriter.toString());
        //xml转object
        StringReader stringReader = new StringReader(stringWriter.toString());
        try {
            jAXBContext = JAXBContext.newInstance(re.getClass());
            Unmarshaller un = jAXBContext.createUnmarshaller();
            XmlTest xmlTest = (XmlTest) un.unmarshal(stringReader);
            System.out.println("转出的类的getName是"+ xmlTest.getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
