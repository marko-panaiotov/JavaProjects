package structure;

import java.util.List;

public class ShoppingCart implements CollectionManager<SelectedProducts>{

    private List<SelectedProducts> selectedProducts;

    public ShoppingCart(List<SelectedProducts> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void addProduct(SelectedProducts newSelectedProducts){
        selectedProducts.add(newSelectedProducts);
    }

    public void removeProduct(SelectedProducts removeSelectedProducts){
        selectedProducts.remove(removeSelectedProducts);
    }
    public List<SelectedProducts> getSelectedProducts() {
        return selectedProducts;
    }
    public void setSelectedProducts(List<SelectedProducts> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

}
