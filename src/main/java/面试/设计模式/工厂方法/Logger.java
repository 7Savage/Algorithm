package 面试.设计模式.工厂方法;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
    工厂方法模式：定义一个用于创建对象的接口，但是让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类
 */
public interface Logger {
    void writeLog();
}


class DataBaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("数据库记录日志。。。");
    }
}

class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录。。。");
    }
}

interface LoggerFactory {
    Logger createLogger();
}

class DataBaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DataBaseLogger();
    }
}

class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}

class XMLUtil {
    //该方法用于从XML文件中提取具体的类名，并返回一个实例对象
    public static Object getBean() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/java/面试/设计模式/工厂方法/config.xml"));

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
        LoggerFactory factory;
        //factory = new FileLoggerFactory();
        factory = (LoggerFactory) XMLUtil.getBean();
        Logger logger = factory.createLogger();
        logger.writeLog();
    }
}



