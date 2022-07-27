package 面试.设计模式.适配器;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
    适配器模式：将一个类的接口转换成客户希望的另一个接口。适配器模式让那些接口不兼容的类可以一起工作

    对象适配器模式：适配器和适配者之间是关联关系
    类适配器模式：适配器与适配者之间是继承关系

    本案例采用对象适配器来实现
 */
public abstract class CarController {
    public void moved() {
        System.out.println("小车正在移动。。。");
    }

    public abstract void phonate();//发出声音

    public abstract void twinkle();//灯光闪烁
}

class PoliceSound {
    void alarmSound() {
        System.out.println("小车发出声音。。。");
    }
}

class PoliceLamp {
    void alarmLamp() {
        System.out.println("小车发出闪光。。。");
    }
}

class PoliceCarAdapter extends CarController {

    private PoliceSound policeSound;
    private PoliceLamp policeLamp;

    public PoliceCarAdapter() {
        policeSound = new PoliceSound();
        policeLamp = new PoliceLamp();
    }

    @Override
    public void phonate() {
        policeSound.alarmSound();
    }

    @Override
    public void twinkle() {
        policeLamp.alarmLamp();
    }
}

class XMLUtil {
    //该方法用于从XML文件中提取具体的类名，并返回一个实例对象
    public static Object getBean() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("src//structural//adapter//config.xml"));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();

            //通过类目生成实例对象并返回
            Object obj = Class.forName(cName).newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Client {
    public static void main(String[] args) {
        CarController car;
        car = (CarController) XMLUtil.getBean();
        car.moved();
        car.phonate();
        car.twinkle();
    }
}

