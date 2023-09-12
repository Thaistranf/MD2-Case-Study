package Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static Integer INDEX = 0;
    private Integer id;
    private String customerName;
    private Long phone;
    private String address;
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order(String customerName, Long phone, String address) {
        this.id = ++INDEX;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
