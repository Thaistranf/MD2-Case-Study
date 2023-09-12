package Services;

import Models.Order;
import Models.Product;
import Services.ProductService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> PRODUCTS = new ArrayList<>();
    public static List<Order> ORDERS = new ArrayList<>();
    public static void menu(){
        System.out.println("----------Danh sách chức năng----------");
        System.out.println("1. Thêm mới sản phẩm");
        System.out.println("2. Hiển thị sản phẩm");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Mua hàng");
        System.out.println("6. Hiển thị thông tin đặt hàng");
        System.out.println("7. Hiển thị số lượng hàng còn lại trong kho");
        System.out.println("8. Thoát");

    }
    public static void main(String[] args) {
        int function = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            menu();
            try{
                System.out.print("Mời nhập lựa chọn: ");
                function = scanner.nextInt();
                switch (function){
                    case 1:
                        ProductService.insert();
                        break;
                    case 2:
                        ProductService.display();
                        break;
                    case 3:
                        ProductService.update();
                        break;
                    case 4:
                        ProductService.remove();
                        break;
                    case 5:
                        OrderService.order();
                        break;
                    case 6:
                        OrderService.displayOrder();
                        break;
                    case 7:
                        OrderService.displayInventory();
                        break;
                }

            } catch (InputMismatchException err) {
                System.out.println("Nhập sai lựa chọn, vui lòng nhập lại");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } while (function != 8);
        System.out.println("See you late!");
    }
}