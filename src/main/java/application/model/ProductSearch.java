package application.model;

public class ProductSearch {

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public ProductSearch(String input) {
        this.input = input;
    }

    public ProductSearch() {
    }

    @Override
    public String toString() {
        return "ProductSearch{" +
                "input='" + input + '\'' +
                '}';
    }
}
