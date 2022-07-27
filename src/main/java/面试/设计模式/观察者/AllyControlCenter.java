package 面试.设计模式.观察者;

import java.util.ArrayList;
import java.util.List;

/*
    观察者模式：定义对象之间的一种一对多的依赖关系，使得每当一个对象状态发生改变时
    相关依赖对象皆得到通知并被自动更新
 */
abstract class AllyControlCenter {
    protected String allyName;
    protected List<Observer> players = new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void join(Observer observer) {
        players.add(observer);
    }

    public void quit(Observer observer) {
        players.remove(observer);
    }

    public abstract void notifyObserver(String name);
}

class ConcreteAllyController extends AllyControlCenter {
    public ConcreteAllyController(String name) {
        System.out.println("战队组建成功---");
        this.setAllyName(name);
    }

    @Override
    public void notifyObserver(String name) {

        System.out.println("战队：" + this.allyName + "发出紧急通知，" + name + "遭到敌人攻击");
        for (Object obj :
                players) {
            if (!((Observer) obj).getName().equals(name)) {
                ((Observer) obj).help();
            }
        }
    }
}

interface Observer {
    String getName();

    void setName(String name);

    void help();

    void beAttached(AllyControlCenter acc);
}

class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println(this.name + "正在帮助联盟队友");
    }

    @Override
    public void beAttached(AllyControlCenter acc) {
        System.out.println(this.name + "正在被攻击");
        acc.notifyObserver(this.name);
    }
}

class Client {
    public static void main(String[] args) {
        AllyControlCenter acc;
        acc = new ConcreteAllyController("正义联盟");

        Observer player1, player2, player3, player4;

        player1 = new Player("蝙蝠侠");
        player2 = new Player("超人");
        player3 = new Player("闪电侠");
        player4 = new Player("钢骨");

        acc.join(player1);
        acc.join(player2);
        acc.join(player3);
        acc.join(player4);

        player1.beAttached(acc);
    }
}
