package 面试.设计模式.模板;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/*
    定义一个操作中的算法的框架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变一个算法的结构即可
    重定义该算法的某些特定步骤
 */
abstract class Account {
    boolean validate(String account, String password) {
        if ("55".equals(account) && "555".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    abstract void calculateInterest();

    void display() {
        System.out.println("显示利息");
    }

    //模板方法
    void handle(String account, String password) {
        if (!validate(account,password)){
            System.out.println("用户密码输入不正确");
        }
        calculateInterest();
        display();
    }
}

class CurrentAccount extends Account {

    @Override
    void calculateInterest() {
        System.out.println("活期利息");
    }
}

class SavingAccount extends Account {

    @Override
    void calculateInterest() {
        System.out.println("定期利息");
    }
}

class XMLUtil {
    //该方法用于从XML文件中提取具体的类名，并返回一个实例对象
    public static Object getBean() {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/java/面试/设计模式/模板/config.xml"));

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
        Account account;
        account = (Account) XMLUtil.getBean();
        account.handle("55", "555");
    }
}

