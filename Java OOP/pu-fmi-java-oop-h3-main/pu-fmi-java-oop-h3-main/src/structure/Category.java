package structure;

import java.util.List;

public class Category {
    private String name;
    private List<SubCategory> subCategoriesList;


    public Category(String name) {
        this.name = name;

    }

    public Category(String name, List<SubCategory> subCategoriesList) {
        this.name = name;
        this.subCategoriesList = subCategoriesList;
    }

    public Category(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCategory> getSubCategoriesList() {
        return subCategoriesList;
    }

    public void setSubCategoriesList(List<SubCategory> subCategoriesList) {
        this.subCategoriesList = subCategoriesList;
    }

    public String toString(){
        return getName();
    }
}
