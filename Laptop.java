  
import java.util.Objects;

public class Laptop {

    private String name;
    private String color;
    private String model;
    private int price;
    private int RAM;
    private String storage;


    public Laptop(String name, String color, int price, String model) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.model = model;        
    }
    // get and set data
    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return RAM;
    }

    public void setRam(int ram) {
        this.RAM = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "назавание='" + name + '\'' +
                ", цвет='" + color + '\'' +
                ", цена=" + price +
                ", Оперативная память =" + RAM +   
                ", накопитель=" + storage +                    
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, model, price);
    }
}