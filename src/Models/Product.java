package Models;

public class Product {
    public static Integer INDEX = 0;
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;
    private String description;

    public Product(String name, Integer quantity, Integer price, String description) {
        this.id = ++INDEX;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id+";"+name+";"+quantity+";"+price+";"+description;
    }
}
