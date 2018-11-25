package application.model;

public class ProductSearch {

    private String input;

    private String whatToSearch;

    public ProductSearch(String input, String whatToSearch) {
        this.input = input;
        this.whatToSearch = whatToSearch;
    }

    public String getWhatToSearch() {
        return whatToSearch;
    }

    public void setWhatToSearch(String whatToSearch) {
        this.whatToSearch = whatToSearch;
    }

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
