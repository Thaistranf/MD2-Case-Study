package Services;

import Models.Order;
import Models.OrderDetail;
import Models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderService {
    public static void order(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Thông tin đặt hàng");

        try{
            System.out.print("Tên khách hàng: ");
            String customerName = scanner.nextLine();

            System.out.print("Số điện thoại: ");
            Long phone = Long.parseLong(scanner.nextLine());

            System.out.println("Địa chỉ: ");
            String address = scanner.nextLine();

            Order order = new Order(customerName, phone, address);

            Integer productID = -1;

            while (true){
                System.out.print("Nhập mã của sản phẩm: ");
                productID = scanner.nextInt();

                if (productID.equals(-1)){
                    break;
                }

                System.out.println("Nhập số lượng mua: ");
                Integer quantity = scanner.nextInt();

                Product product = null;

                for (Product item : Main.PRODUCTS) {
                    //Nếu id trong ds giống id người dùng nhập vào để check
                    if (item.getId().equals(productID)){
                        product = item;
                        break;
                    }
                }

                if (product == null){
                    System.out.println("Không tồn tại sản phẩm có mã là: " + productID);
                }

                OrderDetail orderDetail = new OrderDetail(product);
                orderDetail.setOrderID(order.getId());
                orderDetail.setProduct(product);
                orderDetail.setQuantity(quantity);

                //Lưu các orderDetail vào ds order
                order.getOrderDetails().add(orderDetail);
            }

            Main.ORDERS.add(order);

        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void displayOrder(){
        System.out.println("------------------------------Thông tin khách đặt hàng và đơn hàng----------------------------------");
        String header = String.format("%s%20s%20s%20s", "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ");
        System.out.println(header);
        for (Order item : Main.ORDERS) {
            String row = String.format("%d%30s%20d%20s", item.getId(), item.getCustomerName(), item.getPhone(), item.getAddress());
            System.out.println(row);

            String orderDetailHeader = String.format("%s%20s%20s%20s%20s", "Mã đặt hàng", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Tổng giá");
            System.out.println(orderDetailHeader);
            for (OrderDetail item1 : item.getOrderDetails()) {
                String orderDetailrow = String.format("%d%20d%30s%20d%20d", item1.getOrderID(), item1.getProduct().getId(), item1.getProduct().getName(), item1.getQuantity(), item1.getProduct().getPrice() * item1.getQuantity());
                System.out.println(orderDetailrow);
            }
        }
    }
    public static void displayInventory(){
        int quantityAfter;
        System.out.println("----------------------------------Danh sách sản phẩm còn lại trong kho----------------------------------");
        String header = String.format("%s%20s%20s%15s%20s", "Mã", "Tên sản phẩm", "Số lượng", "Giá tiền", "Ghi chú");
        System.out.println(header);
        for (Order order : Main.ORDERS) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                for (Product product : Main.PRODUCTS) {
                    if (orderDetail.getProduct().getId().equals(product.getId())){
                        quantityAfter = product.getQuantity() - orderDetail.getQuantity();
                        String row = String.format("%d%20s%20d%15d%20s", product.getId(), product.getName(), quantityAfter, product.getPrice(), product.getDescription());
                        System.out.println(row);
                    }
                }
            }
        }
    }
}
