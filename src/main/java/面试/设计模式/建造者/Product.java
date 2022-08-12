package 面试.设计模式.建造者;

class Product {
    private String partA;
    private String partB;
    private String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}

abstract class Builder {
    Product product = new Product();

    public abstract void buildA();

    public abstract void buildB();

    public abstract void buildC();

    public Product getResult() {
        return product;
    }
}

class ConcreteBuilder extends Builder {

    @Override
    public void buildA() {
        product.setPartA("A1");
    }

    @Override
    public void buildB() {
        product.setPartB("B1");
    }

    @Override
    public void buildC() {
        product.setPartC("C1");
    }
}

//指挥类，负责安排复杂对象的建造次序
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildA();
        builder.buildB();
        builder.buildC();
        return builder.getResult();
    }
}

class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();//可以通过配置文件实现
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}
