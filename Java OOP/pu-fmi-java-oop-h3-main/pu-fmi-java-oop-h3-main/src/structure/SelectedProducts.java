package structure;

public class SelectedProducts extends Product{

    private int productCount;
    private int productTotalPrice;

    public SelectedProducts(String brand, double price, String imageLocation, int quantity, int productCount, int productTotalPrice) {
        super(brand, price, imageLocation, quantity);
        this.productCount = productCount;
        this.productTotalPrice = productTotalPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public float getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(int productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public double getTotalPrice(){
        return getProductCount()*getProductTotalPrice();
    }


}
