package structure;

import java.util.List;

public class Shop {

    private String name;
    private List<Category> categories;
    private List<PayType> payTypes;
    private ShoppingCart shoppingCart;


    public Shop(String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;

    }

    public Shop(String name, List<Category> categories, List<PayType> payTypes, ShoppingCart shoppingCart) {
        this.name = name;
        this.categories = categories;
        this.payTypes = payTypes;
        this.shoppingCart=shoppingCart;
    }

    public Shop() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<PayType> getPayTypes() {
        return payTypes;
    }

    public void setPayTypes(List<PayType> payTypes) {
        this.payTypes = payTypes;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String toString(){
        return getName();
    }
}
