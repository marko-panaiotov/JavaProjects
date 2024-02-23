package structure;

public class Product {

    private String brand;
    private double price;
    private String imageLocation;
    private int quantity;

    public Product(){}
    public Product(String brand, double price, String imageLocation, int quantity) {
        this.brand = brand;
        this.price = price;
        this.imageLocation = imageLocation;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){

        return getBrand();
    }

}
