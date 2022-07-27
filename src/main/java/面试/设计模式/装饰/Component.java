package 面试.设计模式.装饰;


/*
    装饰模式：动态地给一个对象增加一些额外的职责。就扩展而言，装饰模式提供了一种比使用子类更加灵活的替代方案
 */
public abstract class Component {
    public abstract void display();
}

class Window extends Component {

    @Override
    public void display() {
        System.out.println("显示窗体");
    }
}

class TextBox extends Component {

    @Override
    public void display() {
        System.out.println("显示文本框");
    }
}

class ListBox extends Component {

    @Override
    public void display() {
        System.out.println("显示多选框");
    }
}

class ComponentDecorator extends Component {

    private Component component;//维持对抽象对象的引用

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}

class ScrollDecorator extends ComponentDecorator {

    public ScrollDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("为构建增加滚动条");
    }
}

class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("为构建增加黑色边框");
    }
}

class Client {
    public static void main(String[] args) {
        Component component;
        component = new Window();
        Component CD = new ScrollDecorator(component);
        Component BBD = new BlackBorderDecorator(CD);
        BBD.display();
    }
}

