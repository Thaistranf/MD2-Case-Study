package Services;

import Models.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductService {
    private final FileManage fileManage;
    public ProductService(FileManage fileManage){

        this.fileManage = fileManage;
    }
    public static void insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm:");

        try{
//            System.out.print("Id: ");
//            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Số lượng: ");
            Integer quantity = scanner.nextInt();

            System.out.print("Giá tiền: ");
            Integer price = scanner.nextInt();

            scanner.nextLine();

            System.out.print("Ghi chú: ");
            String description = scanner.nextLine();

            Product product = new Product(name, quantity, price, description);
            Main.PRODUCTS.add(product);

            //Ghi các thông tin sản phẩm vào file
           // FileManage.writeToFile(Main.PRODUCTS);

        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
    public static void display(){
        System.out.println("----------------------------------Danh sách sản phẩm----------------------------------");
        String header = String.format("%s%20s%20s%15s%20s", "Mã", "Tên sản phẩm", "Số lượng", "Giá tiền", "Ghi chú");
        System.out.println(header);
//        List<Product> PRODUCTS = FileManage.readFromFile();
        for (Product item : Main.PRODUCTS) {
            String row = String.format("%d%20s%20d%15d%20s", item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getDescription());
            System.out.println(row);
        }
//        List<Product> abc = FileManage.readFromFile();
//        for (Product item : abc) {
//            System.out.println(item);
//        }
    }
    public static void update(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Nhập mã của sản phẩm: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            //Tạo 1 đối tượng sản phẩm mới sẽ là sản phẩm sau khi sửa, để so sánh id nhập vào
            Product product = null;

            for (Product item : Main.PRODUCTS) {
                //Nếu id trong ds giống id người dùng nhập vào để check
                if (item.getId().equals(id)){
                    product = item;
                    break;
                }
            }

            if (product == null){
                System.out.println("Không tồn tại sản phẩm có mã là: " + id);
            }

            //Hiển thị ds sản phẩm có id check
            System.out.println("----------------------------------Danh sách sản phẩm----------------------------------");
            String header = String.format("%s%20s%20s%15s%20s", "Mã", "Tên sản phẩm", "Số lượng", "Giá tiền", "Ghi chú");
            System.out.println(header);
            assert product != null;
            String row = String.format("%d%20s%20d%15d%20s", product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
            System.out.println(row);

            //Nhập thông tin mới cho sản phẩm
            for (int i = 0; i < Main.PRODUCTS.size(); i++) {
                //Nếu giá trị id nhập vào giống id trong ds thì nhập thông tin mới cho sản phẩm
                if (id.equals(Main.PRODUCTS.get(i).getId())){
                    System.out.print("Tên sản phẩm: ");
                    String name = scanner.nextLine();

                    System.out.print("Số lượng: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Giá tiền: ");
                    int price = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Ghi chú: ");
                    String description = scanner.nextLine();

                    Main.PRODUCTS.get(i).setName(name);
                    Main.PRODUCTS.get(i).setQuantity(quantity);
                    Main.PRODUCTS.get(i).setPrice(price);
                    Main.PRODUCTS.get(i).setDescription(description);
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void remove(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Nhập mã của sản phẩm cần xóa: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            //Tạo 1 đối tượng sản phẩm mới sẽ là sản phẩm sau khi sửa, để so sánh id nhập vào
            Product product = null;

            for (Product item : Main.PRODUCTS) {
                //Nếu id trong ds giống id người dùng nhập vào để check
                if (item.getId().equals(id)){
                    product = item;
                    break;
                }
            }

            if (product == null){
                System.out.println("Không tồn tại sản phẩm có mã là: " + id);
            }

            //Hiển thị ds sản phẩm có id check
            System.out.println("----------------------------------Thông tin sản phẩm cần xóa----------------------------------");
            String header = String.format("%s%20s%20s%15s%20s", "Mã", "Tên sản phẩm", "Số lượng", "Giá tiền", "Ghi chú");
            System.out.println(header);
            assert product != null;
            String row = String.format("%d%20s%20d%15d%20s", product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
            System.out.println(row);

            //Duyệt ds và xóa
            for (Product item : Main.PRODUCTS) {
                //Nếu id trong ds giống id người dùng nhập vào để check
                if (item.getId().equals(id)){
                    Main.PRODUCTS.remove(product);
                    break;
                }
            }
            //Hiển thị ds sau khi xóa
            display();

        } catch (InputMismatchException e) {
            System.out.println("Nhập sai giá trị, vui lòng nhập lại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


}
