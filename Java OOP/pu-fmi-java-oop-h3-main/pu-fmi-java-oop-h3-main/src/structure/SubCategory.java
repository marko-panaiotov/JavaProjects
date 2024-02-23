package structure;

import java.util.List;

public class SubCategory {

    private String name;
    private List<Product> productsList;

    public SubCategory() {
    }

    public SubCategory(String name,List<Product> productsList) {
        this.name = name;
        this.productsList = productsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public String toString(){
        return name;
    }

}
